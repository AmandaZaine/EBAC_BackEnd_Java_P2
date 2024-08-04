package main.dao;

import main.dao.generic.GenericDAO;
import main.domain.Produto;

public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO {

    public ProdutoDAO() {
        super(Produto.class, "postgresql1");
    }

}