package main.dao.generic;

import main.dao.Persistente;
import main.exceptions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public abstract class GenericDAO<T extends Persistente, E extends Serializable> implements IGenericDAO<T,E> {

    private static final String PERSISTENCE_UNIT_NAME = "postgresql1";

    protected EntityManagerFactory entityManagerFactory;

    protected EntityManager entityManager;

    private Class<T> persistenteClass;

    private String persistenceUnitName;

    public GenericDAO(Class<T> persistenteClass, String persistenceUnitName) {
        this.persistenteClass = persistenteClass;
        this.persistenceUnitName = persistenceUnitName;
    }

    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        openConnection();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        closeConnection();
        return entity;
    }

    @Override
    public void excluir(T entity) throws Exception {
        openConnection();
        entity = entityManager.merge(entity);
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        closeConnection();
    }

    @Override
    public T alterar(T entity) throws Exception {
        openConnection();
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        closeConnection();
        return entity;
    }

    @Override
    public T buscar(E id) throws Exception {
        openConnection();
        T entity = entityManager.find(this.persistenteClass, id);
        entityManager.getTransaction().commit();
        closeConnection();
        return entity;
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        openConnection();
        List<T> lista = entityManager.createQuery(getSelectSql(), this.persistenteClass).getResultList();
        closeConnection();
        return lista;
    }

    protected void openConnection() {
        entityManagerFactory = Persistence.createEntityManagerFactory(getPersistenceUnitName());
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    protected void closeConnection() {
        entityManager.close();
        entityManagerFactory.close();
    }

    private String getSelectSql() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT obj FROM ");
        stringBuilder.append(this.persistenteClass.getSimpleName());
        stringBuilder.append(" obg");
        return stringBuilder.toString();
    }

    private String getPersistenceUnitName() {
        if (persistenceUnitName != null && !"".equals(persistenceUnitName)) {
            return persistenceUnitName;
        } else {
            return PERSISTENCE_UNIT_NAME;
        }
    }
}