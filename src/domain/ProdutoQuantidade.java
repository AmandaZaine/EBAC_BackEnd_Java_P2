package domain;

import javax.persistence.*;
import java.math.BigDecimal;

import static java.math.BigDecimal.*;

@Entity
public class ProdutoQuantidade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_quant_seq")
    @SequenceGenerator(name = "prod_quant_seq", sequenceName = "seq_prod_quant", initialValue = 1, allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Produto produto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "id_venda",
            foreignKey = @ForeignKey(name = "fk_prod_quant_venda"),
            referencedColumnName = "id"
    )
    private Venda venda;

    @Column
    private Integer quantidade;

    @Column
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
