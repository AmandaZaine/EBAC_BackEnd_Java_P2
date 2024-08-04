package main.services;

import main.domain.Cliente;
import main.exceptions.DAOException;
import main.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {
    Cliente buscarPorCPF(Long cpf) throws DAOException;
}
