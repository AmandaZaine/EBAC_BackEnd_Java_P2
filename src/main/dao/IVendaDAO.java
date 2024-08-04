package main.dao;

import main.dao.generic.IGenericDAO;
import main.domain.Venda;

public interface IVendaDAO extends IGenericDAO<Venda, Long> {

    public void finalizarVenda(Venda venda) throws Exception;

    public void cancelarVenda(Venda venda) throws Exception;

    public Venda consultarComCollection(Long id);
}