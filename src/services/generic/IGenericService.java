package services.generic;

import dao.Persistente;
import exceptions.DAOException;
import exceptions.MaisDeUmRegistroException;
import exceptions.TableException;
import exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericService <T extends Persistente, E extends Serializable> {

    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    public void excluir(T entity) throws Exception;

    public T alterar(T entity) throws Exception;

    public T consultar(E valor) throws Exception;

    public Collection<T> buscarTodos() throws DAOException;

}
