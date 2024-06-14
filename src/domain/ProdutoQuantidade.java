package domain;

import annotations.ColunaTabela;
import annotations.Tabela;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;

@Tabela("produto_quantidade")
public class ProdutoQuantidade {

    @ColunaTabela(dbName = "id", setJavaName = "setId")
    private Long id;

    private Produto produto;

    private Venda venda;

    @ColunaTabela(dbName = "quantidade", setJavaName = "setQuantidade")
    private Integer quantidade;

    @ColunaTabela(dbName = "valor_total", setJavaName = "setValorTotal")
    private BigDecimal valorTotal;

    public ProdutoQuantidade() {
        this.quantidade = 0;
        this.valorTotal = ZERO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void adicionar(Integer quantidade) {
        this.quantidade += quantidade;
        this.valorTotal = this.produto.getValor().multiply(valueOf(this.quantidade));
    }

    public void remover(Integer quantidade) {
        this.quantidade -= quantidade;
        this.valorTotal = this.produto.getValor().multiply(valueOf(quantidade));
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
}
