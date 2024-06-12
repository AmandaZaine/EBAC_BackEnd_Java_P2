package dao.factory;

import domain.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoFactory {
    public static Produto convert(ResultSet rs) throws SQLException {
        Produto prod = new Produto();
        prod.setId(rs.getLong("ID"));
        prod.setCodigo(rs.getString("CODIGO"));
        prod.setNome(rs.getString("NOME"));
        prod.setValor(rs.getBigDecimal("VALOR"));
        return prod;
    }
}
