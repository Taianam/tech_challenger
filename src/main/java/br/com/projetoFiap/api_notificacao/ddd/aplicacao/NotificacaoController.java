package br.com.projetoFiap.api_notificacao.ddd.aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.projetoFiap.api_notificacao.ddd.dominio.dto.NotificacaoDTO;
import br.com.projetoFiap.api_notificacao.ddd.dominio.service.NotificacaoService;

@Controller
@RequestMapping(value = "/api/notificacao")
public class NotificacaoController {

	@Autowired
	private NotificacaoService notificacaoService;

	@GetMapping
	public ResponseEntity<List<NotificacaoDTO>> obter() {
		var notificacoes= this.notificacaoService.buscarNotificacoes();
		return new ResponseEntity<List<NotificacaoDTO>>(notificacoes,HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<NotificacaoDTO> obterPorId(@PathVariable(value = "id") Long id) {
		var noticacao = this.notificacaoService.buscarNotificacaoPorId(id);
		if (noticacao == null) {
			return new ResponseEntity<NotificacaoDTO>(noticacao, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<NotificacaoDTO>(noticacao, HttpStatus.OK);

	}
	
	@PostMapping
	public ResponseEntity<NotificacaoDTO> adicionar(@RequestBody NotificacaoDTO notificacao) {
		var notificacaoAdicionada = notificacaoService.salvarNoticacao(notificacao);
		return new ResponseEntity<NotificacaoDTO>(notificacaoAdicionada, HttpStatus.CREATED);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<NotificacaoDTO> deletar(@PathVariable(value = "id") Long id) {
		this.notificacaoService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 
	}
	

}
