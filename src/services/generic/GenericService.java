package services.generic;


import dao.Persistente;
import dao.generic.IGenericDAO;
import exceptions.DAOException;
import exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public abstract class GenericService<T extends Persistente, E extends Serializable>
        implements IGenericService<T, E> {

    protected IGenericDAO<T, E> dao;

    public GenericService(IGenericDAO<T, E> dao) {
        this.dao = dao;
    }

    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.cadastrar(entity);
    }

    @Override
    public void excluir(T entity) throws Exception {
        this.dao.excluir(entity);
    }

    @Override
    public T alterar(T entity) throws Exception {
        return this.dao.alterar(entity);
    }

    @Override
    public T consultar(E valor) throws Exception {
        return this.dao.buscar(valor);
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        return this.dao.buscarTodos();
    }


}
