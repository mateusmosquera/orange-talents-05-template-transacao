package br.com.zupacademy.mateus.transacao.repository;

import br.com.zupacademy.mateus.transacao.model.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TransacaoRepository extends CrudRepository<Transacao,String> {

    Page<Transacao> findAllByCartaoId(String id, Pageable page);

    List<Transacao> findAllByCartaoId(String id);

    Optional<Transacao> findByCartaoId(String id);
}
