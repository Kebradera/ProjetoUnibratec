/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes_basicas.Procedimento;
import exceptions.DatabaseException;
import java.util.ArrayList;

/**
 *
 * @author Skywalker
 */
public interface IRepositorioProcedimento {
    void inserir(Procedimento procedimento) throws DatabaseException;
    
    void excluir(Procedimento procedimento) throws DatabaseException;
    
    void alterar(Procedimento procedimento) throws DatabaseException;
    
    ArrayList<Procedimento> listar() throws DatabaseException;
    
    ArrayList<Procedimento> pesquisarPorCodigo(int codigo_proc) throws DatabaseException;
    
    ArrayList<Procedimento> pesquisarProcedimentoPorDescricao(String descr_proc) throws DatabaseException;
}
