package br.com.zupacademy.mateus.transacao.repository;

import br.com.zupacademy.mateus.transacao.model.Transacao;
import org.springframework.data.repository.CrudRepository;

public interface TransacaoRepository extends CrudRepository<Transacao,String> {
}
