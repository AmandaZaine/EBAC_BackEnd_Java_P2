package main.dao;

import main.dao.generic.GenericDb3DAO;
import main.domain.Cliente;

public class ClienteDb3DAO extends GenericDb3DAO<Cliente, Long> implements IClienteDAO<Cliente> {

    public ClienteDb3DAO() {
        super(Cliente.class);
    }

}