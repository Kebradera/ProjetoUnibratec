/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes_basicas.Consulta;
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
public class RepositorioConsulta implements IRepositorioConsulta {
        private final IGerenciadorConexao g;
        private Connection c;

        public RepositorioConsulta(){
            g = GerenciadorConexaoMysql.getInstancia();
        }
        
        @Override
        public void inserir(Consulta consulta) throws DatabaseException {
            c = g.conectar();
            String sql = "STATEMENT";
            try{
                PreparedStatement pst = c.prepareStatement(sql);


                
            pst.setInt(1,consulta.getNumero_consulta());
		//pst.setDate(2, consulta.getData_consulta());
		pst.setInt(3,consulta.getMedico().getId());
		pst.setInt(4,consulta.getPaciente().getCod_paciente());
		pst.setDouble(5,consulta.getCusto_consulta());

                pst.executeUpdate();
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
        }
        
        
        @Override
        public void excluir(Consulta consulta) throws DatabaseException {
            c = g.conectar();
        
            String sql = "DELETE FROM Consulta WHERE id=?";
            try{
                PreparedStatement pst = c.prepareStatement(sql);
                
                pst.setInt(1, consulta.getNumero_consulta());

                pst.executeUpdate();
                pst.close();
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
        }
        
        @Override
        public void alterar(Consulta consulta) throws DatabaseException {
            c = g.conectar();
            String sql = "STATEMENT";
            try{
                PreparedStatement pst = c.prepareStatement(sql);
                
                pst.setInt(1,consulta.getNumero_consulta());
		//pst.setDate(2,consulta.getData_consulta());
		pst.setInt(3,consulta.getMedico().getId());
		pst.setInt(4,consulta.getPaciente().getCod_paciente());
		pst.setDouble(5,consulta.getCusto_consulta());

                pst.executeUpdate();
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
        }
        
        @Override
        public ArrayList<Consulta> listar() throws DatabaseException {
            ArrayList<Consulta> lista = new ArrayList();
            Consulta consulta;
            c = g.conectar();
            
             String sql = "SELECT numero_consulta, data_consulta, medico_id, paciente_cod_paciente, custo_consulta FROM Consulta";

            try{
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(sql);
            
                while(rs.next()){
                    consulta = new Consulta();
                    
                    consulta.setNumero_consulta(rs.getInt("numero_consulta"));
                    consulta.setData_consulta(rs.getDate("data_consulta"));
                    //consulta.setMedico_id(rs.getInt("medico_id"));
                    //consulta.setPaciente_cod_paciente(rs.getInt('paciente_cod_paciente'));
                    consulta.setCusto_consulta(rs.getDouble("custo_consulta"));
                    lista.add(consulta);
                }
            
                return lista;
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
        }
        
        @Override
        public ArrayList<Consulta> pesquisar(Consulta consultaparam) throws DatabaseException {
            ArrayList<Consulta> lista = new ArrayList();
            Consulta consulta = null;
            c = g.conectar();
            
            String sql = "SELECT numero_consulta, data_consulta, medico_id, paciente_cod_paciente, custo_consulta FROM Consulta WHERE id=?";
            
            try{
                
                PreparedStatement pst = c.prepareStatement(sql);
                pst.setInt(1, consultaparam.getNumero_consulta());
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    consulta = new Consulta();
                    consulta.setNumero_consulta(rs.getInt("numero_consulta"));
                    consulta.setData_consulta(rs.getDate("data_consulta"));
                    //consulta.setMedico_id(rs.getInt("medico_id"));
                    //consulta.setPaciente_cod_paciente(rs.getInt('paciente_cod_paciente'));
                    consulta.setCusto_consulta(rs.getDouble("custo_consulta"));
                    lista.add(consulta);
                }
                return lista;
            }catch(SQLException e){
                throw new DatabaseException(e);
            }finally{
                g.desconectar(c);
            }
        }
}
