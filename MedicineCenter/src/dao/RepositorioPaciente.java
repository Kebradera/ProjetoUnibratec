/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes_basicas.Paciente;
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
public class RepositorioPaciente implements IRepositorioPaciente {
    private final IGerenciadorConexao g;
        private Connection c;
    
        public RepositorioPaciente(){
            g = GerenciadorConexaoMysql.getInstancia();
        }


        @Override
        public void inserir(Paciente paciente) throws DatabaseException {
            c = g.conectar();
            String sql = "STATEMENT";
            try{
                PreparedStatement pst = c.prepareStatement(sql);


                
            pst.setInt(1,paciente.getCod_paciente());
		pst.setString(2,paciente.getCpf());
		pst.setString(3,paciente.getNome());
		//pst.setDate(4,paciente.getDt_nascimento());
		pst.setString(5,paciente.getTelefone());
		pst.setString(6,paciente.getNumero_carteira());
		pst.setInt(7,paciente.getPlano().getCod_plano());

                pst.executeUpdate();
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
        }

        @Override
        public void excluir(Paciente paciente) throws DatabaseException {
            c = g.conectar();
        
            String sql = "DELETE FROM Paciente WHERE id=?";
            try{
                PreparedStatement pst = c.prepareStatement(sql);
                
                pst.setInt(1, paciente.getCod_paciente());

                pst.executeUpdate();
                pst.close();
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
        }
    
        @Override
        public void alterar(Paciente paciente) throws DatabaseException {
            c = g.conectar();
            String sql = "STATEMENT";
            try{
                PreparedStatement pst = c.prepareStatement(sql);
                
                pst.setInt(1,paciente.getCod_paciente());
		pst.setString(2,paciente.getCpf());
		pst.setString(3,paciente.getNome());
		//pst.setDate(4,paciente.getDt_nascimento());
		pst.setString(5,paciente.getTelefone());
		pst.setString(6,paciente.getNumero_carteira());
		pst.setInt(7,paciente.getPlano().getCod_plano());

                pst.executeUpdate();
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
        }

        @Override
        public ArrayList<Paciente> listar() throws DatabaseException {
            ArrayList<Paciente> lista = new ArrayList();
            Paciente paciente;
            c = g.conectar();
            
             String sql = "SELECT cod_paciente, cpf, nome, dt_nascimento, telefone, numero_carteira, plano_cod_plano FROM Paciente";

            try{
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(sql);
            
                while(rs.next()){
                    paciente = new Paciente();

                    paciente.setCod_paciente(rs.getInt("cod_paciente"));
                    paciente.setCpf(rs.getString("cpf"));
                    paciente.setNome(rs.getString("nome"));
                    paciente.setDt_nascimento(rs.getDate("dt_nascimento"));
                    paciente.setTelefone(rs.getString("telefone"));
                    paciente.setNumero_carteira(rs.getString("numero_carteira"));
                    //paciente.setPlano(rs.getInt("plano_cod_plano"));

                    lista.add(paciente);
                }
            
                return lista;
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
        }

        @Override
        public ArrayList<Paciente> pesquisar(Paciente pacienteparam) throws DatabaseException {
            ArrayList<Paciente> lista = new ArrayList();
            Paciente paciente = null;
            c = g.conectar();
            
            String sql = "SELECT cod_paciente, cpf, nome, dt_nascimento, telefone, numero_carteira, plano_cod_plano FROM Paciente WHERE id=?";
            
            try{
                PreparedStatement pst = c.prepareStatement(sql);
                pst.setInt(1, pacienteparam.getCod_paciente());
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    paciente = new Paciente();
                    paciente.setCod_paciente(rs.getInt("cod_paciente"));
                    paciente.setCpf(rs.getString("cpf"));
                    paciente.setNome(rs.getString("nome"));
                    paciente.setDt_nascimento(rs.getDate("dt_nascimento"));
                    paciente.setTelefone(rs.getString("telefone"));
                    paciente.setNumero_carteira(rs.getString("numero_carteira"));
                    //paciente.setPlano_cod_plano(rs.getInt("plano_cod_plano"));

                    lista.add(paciente);
                }
                return lista;
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
        }
}
