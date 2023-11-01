package br.com.projetoFiap.api_notificacao.ddd.dominio.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Documento {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="documento_sequence")
	@SequenceGenerator(name="documento_sequence", sequenceName="doc_seq")
	private Long id;
	private String extencao;
	private String nomeArquivo;
	private LocalDateTime dataEnvio;
	private String arquivo;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_notificacao", referencedColumnName = "id")
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
	
	
	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public Notificacao getNotificacao() {
		return notificacao;
	}
	
	public void setNotificacao(Notificacao notificacao) {
		this.notificacao = notificacao;
	}

}
