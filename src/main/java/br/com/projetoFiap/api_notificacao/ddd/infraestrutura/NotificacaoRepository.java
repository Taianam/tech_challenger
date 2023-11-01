package br.com.projetoFiap.api_notificacao.ddd.infraestrutura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetoFiap.api_notificacao.ddd.dominio.model.Notificacao;
import java.util.List;


@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long>{

	public List<Notificacao> findByTelefone(String telefone);
}
