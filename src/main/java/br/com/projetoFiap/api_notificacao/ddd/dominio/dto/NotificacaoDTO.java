package br.com.projetoFiap.api_notificacao.ddd.dominio.dto;

import br.com.projetoFiap.api_notificacao.ddd.dominio.model.Notificacao;

public class NotificacaoDTO {

	private Long id;
	private String mensagem;
	private String telefone;
	private Boolean ativo;

	public NotificacaoDTO(Long id, String mensagem, String telefone) {
		super();
		this.id = id;
		this.mensagem = mensagem;
		this.telefone = telefone;
		this.ativo = true;
	}

	public NotificacaoDTO() {}
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

	public Notificacao coverterDTOEmNotificacao(NotificacaoDTO notificacaoDTO) {

		var notificacao = new Notificacao(notificacaoDTO.id, 
				notificacaoDTO.mensagem, notificacaoDTO.telefone);
		notificacao.setAtivo(notificacaoDTO.ativo);

		return notificacao;
	}

	public NotificacaoDTO coverterNotificacaoEmDTO(Notificacao notificacao) {

		var notificacaoDto = new NotificacaoDTO(notificacao.getId(), 
				notificacao.getMensagem(), notificacao.getTelefone());
		notificacaoDto.setAtivo(notificacao.getAtivo());

		return notificacaoDto;
	}
}
