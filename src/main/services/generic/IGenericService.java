package main.services.generic;

import main.dao.Persistente;
import main.exceptions.DAOException;
import main.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericService <T extends Persistente, E extends Serializable> {

    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    public void excluir(T entity) throws Exception;

    public T alterar(T entity) throws Exception;

    public T consultar(E valor) throws Exception;

    public Collection<T> buscarTodos() throws DAOException;

}
