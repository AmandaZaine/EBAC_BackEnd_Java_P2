package main.dao;

import main.dao.generic.GenericDb2DAO;
import main.domain.Cliente;

public class ClienteDb2DAO extends GenericDb2DAO<Cliente, Long> implements IClienteDAO<Cliente> {

    public ClienteDb2DAO() {
        super(Cliente.class);
    }

}
