package test;


import dao.ClienteDAO;
import dao.IClienteDAO;
import domain.Cliente;
import exceptions.DAOException;
import exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertTrue;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;

    public ClienteDAOTest() {
        clienteDao = new ClienteDAO();
    }

    @After
    public void end() throws DAOException {
        Collection<Cliente> clientes = clienteDao.buscarTodos();
        clientes.forEach(cliente -> {
            try {
                clienteDao.excluir(cliente);
            } catch (DAOException e) {
                e.printStackTrace();
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

        Cliente clienteConsultado = clienteDao.buscar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setCpf(56565656565L);
        cliente.setNome("Rodrigo");
        cliente.setTelefone("1199999999");
        cliente.setVip(false);
        Cliente clienteCadastrado = clienteDao.cadastrar(cliente);
        Assert.assertNotNull(clienteCadastrado);

        Cliente clienteConsultado = clienteDao.buscar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente);

        clienteConsultado = clienteDao.buscar(cliente.getCpf());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void excluirCliente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setCpf(56565656565L);
        cliente.setNome("Daniela");
        cliente.setTelefone("1199999999");
        cliente.setVip(false);
        Cliente retorno = clienteDao.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        Cliente clienteConsultado = clienteDao.buscar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente);
        clienteConsultado = clienteDao.buscar(cliente.getCpf());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void alterarCliente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setCpf(56565656565L);
        cliente.setNome("Rodrigo");
        cliente.setTelefone("1199999999");
        cliente.setVip(false);
        Cliente retorno = clienteDao.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        Cliente clienteConsultado = clienteDao.buscar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteConsultado.setNome("Rodrigo Pires");
        clienteDao.alterar(clienteConsultado);

        Cliente clienteAlterado = clienteDao.buscar(clienteConsultado.getId());
        Assert.assertNotNull(clienteAlterado);
        Assert.assertEquals("Rodrigo Pires", clienteAlterado.getNome());

        clienteDao.excluir(cliente);
        clienteConsultado = clienteDao.buscar(cliente.getCpf());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
        Cliente cliente1 = new Cliente();
        cliente1.setCpf(56565656565L);
        cliente1.setNome("Rodrigo");
        cliente1.setTelefone("1199999999");
        cliente1.setVip(false);
        Cliente retorno1 = clienteDao.cadastrar(cliente1);
        Assert.assertNotNull(retorno1);

        Cliente cliente2 = new Cliente();
        cliente2.setCpf(56565656569L);
        cliente2.setNome("Rodrigo");
        cliente2.setTelefone("1199999999");
        cliente2.setVip(true);
        Cliente retorno2 = clienteDao.cadastrar(cliente2);
        Assert.assertNotNull(retorno2);

        Collection<Cliente> clientes = clienteDao.buscarTodos();
        assertTrue(clientes != null);
        assertTrue(clientes.size() == 2);

        clientes.forEach(cliente -> {
            try {
                clienteDao.excluir(cliente);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        Collection<Cliente> list1 = clienteDao.buscarTodos();
        assertTrue(list1 != null);
        assertTrue(list1.size() == 0);
    }
}