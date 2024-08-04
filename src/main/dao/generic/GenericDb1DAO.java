package main.dao.generic;

import main.dao.Persistente;

import java.io.Serializable;

public abstract class GenericDb1DAO<T extends Persistente, E extends Serializable> extends GenericDAO<T,E> {

    public GenericDb1DAO(Class<T> persistenteClass) {
        super(persistenteClass, "postgresql1");
    }

}