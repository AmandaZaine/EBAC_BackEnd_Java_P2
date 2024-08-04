/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.dao;

import main.dao.generic.IGenericDAO;
import main.domain.Cliente;

public interface IClienteDAO<T extends Persistente> extends IGenericDAO<T, Long> {
}