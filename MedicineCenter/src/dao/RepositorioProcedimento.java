/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes_basicas.Procedimento;
import exceptions.DatabaseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.GerenciadorConexaoMysql;
import util.IGerenciadorConexao;

/**
 *
 * @author Skywalker
 */
public class RepositorioProcedimento implements IRepositorioProcedimento {

    private final IGerenciadorConexao g;
    private Connection c;
    
    public RepositorioProcedimento(){
        g = GerenciadorConexaoMysql.getInstancia();
    }
    
    @Override
    public void inserir(Procedimento procedimento) throws DatabaseException {
        c = g.conectar();
            String sql = "STATEMENT";
            try{
                PreparedStatement pst = c.prepareStatement(sql);
                pst.setInt(1,procedimento.getCod_procedimento());
		pst.setString(2,procedimento.getDescricao());
		pst.setString(3,procedimento.getCusto_atual());

                pst.executeUpdate();
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
    }

    @Override
    public void excluir(Procedimento procedimento) throws DatabaseException {
        c = g.conectar();
        
            String sql = "DELETE FROM Procedimento WHERE id=?";
            try{
                PreparedStatement pst = c.prepareStatement(sql);
                
                pst.setInt(1, procedimento.getCod_procedimento());

                pst.executeUpdate();
                pst.close();
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
    }

    @Override
    public void alterar(Procedimento procedimento) throws DatabaseException {
        c = g.conectar();
            String sql = "STATEMENT";
            try{
                PreparedStatement pst = c.prepareStatement(sql);
                
                pst.setInt(1,procedimento.getCod_procedimento());
		pst.setString(2,procedimento.getDescricao());
		pst.setString(3,procedimento.getCusto_atual());

                pst.executeUpdate();
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
    }

    @Override
    public ArrayList<Procedimento> listar() throws DatabaseException {
            ArrayList<Procedimento> lista = new ArrayList();
            Procedimento procedimento;
            c = g.conectar();
            
             String sql = "SELECT cod_procedimento, descricao, custo_atual FROM Procedimento";

            try{
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(sql);
            
                while(rs.next()){
                    procedimento = new Procedimento();

                    procedimento.setCod_procedimento(rs.getInt("cod_procedimento"));
                    procedimento.setDescricao(rs.getString("descricao"));
                    procedimento.setCusto_atual(rs.getString("custo_atual"));

                    lista.add(procedimento);
                }
            
                return lista;
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
    }

    @Override
    public ArrayList<Procedimento> pesquisar(Procedimento procedimentoparam) throws DatabaseException {
        ArrayList<Procedimento> lista = new ArrayList();
        Procedimento procedimento = null;
            c = g.conectar();
            
            String sql = "SELECT cod_procedimento, descricao, custo_atual FROM Procedimento WHERE id=?";
            
            try{
                PreparedStatement pst = c.prepareStatement(sql);
                pst.setInt(1, procedimentoparam.getCod_procedimento());
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                   procedimento = new Procedimento();
                   
                   procedimento.setCod_procedimento(rs.getInt("cod_procedimento"));
                   procedimento.setDescricao(rs.getString("descricao"));
                   procedimento.setCusto_atual(rs.getString("custo_atual"));

                   lista.add(procedimento);
                }
                return lista;
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
    }

    @Override
    public ArrayList<Procedimento> pesquisarProcedimentoPorDescricao(String procedimentoparam) throws DatabaseException {
        ArrayList<Procedimento> lista = new ArrayList();
        Procedimento procedimento = null;
            c = g.conectar();
            
            String sql = "SELECT cod_procedimento, descricao, custo_atual FROM Procedimento WHERE descricao=?";
            
            try{
                PreparedStatement pst = c.prepareStatement(sql);
                pst.setString(1, procedimentoparam);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                   procedimento = new Procedimento();
                   
                   procedimento.setCod_procedimento(rs.getInt("cod_procedimento"));
                   procedimento.setDescricao(rs.getString("descricao"));
                   procedimento.setCusto_atual(rs.getString("custo_atual"));

                   lista.add(procedimento);
                }
                return lista;
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
    }
    
}
