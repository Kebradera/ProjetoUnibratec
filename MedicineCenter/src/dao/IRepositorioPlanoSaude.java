/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes_basicas.Plano_Saude;
import exceptions.DatabaseException;
import java.util.ArrayList;

/**
 *
 * @author Skywalker
 */
public interface IRepositorioPlanoSaude {
    void inserir(Plano_Saude plano_saude) throws DatabaseException;
    void excluir(Plano_Saude plano_saude) throws DatabaseException;
    void alterar(Plano_Saude plano_saude) throws DatabaseException;
    ArrayList<Plano_Saude> listar() throws DatabaseException;
    ArrayList<Plano_Saude> pesquisar(Plano_Saude plano_saudeparam) throws DatabaseException;
    ArrayList<Plano_Saude> pesquisarPorOperadora(String plano_saudeparam) throws DatabaseException;
}
