/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Cliente;
import java.util.Collection;
import java.util.List;

public interface IClienteDAO {

    public Integer cadastrar(Cliente cliente) throws Exception;
    public Integer alterar(Cliente cliente) throws Exception;
    public Cliente buscar(String cpf) throws Exception;
    public List<Cliente> buscarTodos() throws Exception;
    public Integer excluir(Cliente cliente) throws Exception;
}
