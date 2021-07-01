package br.com.zupacademy.mateus.transacao.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    private String id;

    private BigDecimal valor;

    private String  estabelecimentoNome;

    private String estabelecimentoCidade;

    private String estabelecimentoEndereco;

    private String cartaoId;

    private String cartaoEmail;

    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao(){

    }

    public Transacao(String id,BigDecimal valor, String estabelecimentoNome, String estabelecimentoCidade, String estabelecimentoEndereco, String cartaoId, String cartaoEmail, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimentoNome = estabelecimentoNome;
        this.estabelecimentoCidade = estabelecimentoCidade;
        this.estabelecimentoEndereco = estabelecimentoEndereco;
        this.cartaoId = cartaoId;
        this.cartaoEmail = cartaoEmail;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getEstabelecimentoNome() {
        return estabelecimentoNome;
    }

    public String getEstabelecimentoCidade() {
        return estabelecimentoCidade;
    }

    public String getEstabelecimentoEndereco() {
        return estabelecimentoEndereco;
    }

    public String getCartaoId() {
        return cartaoId;
    }

    public String getCartaoEmail() {
        return cartaoEmail;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
