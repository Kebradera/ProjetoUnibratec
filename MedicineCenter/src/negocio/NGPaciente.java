/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import classes_basicas.Paciente;
import dao.IRepositorioPaciente;
import dao.RepositorioPaciente;
import exceptions.DatabaseException;
import java.util.ArrayList;

/**
 *
 * @author macbookwhite
 */
public class NGPaciente {
    IRepositorioPaciente repPaciente = new RepositorioPaciente();
    
    public void inserirPaciente(Paciente p) throws DatabaseException{
        try{
            repPaciente.inserir(p);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public void excluirPaciente(Paciente p) throws DatabaseException{
        try{
            repPaciente.excluir(p);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public void alterarPaciente(Paciente p) throws DatabaseException{
        try{
            repPaciente.alterar(p);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public ArrayList<Paciente> listarPaciente(Paciente p) throws DatabaseException{
        try{
           return repPaciente.listar();
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
        
    }
    
    public ArrayList<Paciente> pesquisarPaciente(String numero_carteira) throws DatabaseException{
        try{
            Paciente pac = new Paciente();
            pac.setNumero_carteira(numero_carteira);
            return repPaciente.pesquisar(pac);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
}
