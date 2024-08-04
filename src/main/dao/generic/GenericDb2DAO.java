package main.dao.generic;

import main.dao.Persistente;

import java.io.Serializable;

public abstract class GenericDb2DAO<T extends Persistente, E extends Serializable> extends GenericDAO<T,E> {

    public GenericDb2DAO(Class<T> persistenteClass) {
        super(persistenteClass, "postgresql2");
    }

}