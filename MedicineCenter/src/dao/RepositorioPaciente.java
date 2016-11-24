/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes_basicas.Paciente;
import classes_basicas.Plano_Saude;
import exceptions.DatabaseException;
import java.sql.Connection;
import java.sql.Date;
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
            String sql = "INSERT INTO Paciente (cpf, nome, dt_nascimento, telefone, numero_carteira, plano_cod_plano) VALUES (?, ?, ?, ?, ?, ?)";
            try{
                PreparedStatement pst = c.prepareStatement(sql);

		pst.setString(1,paciente.getCpf());
		pst.setString(2,paciente.getNome());
                
                java.sql.Date dateReference = new Date(paciente.getDt_nascimento().getTime());
		pst.setDate(3, dateReference);
		pst.setString(4,paciente.getTelefone());
		pst.setString(5,paciente.getNumero_carteira());
		pst.setInt(6,paciente.getPlano().getCod_plano());

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
        
            String sql = "DELETE FROM Paciente WHERE cod_paciente=?";
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
            String sql = "UPDATE Paciente SET cpf=?, nome=?, dt_nascimento=?, telefone=?, numero_carteira=?, plano_cod_plano=? WHERE cod_paciente=?";
            try{
                PreparedStatement pst = c.prepareStatement(sql);
                
                pst.setString(1,paciente.getCpf());
		pst.setString(2,paciente.getNome());
                
                java.sql.Date dateReference = new Date(paciente.getDt_nascimento().getTime());
		pst.setDate(3, dateReference);
		pst.setString(4,paciente.getTelefone());
		pst.setString(5,paciente.getNumero_carteira());
		pst.setInt(6,paciente.getPlano().getCod_plano());
                pst.setInt(7, paciente.getCod_paciente());

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
                    
                    Plano_Saude plano = new Plano_Saude();
                    plano.setCod_plano(rs.getInt("plano_cod_plano"));
                    paciente.setPlano(plano);

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
        public ArrayList<Paciente> pesquisarPorCodigo(int cod_paciente) throws DatabaseException {
            ArrayList<Paciente> lista = new ArrayList();
            Paciente paciente = null;
            c = g.conectar();
            
            String sql = "SELECT cod_paciente, cpf, nome, dt_nascimento, telefone, numero_carteira, plano_cod_plano FROM Paciente WHERE id=?";
            
            try{
                PreparedStatement pst = c.prepareStatement(sql);
                pst.setInt(1, cod_paciente);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    paciente = new Paciente();

                    paciente.setCod_paciente(rs.getInt("cod_paciente"));
                    paciente.setCpf(rs.getString("cpf"));
                    paciente.setNome(rs.getString("nome"));
                    paciente.setDt_nascimento(rs.getDate("dt_nascimento"));
                    paciente.setTelefone(rs.getString("telefone"));
                    paciente.setNumero_carteira(rs.getString("numero_carteira"));
                    
                    Plano_Saude plano = new Plano_Saude();
                    plano.setCod_plano(rs.getInt("plano_cod_plano"));
                    paciente.setPlano(plano);

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
    public ArrayList<Paciente> pesquisarPorCPF(String cpf) throws DatabaseException {
        ArrayList<Paciente> lista = new ArrayList();
            Paciente paciente = null;
            c = g.conectar();
            
            String sql = "SELECT cod_paciente, cpf, nome, dt_nascimento, telefone, numero_carteira, plano_cod_plano FROM Paciente WHERE cpf=?";
            
            try{
                PreparedStatement pst = c.prepareStatement(sql);
                pst.setString(1, cpf);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    paciente = new Paciente();

                    paciente.setCod_paciente(rs.getInt("cod_paciente"));
                    paciente.setCpf(rs.getString("cpf"));
                    paciente.setNome(rs.getString("nome"));
                    paciente.setDt_nascimento(rs.getDate("dt_nascimento"));
                    paciente.setTelefone(rs.getString("telefone"));
                    paciente.setNumero_carteira(rs.getString("numero_carteira"));
                    
                    Plano_Saude plano = new Plano_Saude();
                    plano.setCod_plano(rs.getInt("plano_cod_plano"));
                    paciente.setPlano(plano);

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
    public ArrayList<Paciente> pesquisarPorNome(String nome_paciente) throws DatabaseException {
        ArrayList<Paciente> lista = new ArrayList();
            Paciente paciente = null;
            c = g.conectar();
            
            String sql = "SELECT cod_paciente, cpf, nome, dt_nascimento, telefone, numero_carteira, plano_cod_plano FROM Paciente WHERE nome=?";
            
            try{
                PreparedStatement pst = c.prepareStatement(sql);
                pst.setString(1, nome_paciente);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    paciente = new Paciente();

                    paciente.setCod_paciente(rs.getInt("cod_paciente"));
                    paciente.setCpf(rs.getString("cpf"));
                    paciente.setNome(rs.getString("nome"));
                    paciente.setDt_nascimento(rs.getDate("dt_nascimento"));
                    paciente.setTelefone(rs.getString("telefone"));
                    paciente.setNumero_carteira(rs.getString("numero_carteira"));
                    
                    Plano_Saude plano = new Plano_Saude();
                    plano.setCod_plano(rs.getInt("plano_cod_plano"));
                    paciente.setPlano(plano);

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
    public ArrayList<Paciente> pesquisarPorNumeroCarteira(String num_carteira) throws DatabaseException {
        ArrayList<Paciente> lista = new ArrayList();
            Paciente paciente = null;
            c = g.conectar();
            
            String sql = "SELECT cod_paciente, cpf, nome, dt_nascimento, telefone, numero_carteira, plano_cod_plano FROM Paciente WHERE numero_carteira=?";
            
            try{
                PreparedStatement pst = c.prepareStatement(sql);
                pst.setString(1, num_carteira);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    paciente = new Paciente();

                    paciente.setCod_paciente(rs.getInt("cod_paciente"));
                    paciente.setCpf(rs.getString("cpf"));
                    paciente.setNome(rs.getString("nome"));
                    paciente.setDt_nascimento(rs.getDate("dt_nascimento"));
                    paciente.setTelefone(rs.getString("telefone"));
                    paciente.setNumero_carteira(rs.getString("numero_carteira"));
                    
                    Plano_Saude plano = new Plano_Saude();
                    plano.setCod_plano(rs.getInt("plano_cod_plano"));
                    paciente.setPlano(plano);

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
