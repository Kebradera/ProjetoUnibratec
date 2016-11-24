/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes_basicas.Consulta;
import exceptions.DatabaseException;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Skywalker
 */
public interface IRepositorioConsulta {
    void inserir(Consulta consulta) throws DatabaseException;
    
    void excluir(Consulta consulta) throws DatabaseException;
    
    void alterar(Consulta consulta) throws DatabaseException;
    
    ArrayList<Consulta> listar() throws DatabaseException;
    
    ArrayList<Consulta> pesquisarPorCodigo(int codigo) throws DatabaseException;
    
    ArrayList<Consulta> pesquisarPorData(Date data) throws DatabaseException;
    
    ArrayList<Consulta> pesquisarPorMedico(String medico) throws DatabaseException;
    
    ArrayList<Consulta> pesquisarPorPaciente(String paciente) throws DatabaseException;
}
