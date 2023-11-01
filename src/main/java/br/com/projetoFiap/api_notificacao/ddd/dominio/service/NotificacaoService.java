package br.com.projetoFiap.api_notificacao.ddd.dominio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoFiap.api_notificacao.ddd.dominio.acl.ConfiguracaoMensageria;
import br.com.projetoFiap.api_notificacao.ddd.dominio.dto.NotificacaoDTO;
import br.com.projetoFiap.api_notificacao.ddd.infraestrutura.NotificacaoRepository;

@Service
public class NotificacaoService {

	@Autowired
	NotificacaoRepository notificacaoRepository;
	NotificacaoDTO notificacaoDTO = new NotificacaoDTO();

	public NotificacaoDTO buscarNotificacaoPorId(Long id) {
		var notificacao = notificacaoRepository.findById(id);
		if (notificacao.isPresent()) {
			return notificacaoDTO.coverterNotificacaoEmDTO(notificacao.get());
		}
		return null;
	}

	public List<NotificacaoDTO> buscarNotificacoes() {
		var notificacao = notificacaoRepository.findAll();
		return notificacao.stream().map(notificacaoDTO::coverterNotificacaoEmDTO)
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public NotificacaoDTO salvarNoticacao(NotificacaoDTO notificacaoDTO) {
		var notificacao = notificacaoDTO.coverterDTOEmNotificacao(notificacaoDTO);
		new ConfiguracaoMensageria().enviaWhatssap(notificacao.getTelefone(), notificacao.getMensagem());
		var notificacaoSalva = notificacaoRepository.save(notificacao);
		return notificacaoDTO.coverterNotificacaoEmDTO(notificacaoSalva);
	}

	public List<NotificacaoDTO> buscarNotificacaoAtivas(String telefone) {
		var notificacao = notificacaoRepository.findByTelefone(telefone);
		return notificacao.stream().map(notificacaoDTO::coverterNotificacaoEmDTO)
				.collect(Collectors.toCollection(ArrayList::new));
	}
	

	public void deleteById(Long id) {
		notificacaoRepository.deleteById(id);
	}

}
