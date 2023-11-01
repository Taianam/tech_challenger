package br.com.projetoFiap.api_notificacao.ddd.dominio.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;

import br.com.projetoFiap.api_notificacao.ddd.dominio.dto.DocumentoDTO;
import br.com.projetoFiap.api_notificacao.ddd.dominio.model.Documento;
import br.com.projetoFiap.api_notificacao.ddd.infraestrutura.DocumentoRepository;

@Service
public class DocumentoService {

	@Autowired
	DocumentoRepository documentoRepository;
	DocumentoDTO documentoDto = new DocumentoDTO();

	public DocumentoDTO buscarDocumentoPorId(Long id) {
		var documento = documentoRepository.findById(id);
		if (documento.isPresent()) {
			return documentoDto.coverterDocumnetoEmDTO(documento.get());
		}
		return null;
	}

	public List<DocumentoDTO> buscarDocumentos() {
		var documento = documentoRepository.findAll();
		return documento.stream().map(documentoDto::coverterDocumnetoEmDTO)
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public DocumentoDTO salvarDocumento(Map<String, String> body ) {
		var documento = new Documento();
		var numMedia = Integer.parseInt(body.get("NumMedia"));
	        var twimlResponse = new MessagingResponse.Builder();
	        if (numMedia > 0) {
	   	     var base64 = body.get("MediaUrl0");
	   	     documento.setArquivo(base64);
	   	     documento.setExtencao(body.get("MediaContentType0"));
	   	     documento.setNomeArquivo(body.get("From"));
	   	     documento.setDataEnvio(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
	            twimlResponse.message(
	                    new Message.Builder().body(new Body.Builder("Obrigada por encaminhar imagem").build()).build());
	        } else {
	            twimlResponse.message(new Message.Builder().body(new Body.Builder("Estamos ainda aguardando o documento").build()).build());
	        }
		var documentoSalvo = documentoRepository.save(documento);
		return this.documentoDto.coverterDocumnetoEmDTO(documentoSalvo);
	}


	public void deleteById(Long id) {
		documentoRepository.deleteById(id);
	}

}
