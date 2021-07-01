package br.com.zupacademy.mateus.transacao.kafka;

import br.com.zupacademy.mateus.transacao.model.EventoDeTransacao;
import br.com.zupacademy.mateus.transacao.model.Transacao;
import br.com.zupacademy.mateus.transacao.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {


    private TransacaoRepository transacaoRepository;

    public ListenerDeTransacao(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoDeTransacao eventoDeTransacao) {

        Transacao newTrasacao = eventoDeTransacao.toModel();

        transacaoRepository.save(newTrasacao);
    }

}
