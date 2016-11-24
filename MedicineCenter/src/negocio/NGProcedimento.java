/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import classes_basicas.Procedimento;
import dao.IRepositorioProcedimento;
import dao.RepositorioProcedimento;
import exceptions.DatabaseException;
import java.util.ArrayList;

/**
 *
 * @author macbookwhite
 */
public class NGProcedimento {
    IRepositorioProcedimento repProcedimento = new RepositorioProcedimento();
    
    public void inserirProcedimento(Procedimento p) throws DatabaseException{
        try{
            repProcedimento.inserir(p);
        }catch(DatabaseException e){
           throw new DatabaseException(e);
        }
    }
    
    public void excluirProcedimento(Procedimento p) throws DatabaseException{
        try{
            repProcedimento.excluir(p);
        }catch(DatabaseException e){
           throw new DatabaseException(e);
        }
    }
    
    public void alterarProcedimento(Procedimento p) throws DatabaseException{
        try{
            repProcedimento.alterar(p);
        }catch(DatabaseException e){
           throw new DatabaseException(e);
        }
    }
    
    public ArrayList<Procedimento> listarProcedimento(Procedimento p) throws DatabaseException{
        try{
            return repProcedimento.listar();
        }catch(DatabaseException e){
           throw new DatabaseException(e);
        }
    }
    
    public ArrayList<Procedimento> pesquisarProcedimento(int cod_procedimento) throws DatabaseException{
        try{
            Procedimento proc = new Procedimento();
            proc.setCod_procedimento(cod_procedimento);
            return repProcedimento.pesquisar(proc);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public ArrayList<Procedimento> pesquisarProcedimentoPorDescricao(String descricao) throws DatabaseException{
        try{
            return repProcedimento.pesquisarProcedimentoPorDescricao(descricao);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
}
