/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes_basicas.Paciente;
import exceptions.DatabaseException;
import java.util.ArrayList;

/**
 *
 * @author Skywalker
 */
public interface IRepositorioPaciente {
    void inserir(Paciente paciente) throws DatabaseException;
    
    void excluir(Paciente paciente) throws DatabaseException;
    
    void alterar(Paciente paciente) throws DatabaseException;
    
    ArrayList<Paciente> listar() throws DatabaseException;
    
    ArrayList<Paciente> pesquisarPorCodigo(int cod_paciente) throws DatabaseException;
    
    ArrayList<Paciente> pesquisarPorCPF(String cpf) throws DatabaseException;
    
    ArrayList<Paciente> pesquisarPorNome(String nome_paciente) throws DatabaseException;
    
    ArrayList<Paciente> pesquisarPorNumeroCarteira(String num_carteira) throws DatabaseException;
}
