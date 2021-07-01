package br.com.zupacademy.mateus.transacao.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public class EventoDeTransacao {

    @JsonProperty
    private String id;
    @JsonProperty
    private BigDecimal valor;
    @JsonProperty
    private Estabelecimento estabelecimento;
    @JsonProperty
    private Cartao cartao;
    @JsonProperty
    private LocalDateTime efetivadaEm;

    @Deprecated
    public EventoDeTransacao(){

    }

    public EventoDeTransacao(@JsonProperty("id") String id,
                             @JsonProperty("valor") BigDecimal valor,
                             @JsonProperty("estabelecimento") Estabelecimento estabelecimento,
                             @JsonProperty("cartao") Cartao cartao,
                             @JsonProperty("efetivadaEm") LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public Transacao toModel() {
        return new Transacao(this.id,this.valor,this.estabelecimento.nome,this.estabelecimento.cidade,
                        this.estabelecimento.endereco,this.cartao.id,
                        this.cartao.email,this.efetivadaEm);
    }

    public static class Estabelecimento {
        @NotBlank
        @JsonProperty
        private String nome;
        @NotBlank
        @JsonProperty
        private String cidade;
        @NotBlank
        @JsonProperty
        private String endereco;

        @Deprecated
        public Estabelecimento(){}

        public Estabelecimento(String nome, String cidade, String endereco) {
            this.nome = nome;
            this.cidade = cidade;
            this.endereco = endereco;
        }
    }

    public static class Cartao{
        @NotBlank
        @JsonProperty
        private String id;

        @NotBlank
        @Email
        @JsonProperty
        private String email;

        @Deprecated
        public Cartao(){}

        public Cartao(String id, String email) {
            this.id = id;
            this.email = email;
        }
    }

}
