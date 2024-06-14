package dao;


import dao.generic.GenericDAO;
import domain.Cliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

    public ClienteDAO() {
        super();
    }

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualizarDados(Cliente entity, Cliente entityCadastrado) {
        entityCadastrado.setCpf(entity.getCpf());
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setTelefone(entity.getTelefone());
        entityCadastrado.setVip(entity.getVip());
    }

    @Override
    protected String getQueryInsercao() {
        return "INSERT INTO CLIENTE (ID, CPF, NOME, TELEFONE, VIP) VALUES (nextval('sq_cliente'),?,?,?,?)";
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Cliente cliente) throws SQLException {
        stmInsert.setLong(1, cliente.getCpf());
        stmInsert.setString(2, cliente.getNome());
        stmInsert.setString(3, cliente.getTelefone());
        stmInsert.setBoolean(4,cliente.getVip());
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM CLIENTE WHERE CPF = ?";
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, Long valor) throws SQLException {
        stmExclusao.setLong(1, valor);
    }

    @Override
    protected String getQueryAtualizacao() {
        return "UPDATE CLIENTE SET NOME = ?, TELEFONE = ?, VIP = ? WHERE CPF = ?;";
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Cliente cliente) throws SQLException {
        stmUpdate.setString(1, cliente.getNome());
        stmUpdate.setString(2, cliente.getTelefone());
        stmUpdate.setBoolean(3,cliente.getVip());
        stmUpdate.setLong(4, cliente.getCpf());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmSelect, Long valor) throws SQLException {
        stmSelect.setLong(1, valor);
    }

}