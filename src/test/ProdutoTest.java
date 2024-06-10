package test;

import dao.IProdutoDAO;
import dao.ProdutoDAO;
import domain.Produto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {

    private IProdutoDAO produtoDAO;

    @Test
    public void testeCadastrar() throws Exception {
        ProdutoDAO produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("1");
        produto.setNome("cadeira");
        produto.setDescricao("cadeira rosa");

        Integer resultadoCadastro = produtoDAO.cadastrar(produto);
        assertEquals(1, (int) resultadoCadastro);

        Produto produtoBD = produtoDAO.buscar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getDescricao(), produtoBD.getDescricao());

        Integer resultadoExcluir = produtoDAO.excluir(produto);
        assertEquals(1, (int) resultadoExcluir);
    }

    @Test
    public void testeBuscar() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("2");
        produto.setNome("sofá");
        produto.setDescricao("sofá azul");
        Integer resultadoCadastro = produtoDAO.cadastrar(produto);
        assertEquals(1, (int) resultadoCadastro);

        Produto produtoBD = produtoDAO.buscar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertEquals(produto.getNome(),produtoBD.getNome());
        assertEquals(produto.getDescricao(), produtoBD.getDescricao());

        Integer resultadoExclusao = produtoDAO.excluir(produto);
        assertEquals(1, (int) resultadoExclusao);
    }

    @Test
    public void testeExcluir() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("3");
        produto.setNome("mesa");
        produto.setDescricao("mesa de vidro");

        Integer resultadoCadastro = produtoDAO.cadastrar(produto);
        assertEquals(1, (int) resultadoCadastro);

        Produto resultadoBuscar = produtoDAO.buscar(produto.getCodigo());
        assertNotNull(resultadoBuscar);
        assertEquals(produto.getNome(), resultadoBuscar.getNome());
        assertEquals(produto.getDescricao(), resultadoBuscar.getDescricao());

        Integer resultadoExcluir = produtoDAO.excluir(produto);
        assertEquals(1, (int) resultadoExcluir);
    }

    @Test
    public void testeBuscarTodos() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto1 = new Produto();
        produto1.setCodigo("4");
        produto1.setNome("porta");
        produto1.setDescricao("porta de aluminio");
        Integer resultadoCadastrar1 = produtoDAO.cadastrar(produto1);
        assertEquals(1, (int) resultadoCadastrar1);

        Produto produto2 = new Produto();
        produto2.setCodigo("5");
        produto2.setNome("janela");
        produto2.setDescricao("janela de aluminio");
        Integer resultadoCadastrar2 = produtoDAO.cadastrar(produto2);
        assertEquals(1, (int) resultadoCadastrar2);

        List<Produto> todosProdutos = produtoDAO.buscarTodos();
        assertNotNull(todosProdutos);
        assertEquals(2,todosProdutos.size());

        produtoDAO.excluir(produto1);
        produtoDAO.excluir(produto2);
        assertTrue(produtoDAO.buscarTodos().isEmpty());
    }

    @Test
    public void testeAtualizar() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto1 = new Produto();
        produto1.setCodigo("8");
        produto1.setNome("sofa-cama");
        produto1.setDescricao("sofa cama dobravel");
        Integer resultadoCadastrar1 = produtoDAO.cadastrar(produto1);
        assertEquals(1, (int) resultadoCadastrar1);

        Produto produtoBD = produtoDAO.buscar(produto1.getCodigo());
        assertNotNull(produtoBD);
        assertEquals(produto1.getDescricao(),produtoBD.getDescricao());
        assertEquals(produto1.getNome(),produtoBD.getNome());

        produtoBD.setNome("sofa-cama grande");
        produtoBD.setDescricao("sofa cama dobravel grande");
        Integer resultadoAtualizar = produtoDAO.alterar(produtoBD);
        assertEquals(1, (int) resultadoAtualizar);

        Produto resutaldoBuscar = produtoDAO.buscar(produto1.getCodigo());
        assertNotNull(resutaldoBuscar);
        assertNotEquals(produto1.getNome(), resutaldoBuscar.getNome());
        assertNotEquals(produto1.getDescricao(),resutaldoBuscar.getDescricao());

        Produto resutaldoBuscar2 = produtoDAO.buscar(produto1.getCodigo());
        assertNotNull(resutaldoBuscar2);
        assertNotEquals(produto1.getNome(), resutaldoBuscar2.getNome());
        assertNotEquals(produto1.getDescricao(),resutaldoBuscar2.getDescricao());

        Integer resultadoExcluir = produtoDAO.excluir(resutaldoBuscar2);
        assertEquals(1, (int) resultadoExcluir);
    }
}
