package dao;

import dao.generic.GenericDAO;
import domain.Produto;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO {

    public ProdutoDAO() {
        super();
    }

    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public void atualizarDados(Produto produto, Produto produtoCadastrado) {
        produtoCadastrado.setCodigo(produto.getCodigo());
        produtoCadastrado.setNome(produto.getNome());
        produtoCadastrado.setValor(produto.getValor());
        produtoCadastrado.setMarca(produto.getMarca());
    }

    @Override
    protected String getQueryInsercao() {
        return "INSERT INTO PRODUTO (ID, CODIGO, NOME, VALOR, MARCA) VALUES (nextval('sq_produto'),?,?,?,?)";
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Produto produto) throws SQLException {
        stmInsert.setString(1, produto.getCodigo());
        stmInsert.setString(2, produto.getNome());
        stmInsert.setBigDecimal(3, produto.getValor());
        stmInsert.setString(4,produto.getMarca());
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM PRODUTO WHERE CODIGO = ?";
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, String valor) throws SQLException {
        stmExclusao.setString(1, valor);
    }

    @Override
    protected String getQueryAtualizacao() {
        return "UPDATE PRODUTO SET NOME = ?, VALOR = ?, MARCA = ? WHERE CODIGO = ?";
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Produto produto) throws SQLException {
        stmUpdate.setString(1, produto.getNome());
        stmUpdate.setBigDecimal(2, produto.getValor());
        stmUpdate.setString(3, produto.getMarca());
        stmUpdate.setString(4, produto.getCodigo());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmExclusao, String valor) throws SQLException {
        stmExclusao.setString(1, valor);
    }

}