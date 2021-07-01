package br.com.zupacademy.mateus.transacao.controller;

import br.com.zupacademy.mateus.transacao.config.exceptions.ApiErroException;
import br.com.zupacademy.mateus.transacao.model.Transacao;
import br.com.zupacademy.mateus.transacao.repository.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacoes")
public class TransacoesController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    private final Logger logger = LoggerFactory.getLogger(TransacoesController.class);

    @GetMapping
    public Page<Transacao> consultar(@PathParam("id") String id,
                                                     @PageableDefault(sort = "efetivadaEm", direction = Sort.Direction.DESC,size = 10,page = 0) Pageable paginacao){

        Page<Transacao> transacoes = transacaoRepository.findAllByCartaoId(id,paginacao);

        if(transacoes.isEmpty()) {
            throw new ApiErroException(HttpStatus.NOT_FOUND, "Id do cartão não encontrado");
        }

        return transacoes;
    }
}
