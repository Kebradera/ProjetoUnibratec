package negocio;

import classes_basicas.Procedimento;
import dao.IRepositorioProcedimento;
import dao.RepositorioProcedimento;
import exceptions.DatabaseException;
import java.util.ArrayList;


public class NGProcedimento{
    IRepositorioProcedimento repProcedimento;

    public NGProcedimento() {
        this.repProcedimento = new RepositorioProcedimento();
    }
    
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
            return repProcedimento.pesquisarPorCodigo(cod_procedimento);
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