package main.dao.generic;

import main.dao.Persistente;
import main.exceptions.DAOException;
import main.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericDAO <T extends Persistente, E extends Serializable> {

    // o parametro é uma entity a ser cadastrada
    T cadastrar(T entidade) throws TipoChaveNaoEncontradaException, DAOException;

    // o parametro é o valor da chave única do dado a ser excluído
    void excluir(T entidade) throws Exception;

    // o parametro é uma entity a ser alterada
    T alterar(T entidade) throws Exception;

    // o parametro é o valor da chave única do dado a ser consultado
    T buscar(E id) throws Exception;

    Collection<T> buscarTodos() throws DAOException;

}
