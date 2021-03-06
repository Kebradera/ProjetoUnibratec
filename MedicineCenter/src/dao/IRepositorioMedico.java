/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes_basicas.Medico;
import exceptions.DatabaseException;
import exceptions.RepositorioException;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public interface IRepositorioMedico {
    //inserir, pesquisar, excluir, alterar, listar
    
    public void inserir(Medico med) throws DatabaseException;

    public void excluir(Medico med) throws DatabaseException;
    
    public void alterar(Medico med) throws DatabaseException;
    
    public ArrayList<Medico> listar() throws DatabaseException;
    
    public ArrayList<Medico> pesquisarPorNome(String nome) throws DatabaseException, RepositorioException;
    
    public ArrayList<Medico> pesquisarPorCRM(String crm) throws DatabaseException, RepositorioException;
    
    public ArrayList<Medico> pesquisarPorEspecialidade(String especialidade) throws DatabaseException, RepositorioException;
}
