package dao;

import domain.Cliente;
import jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO {

    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {
        Connection connection = null; // Conexão com o BD
        PreparedStatement preparedStatement = null; // Comando que será executado no BD

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO CLIENTE (CPF, NOME, TELEFONE) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getCpf());
            preparedStatement.setString(2, cliente.getNome());
            preparedStatement.setString(3, cliente.getTelefone());
            return preparedStatement.executeUpdate();
        } finally {
            closeConnection(connection, preparedStatement, null);
        }
    }

    @Override
    public Integer alterar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null; // Comando que será executado no BD

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE CLIENTE SET NOME = ?, TELEFONE = ? WHERE CPF = ?";
            preparedStatement = connection.prepareStatement(sql); // Compila o comando SQL e verifica se o comando está correto
            preparedStatement.setString(1,cliente.getNome());
            preparedStatement.setString(2, cliente.getTelefone());
            preparedStatement.setString(3, cliente.getCpf());
            return preparedStatement.executeUpdate();
        } finally {
            closeConnection(connection, preparedStatement, null);
        }
    }

    @Override
    public Cliente buscar(String cpf) throws Exception {
        Connection connection = null; // Conexão com o BD
        PreparedStatement preparedStatement = null; // Comando que será executado no BD
        ResultSet resultSet;  // É o retorno no BD
        Cliente cliente = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM CLIENTE WHERE CPF = ?";
            preparedStatement = connection.prepareStatement(sql);  // Compila e verifica o comando SQL
            preparedStatement.setString(1, cpf);
            resultSet = preparedStatement.executeQuery();  // Executa o comando SQL e retorna o resultado

            if(resultSet.next()) {
                cliente = new Cliente();
                String cpfResultSet = resultSet.getString("CPF");
                String nome = resultSet.getString("NOME");
                String telefone = resultSet.getString("TELEFONE");
                cliente.setCpf(cpfResultSet);
                cliente.setNome(nome);
                cliente.setTelefone(telefone);
            }
        } finally {
            closeConnection(connection, preparedStatement, null);
        }
        return cliente;
    }

    @Override
    public Integer excluir(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null; // Comando que será executado no BD

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "delete from cliente where cpf = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getCpf());
            Integer quantidadeExcluida = preparedStatement.executeUpdate();
            return quantidadeExcluida;
        } finally {
            closeConnection(connection, preparedStatement, null);
        }
    }

    @Override
    public List<Cliente> buscarTodos() throws Exception {
        Connection connection = null;  // Conexão com o BD
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "select * from cliente";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();  // Executa o comando e retorna o resultado

            while (resultSet.next()) {  // Loop para mapear todos os clientes retornados
                cliente = new Cliente();
                cliente.setCpf(resultSet.getString("CPF"));
                cliente.setNome(resultSet.getString("NOME"));
                cliente.setTelefone(resultSet.getString("TELEFONE"));
                clientes.add(cliente);
            }
        } finally {
            closeConnection(connection, preparedStatement, resultSet);
        }
        return clientes;
    }

    private void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet)
            throws SQLException {
        if (resultSet != null && !resultSet.isClosed()) {
            resultSet.close();
        }

        if (preparedStatement != null && !preparedStatement.isClosed()) {
            preparedStatement.close();
        }

        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

}