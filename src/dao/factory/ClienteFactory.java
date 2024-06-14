package dao.factory;

import domain.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteFactory {

    public static Cliente convert(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getLong("ID_CLIENTE"));
        cliente.setNome(rs.getString(("NOME")));
        cliente.setCpf(rs.getLong(("CPF")));
        cliente.setTelefone(rs.getString(("TELEFONE")));
        return cliente;
    }
}
