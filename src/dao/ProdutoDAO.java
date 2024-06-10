package dao;

import domain.Cliente;
import domain.Produto;
import jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {
    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null; // Conexão com o BD
        PreparedStatement preparedStatement = null; // Comando que será executado no BD

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO produto (codigo, nome, descricao) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, produto.getCodigo());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setString(3, produto.getDescricao());
            return preparedStatement.executeUpdate();
        } finally {
            closeConnection(connection, preparedStatement, null);
        }
    }

    @Override
    public Integer alterar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null; // Comando que será executado no BD

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE produto SET NOME = ?, descricao = ? WHERE codigo = ?";
            preparedStatement = connection.prepareStatement(sql); // Compila o comando SQL e verifica se o comando está correto
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getDescricao());
            preparedStatement.setString(3, produto.getCodigo());
            return preparedStatement.executeUpdate();
        } finally {
            closeConnection(connection, preparedStatement, null);
        }
    }

    @Override
    public Produto buscar(String codigo) throws Exception {
        Connection connection = null; // Conexão com o BD
        PreparedStatement preparedStatement = null; // Comando que será executado no BD
        ResultSet resultSet;  // É o retorno no BD
        Produto produto = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM produto WHERE codigo = ?";
            preparedStatement = connection.prepareStatement(sql);  // Compila e verifica o comando SQL
            preparedStatement.setString(1, codigo);
            resultSet = preparedStatement.executeQuery();  // Executa o comando SQL e retorna o resultado

            if(resultSet.next()) {
                produto = new Produto();
                String codigoResult = resultSet.getString("codigo");
                String nome = resultSet.getString("NOME");
                String descricao = resultSet.getString("descricao");
                produto.setCodigo(codigoResult);
                produto.setNome(nome);
                produto.setDescricao(descricao);
            }
        } finally {
            closeConnection(connection, preparedStatement, null);
        }
        return produto;
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        Connection connection = null;  // Conexão com o BD
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Produto> produtos = new ArrayList<>();
        Produto produto;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "select * from produto";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();  // Executa o comando e retorna o resultado

            while (resultSet.next()) {  // Loop para mapear todos os produtos retornados
                produto = new Produto();
                produto.setCodigo(resultSet.getString("codigo"));
                produto.setNome(resultSet.getString("nome"));
                produto.setDescricao(resultSet.getString("descricao"));
                produtos.add(produto);
            }
        } finally {
            closeConnection(connection, preparedStatement, resultSet);
        }
        return produtos;
    }

    @Override
    public Integer excluir(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null; // Comando que será executado no BD

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "delete from produto where codigo = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, produto.getCodigo());
            Integer quantidadeExcluida = preparedStatement.executeUpdate();
            return quantidadeExcluida;
        } finally {
            closeConnection(connection, preparedStatement, null);
        }
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
