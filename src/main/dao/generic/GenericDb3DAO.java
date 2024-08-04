package main.dao.generic;

import main.dao.Persistente;

import java.io.Serializable;

public abstract class GenericDb3DAO<T extends Persistente, E extends Serializable> extends GenericDAO<T,E> {

    public GenericDb3DAO(Class<T> persistenteClass) {
        super(persistenteClass, "mysql1");
    }

}