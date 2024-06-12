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
    }

    @Override
    protected String getQueryInsercao() {
        return "INSERT INTO PRODUTO (ID, CODIGO, NOME, VALOR) VALUES (nextval('sq_produto'),?,?,?)";
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Produto produto) throws SQLException {
        stmInsert.setString(1, produto.getCodigo());
        stmInsert.setString(2, produto.getNome());
        stmInsert.setBigDecimal(3, produto.getValor());
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
        return "UPDATE PRODUTO SET CODIGO = ?, NOME = ?, VALOR = ? WHERE CODIGO = ?";
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Produto entity) throws SQLException {
        stmUpdate.setString(1, entity.getCodigo());
        stmUpdate.setString(2, entity.getNome());
        stmUpdate.setBigDecimal(4, entity.getValor());
        stmUpdate.setString(5, entity.getCodigo());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmExclusao, String valor) throws SQLException {
        stmExclusao.setString(1, valor);
    }

}