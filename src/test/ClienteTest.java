package test;

import dao.ClienteDAO;
import dao.IClienteDAO;
import domain.Cliente;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ClienteTest {

    private IClienteDAO clienteDAO;

    @Test
    public void testeCadastrar() throws Exception {
        ClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCpf("90044492049");
        cliente.setNome("Carol");
        cliente.setTelefone("11943872398");

        Integer resultadoCadastro = clienteDAO.cadastrar(cliente);
        assertEquals(1, (int) resultadoCadastro);

        Cliente clienteBD = clienteDAO.buscar(cliente.getCpf());
        assertNotNull(clienteBD);
        assertEquals(cliente.getCpf(), clienteBD.getCpf());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer resultadoExcluir = clienteDAO.excluir(cliente);
        assertEquals(1, (int) resultadoExcluir);
    }

    @Test
    public void testeBuscar() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCpf("44022259695");
        cliente.setNome("Joana");
        cliente.setTelefone("11943953592");
        Integer resultadoCadastro = clienteDAO.cadastrar(cliente);
        assertEquals(1, (int) resultadoCadastro);

        Cliente clienteBD = clienteDAO.buscar(cliente.getCpf());
        assertNotNull(clienteBD);
        assertEquals(cliente.getCpf(),clienteBD.getCpf());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer resultadoExclusao = clienteDAO.excluir(cliente);
        assertEquals(1, (int) resultadoExclusao);
    }

    @Test
    public void testeExcluir() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCpf("98088830482");
        cliente.setNome("Alice");
        cliente.setTelefone("11934729402");

        Integer resultadoCadastro = clienteDAO.cadastrar(cliente);
        assertEquals(1, (int) resultadoCadastro);

        Cliente resultadoBuscar = clienteDAO.buscar(cliente.getCpf());
        assertNotNull(resultadoBuscar);
        assertEquals(cliente.getCpf(),resultadoBuscar.getCpf());
        assertEquals(cliente.getNome(), resultadoBuscar.getNome());

        Integer resultadoExcluir = clienteDAO.excluir(cliente);
        assertEquals(1, (int) resultadoExcluir);
    }

    @Test
    public void testeBuscarTodos() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente1 = new Cliente();
        cliente1.setCpf("98088830482");
        cliente1.setNome("Alice");
        cliente1.setTelefone("11934729402");
        Integer resultadoCadastrar1 = clienteDAO.cadastrar(cliente1);
        assertEquals(1, (int) resultadoCadastrar1);

        Cliente cliente2 = new Cliente();
        cliente2.setCpf("44022259695");
        cliente2.setNome("Joana");
        cliente2.setTelefone("11943953592");
        Integer resultadoCadastrar2 = clienteDAO.cadastrar(cliente1);
        assertEquals(1, (int) resultadoCadastrar2);

        List<Cliente> todosClientes = clienteDAO.buscarTodos();
        assertNotNull(todosClientes);
        assertEquals(2,todosClientes.size());

        clienteDAO.excluir(cliente1);
        clienteDAO.excluir(cliente2);
        assertTrue(clienteDAO.buscarTodos().isEmpty());
    }

    @Test
    public void testeAtualizar() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente1 = new Cliente();
        cliente1.setCpf("98088830482");
        cliente1.setNome("Alice");
        cliente1.setTelefone("11934729402");
        Integer resultadoCadastrar1 = clienteDAO.cadastrar(cliente1);
        assertEquals(1, (int) resultadoCadastrar1);

        Cliente clienteBD = clienteDAO.buscar(cliente1.getCpf());
        assertNotNull(clienteBD);
        assertEquals(cliente1.getCpf(),clienteBD.getCpf());
        assertEquals(cliente1.getNome(),clienteBD.getNome());

        clienteBD.setNome("Alice Ruiz");
        clienteBD.setTelefone("18984028530");
        Integer resultadoAtualizar = clienteDAO.alterar(clienteBD);
        assertEquals(1, (int) resultadoAtualizar);

        Cliente resutaldoBuscar = clienteDAO.buscar(cliente1.getCpf());
        assertNotNull(resutaldoBuscar);
        assertNotEquals(cliente1.getNome(), resutaldoBuscar.getNome());
        assertNotEquals(cliente1.getTelefone(),resutaldoBuscar.getTelefone());

        Cliente resutaldoBuscar2 = clienteDAO.buscar(cliente1.getCpf());
        assertNotNull(resutaldoBuscar2);
        assertNotEquals(cliente1.getNome(), resutaldoBuscar2.getNome());
        assertNotEquals(cliente1.getTelefone(),resutaldoBuscar2.getTelefone());

        Integer resultadoExcluir = clienteDAO.excluir(resutaldoBuscar2);
        assertEquals(1, (int) resultadoExcluir);
    }
}
