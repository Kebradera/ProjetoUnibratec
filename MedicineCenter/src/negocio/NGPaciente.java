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
    IRepositorioPaciente repPaciente;

    public NGPaciente() {
        this.repPaciente = new RepositorioPaciente();
    }
    
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
    
    public ArrayList<Paciente> listarPacientes() throws DatabaseException{
        try{
           return repPaciente.listar();
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
        
    }
    
    public ArrayList<Paciente> pesquisarPacientePorCPF(String cpf) throws DatabaseException{
        try{
            return repPaciente.pesquisarPorCPF(cpf);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public ArrayList<Paciente> pesquisarPacientePorCodigo(int codigo) throws DatabaseException{
        try{
            return repPaciente.pesquisarPorCodigo(codigo);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public ArrayList<Paciente> pesquisarPacientePorNome(String nome) throws DatabaseException{
        try{
            return repPaciente.pesquisarPorNome(nome);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public ArrayList<Paciente> pesquisarPorNumeroCarteira(String numero_carteira) throws DatabaseException{
        try{
            return repPaciente.pesquisarPorNumeroCarteira(numero_carteira);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
}
