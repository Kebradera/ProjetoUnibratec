/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import classes_basicas.Medico;
import dao.IRepositorioMedico;
import dao.RepositorioMedico;
import exceptions.DatabaseException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Skywalker
 */
public class NGMedico {
    private IRepositorioMedico repMedico = new RepositorioMedico();
    
    public void inserir(Medico med) throws DatabaseException{
        try{
            repMedico.inserir(med);
        }catch(DatabaseException ex){
            throw new DatabaseException(ex);
        }
    }
    
    public void alterar(Medico med) throws DatabaseException{
        try{
            repMedico.alterar(med);
        }catch(DatabaseException ex){
            throw new DatabaseException(ex);
        }
    }
    
    public void excluir(Medico med) throws DatabaseException{
        try{
            repMedico.excluir(med);
        }catch(DatabaseException ex){
            throw new DatabaseException(ex);
        }
    }
    
    public ArrayList<Medico> pesquisar(String nome)throws DatabaseException{
        try{
            return repMedico.pesquisar(nome);
        }catch(DatabaseException e){
            throw new DatabaseException();
        }
    }
        
    public ArrayList<Medico> listar()throws DatabaseException{
        try{
            return repMedico.listar();
        }catch(DatabaseException e){
            throw new DatabaseException();
        }
    }
}
