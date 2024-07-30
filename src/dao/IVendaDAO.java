package dao;

import dao.generic.IGenericDAO;
import domain.Venda;
import exceptions.DAOException;
import exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, Long> {

    public void finalizarVenda(Venda venda) throws Exception;

    public void cancelarVenda(Venda venda) throws Exception;

    public Venda consultarComCollection(Long id);
}