package test;


import main.dao.ClienteDb2DAO;
import main.dao.ClienteDAO;
import main.dao.ClienteDb3DAO;
import main.dao.IClienteDAO;
import main.domain.Cliente;
import main.exceptions.DAOException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

public class ClienteDAO2BdsTest {

    private IClienteDAO<Cliente> clienteDao;
    private IClienteDAO<Cliente> clienteBd2Dao;
    private IClienteDAO<Cliente> clienteBd3Dao;

    public ClienteDAO2BdsTest() {
        this.clienteDao = new ClienteDAO();
        this.clienteBd2Dao = new ClienteDb2DAO();
        this.clienteBd3Dao = new ClienteDb3DAO();
    }

    @After
    public void end() throws DAOException {
        Collection<Cliente> list1 = clienteDao.buscarTodos();
        excluir1(list1);

        Collection<Cliente> list2 = clienteBd2Dao.buscarTodos();
        excluir2(list2);

        Collection<Cliente> list3 = clienteBd3Dao.buscarTodos();
        excluir3(list3);
    }

    private void excluir1(Collection<Cliente> list) {
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    private void excluir2(Collection<Cliente> list) {
        list.forEach(cli -> {
            try {
                clienteBd2Dao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void excluir3(Collection<Cliente> clientes) {
        clientes.forEach(cliente -> {
            try {
                clienteBd3Dao.excluir(cliente);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    public void pesquisarCliente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Rodrigo");
        cliente.setTelefone("1199999999");
        cliente.setVip(true);
        clienteDao.cadastrar(cliente);
        Assert.assertNotNull(clienteDao.buscar(cliente.getId()));

        cliente.setId(null);
        clienteBd2Dao.cadastrar(cliente);
        Assert.assertNotNull(clienteBd2Dao.buscar(cliente.getId()));

        cliente.setId(null);
        clienteBd3Dao.cadastrar(cliente);
        Assert.assertNotNull(clienteBd3Dao.buscar(cliente.getId()));
    }
}