package br.com.projetoFiap.api_notificacao.ddd.dominio.dto;

import java.time.LocalDateTime;

import br.com.projetoFiap.api_notificacao.ddd.dominio.model.Documento;
import br.com.projetoFiap.api_notificacao.ddd.dominio.model.Notificacao;


public class DocumentoDTO {
	private Long id;
	private String extencao;
	private String nomeArquivo;
	private LocalDateTime dataEnvio;
	private String arquivo;
	private Notificacao notificacao;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getExtencao() {
		return extencao;
	}
	
	public void setExtencao(String extencao) {
		this.extencao = extencao;
	}
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	public LocalDateTime getDataEnvio() {
		return dataEnvio;
	}
	
	public void setDataEnvio(LocalDateTime dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	
	public Notificacao getNotificacao() {
		return notificacao;
	}
	
	
	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public void setNotificacao(Notificacao notificacao) {
		this.notificacao = notificacao;
	}
	
	public Documento coverterDTOEmDocumento(DocumentoDTO documentoDto) {

		var documento = new Documento();
		documento.setId(documentoDto.getId());
		documento.setDataEnvio(documentoDto.getDataEnvio());
		documento.setExtencao(documentoDto.getExtencao());
		documento.setNomeArquivo(documentoDto.getNomeArquivo());
		documento.setArquivo(documentoDto.getArquivo());
		documento.setNotificacao(documentoDto.getNotificacao());

		return documento;
	}

	public DocumentoDTO coverterDocumnetoEmDTO(Documento documento) {

		var documentoDto = new DocumentoDTO();
		documentoDto.setId(documento.getId());
		documentoDto.setDataEnvio(documento.getDataEnvio());
		documentoDto.setExtencao(documento.getExtencao());
		documentoDto.setNomeArquivo(documento.getNomeArquivo());
		documentoDto.setArquivo(documento.getArquivo());
		documentoDto.setNotificacao(documento.getNotificacao());

		return documentoDto;
	}

}
