package test;

import main.dao.IProdutoDAO;
import main.dao.ProdutoDAO;
import main.domain.Produto;
import main.exceptions.DAOException;
import main.exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;

import static org.junit.Assert.*;

public class ProdutoDAOTest {

    private final IProdutoDAO produtoDao;

    public ProdutoDAOTest() {
        produtoDao = new ProdutoDAO();
    }

    @After
    public void end() throws DAOException {
        Collection<Produto> list = produtoDao.buscarTodos();
        list.forEach(prod -> {
            try {
                produtoDao.excluir(prod);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    private Produto criarProduto(String codigo) throws TipoChaveNaoEncontradaException, DAOException {
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setNome("Produto 1");
        produto.setValor(BigDecimal.TEN);
        produto.setMarca("EBAC");
        produtoDao.cadastrar(produto);
        return produto;
    }

    private void excluir(Produto produto) throws Exception {
        this.produtoDao.excluir(produto);
    }

    @Test
    public void pesquisar() throws Exception {
        Produto produto = criarProduto("A1");
        assertNotNull(produto);
        Produto produtoDB = this.produtoDao.buscar(produto.getCodigo());
        assertNotNull(produtoDB);
        excluir(produtoDB);
    }

    @Test
    public void salvar() throws Exception {
        Produto produto = criarProduto("A2");
        assertNotNull(produto);
        excluir(produto);
    }

    @Test
    public void excluir() throws Exception {
        Produto produto = criarProduto("A3");
        assertNotNull(produto);
        excluir(produto);
        Produto produtoBD = this.produtoDao.buscar(produto.getCodigo());
        assertNull(produtoBD);
    }

    @Test
    public void alterarCliente() throws Exception {
        Produto produto = criarProduto("A4");
        produto.setNome("Rodrigo Pires");
        produtoDao.alterar(produto);
        Produto produtoBD = this.produtoDao.buscar(produto.getCodigo());
        assertNotNull(produtoBD);
        Assert.assertEquals("Rodrigo Pires", produtoBD.getNome());

        excluir(produto);
        Produto produtoBD1 = this.produtoDao.buscar(produto.getCodigo());
        assertNull(produtoBD1);
    }

    @Test
    public void buscarTodos() throws Exception {
        criarProduto("A5");
        criarProduto("A6");
        Collection<Produto> list = produtoDao.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        for (Produto prod : list) {
            excluir(prod);
        }

        list = produtoDao.buscarTodos();
        assertNotNull(list);
        assertEquals(0, list.size());

    }
}