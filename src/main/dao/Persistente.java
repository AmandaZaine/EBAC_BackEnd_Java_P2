package main.dao;

// Classe que representa todas as entidades/objetos que serao salvas no banco de dados
public interface Persistente {
    public Long getId();
    public void setId(Long id);
}
