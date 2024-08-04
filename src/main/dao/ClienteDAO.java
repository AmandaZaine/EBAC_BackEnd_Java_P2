package main.dao;

import main.dao.generic.GenericDb1DAO;
import main.domain.Cliente;

public class ClienteDAO extends GenericDb1DAO<Cliente, Long> implements IClienteDAO<Cliente> {

    public ClienteDAO() {
        super(Cliente.class);
    }

}