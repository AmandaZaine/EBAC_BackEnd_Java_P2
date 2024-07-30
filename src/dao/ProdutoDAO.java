package dao;

import dao.generic.GenericDAO;
import domain.Produto;

public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO {

    public ProdutoDAO() {
        super(Produto.class);
    }

}