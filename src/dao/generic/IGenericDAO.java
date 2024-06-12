package dao.generic;

import dao.Persistente;
import exceptions.DAOException;
import exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericDAO <T extends Persistente, E extends Serializable> {

    // o parametro é uma entity a ser cadastrada
    Boolean cadastrar(T entidade) throws TipoChaveNaoEncontradaException, DAOException;

    // o parametro é o valor da chave única do dado a ser excluído
    void excluir(E chave) throws Exception;

    // o parametro é uma entity a ser alterada
    void alterar(T entidade) throws Exception;

    // o parametro é o valor da chave única do dado a ser consultado
    T buscar(E chave) throws Exception;

    Collection<T> buscarTodos() throws DAOException;

}
