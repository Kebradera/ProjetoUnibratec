/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes_basicas.Plano_Saude;
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
public class RepositorioPlanoSaude implements IRepositorioPlanoSaude {

    private final IGerenciadorConexao g;
    private Connection c;
    
    public RepositorioPlanoSaude(){
        g = GerenciadorConexaoMysql.getInstancia();
    }
    
    @Override
    public void inserir(Plano_Saude plano_saude) throws DatabaseException {
        c = g.conectar();
            String sql = "INSERT INTO Plano_Saude (nome_operadora, telefone, desc_plano) VALUES (?, ?, ?)";
            try{
                PreparedStatement pst = c.prepareStatement(sql);

		pst.setString(2,plano_saude.getNome_operadora());
		pst.setString(3,plano_saude.getTelefone());
		pst.setString(4,plano_saude.getDesc_plano());

                pst.executeUpdate();
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
    }

    @Override
    public void excluir(Plano_Saude plano_saude) throws DatabaseException {
            c = g.conectar();
        
            String sql = "DELETE FROM Plano_Saude WHERE id=?";
            try{
                PreparedStatement pst = c.prepareStatement(sql);
                
                pst.setInt(1, plano_saude.getCod_plano());

                pst.executeUpdate();
                pst.close();
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
    }

    @Override
    public void alterar(Plano_Saude plano_saude) throws DatabaseException {
        c = g.conectar();
            String sql = "UPDATE Plano_Saude SET nome_operadora=?, telefone=?, desc_plano=? WHERE cod_plano=?";
            try{
                PreparedStatement pst = c.prepareStatement(sql);
                
		pst.setString(1,plano_saude.getNome_operadora());
		pst.setString(2,plano_saude.getTelefone());
		pst.setString(3,plano_saude.getDesc_plano());
                pst.setInt(4,plano_saude.getCod_plano());


                pst.executeUpdate();
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
    }

    @Override
    public ArrayList<Plano_Saude> listar() throws DatabaseException {
            ArrayList<Plano_Saude> lista = new ArrayList();
            Plano_Saude plano_saude;
            c = g.conectar();
            
             String sql = "SELECT cod_plano, nome_operadora, telefone, desc_plano FROM Plano_Saude";

            try{
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(sql);
            
                while(rs.next()){
                    plano_saude = new Plano_Saude();

                    plano_saude.setCod_plano(rs.getInt("cod_plano"));
                    plano_saude.setNome_operadora(rs.getString("nome_operadora"));
                    plano_saude.setTelefone(rs.getString("telefone"));
                    plano_saude.setDesc_plano(rs.getString("desc_plano"));

                    lista.add(plano_saude);
                }
            
                return lista;
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
    }

    @Override
    public ArrayList<Plano_Saude> pesquisarPorCodigo(int cod_plano) throws DatabaseException {
            ArrayList<Plano_Saude> lista = new ArrayList();
            Plano_Saude plano_saude = null;
            c = g.conectar();
            
            String sql = "SELECT cod_plano, nome_operadora, telefone, desc_plano FROM Plano_Saude WHERE cod_plano=?";
            
            try{
                PreparedStatement pst = c.prepareStatement(sql);
                pst.setInt(1, cod_plano);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    plano_saude = new Plano_Saude();
                    plano_saude.setCod_plano(rs.getInt("cod_plano"));
                    plano_saude.setNome_operadora(rs.getString("nome_operadora"));
                    plano_saude.setTelefone(rs.getString("telefone"));
                    plano_saude.setDesc_plano(rs.getString("desc_plano"));
                    
                    lista.add(plano_saude);
                }
                return lista;
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
    }

    @Override
    public ArrayList<Plano_Saude> pesquisarPorOperadora(String nome_operadora) throws DatabaseException {
        ArrayList<Plano_Saude> lista = new ArrayList();
             Plano_Saude plano_saude = null;
             c = g.conectar();
             
             String sql = "SELECT cod_plano, nome_operadora, telefone, desc_plano FROM Plano_Saude WHERE nome_operadora=?";
             
             try{
                 PreparedStatement pst = c.prepareStatement(sql);
                 pst.setString(1, nome_operadora);
                 ResultSet rs = pst.executeQuery();
                 if(rs.next()){
                     plano_saude = new Plano_Saude();
                     plano_saude.setCod_plano(rs.getInt("cod_plano"));
                     plano_saude.setNome_operadora(rs.getString("nome_operadora"));
                     plano_saude.setTelefone(rs.getString("telefone"));
                     plano_saude.setDesc_plano(rs.getString("desc_plano"));
                     
                     lista.add(plano_saude);
                 }
                 return lista;
             }catch(SQLException e){
                 throw new DatabaseException(e);
             }finally{
                 g.desconectar(c);
             }
    }
    
    
}
