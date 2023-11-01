package br.com.projetoFiap.api_notificacao.ddd.aplicacao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.projetoFiap.api_notificacao.ddd.dominio.dto.DocumentoDTO;
import br.com.projetoFiap.api_notificacao.ddd.dominio.service.DocumentoService;

@Controller
@RequestMapping(value = "/api/documento")
public class DocumentoController {

	@Autowired
	private DocumentoService documentoService;

	@GetMapping
	public ResponseEntity<List<DocumentoDTO>> obter() {
		var documentos= this.documentoService.buscarDocumentos();
		return new ResponseEntity<List<DocumentoDTO>>(documentos,HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<DocumentoDTO> obterPorId(@PathVariable(value = "id") Long id) {
		var documento = this.documentoService.buscarDocumentoPorId(id);
		if (documento == null) {
			return new ResponseEntity<DocumentoDTO>(documento, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<DocumentoDTO>(documento, HttpStatus.OK);

	}
	
	@PostMapping("/webhook")
	public ResponseEntity<DocumentoDTO> adicionar(@RequestParam Map<String, String> body) {
		var documentoAdicionado = this.documentoService.salvarDocumento(body);
		return new ResponseEntity<DocumentoDTO>(documentoAdicionado, HttpStatus.CREATED);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<DocumentoDTO> deletar(@PathVariable(value = "id") Long id) {
		this.documentoService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 
	}
	

}
