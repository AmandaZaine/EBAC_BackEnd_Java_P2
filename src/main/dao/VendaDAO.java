package main.dao;

import main.dao.generic.GenericDAO;
import main.domain.Cliente;
import main.domain.Produto;
import main.domain.Venda;
import main.exceptions.DAOException;
import main.exceptions.TipoChaveNaoEncontradaException;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class VendaDAO extends GenericDAO<Venda, Long> implements IVendaDAO {

    public VendaDAO() {
        super(Venda.class, "postgresql1");
    }

    @Override
    public void finalizarVenda(Venda venda) throws Exception {
        super.alterar(venda);
    }

    @Override
    public void cancelarVenda(Venda venda) throws Exception {
        super.alterar(venda);
    }

    @Override
    public void excluir(Venda entity) {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public Venda cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException {
        try {
            openConnection();
            entity.getProdutos().forEach(prod -> {
                Produto produto = entityManager.merge(prod.getProduto());
                prod.setProduto(produto);
            });

            Cliente cliente = entityManager.merge(entity.getCliente());
            entity.setCliente(cliente);
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            closeConnection();
            return entity;
        } catch (Exception exception) {
            throw new DAOException("Erro ao salvar venda", exception);
        }
    }

    @Override
    public Venda consultarComCollection(Long id) {
        openConnection();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Venda> query = builder.createQuery(Venda.class);
        Root<Venda> root = query.from(Venda.class);
        root.fetch("cliente");
        root.fetch("procutos");
        query.select(root).where(builder.equal(root.get("id"), id));
        TypedQuery<Venda> typedQuery = entityManager.createQuery(query);
        Venda venda = typedQuery.getSingleResult();
        closeConnection();
        return venda;
    }

}