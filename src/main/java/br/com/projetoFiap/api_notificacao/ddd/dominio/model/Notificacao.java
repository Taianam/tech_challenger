package br.com.projetoFiap.api_notificacao.ddd.dominio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;

@Entity
public class Notificacao {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="notificacao_sequence")
	@SequenceGenerator(name="notificacao_sequence", sequenceName="not_seq")
	private Long id;
	@NotNull
	private String mensagem;
	@NotNull
	private String telefone;
	private Boolean ativo;
	
	
	public Notificacao() {}
	public Notificacao(Long id, @NotNull String mensagem, @NotNull String telefone) {
		super();
		this.id = id;
		this.mensagem = mensagem;
		this.telefone = telefone;
		this.ativo = true;
	}
	
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public Long getId() {
		return id;
	}
	
	
	
	
}
