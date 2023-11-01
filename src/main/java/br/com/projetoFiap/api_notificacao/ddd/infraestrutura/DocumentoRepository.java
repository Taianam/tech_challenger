package br.com.projetoFiap.api_notificacao.ddd.infraestrutura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetoFiap.api_notificacao.ddd.dominio.model.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long>{

}
