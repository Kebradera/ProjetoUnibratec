/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes_basicas.Consulta;
import classes_basicas.Medico;
import classes_basicas.Paciente;
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
        public ArrayList<Consulta> pesquisarPorCodigo(int codigo) throws DatabaseException {
            ArrayList<Consulta> lista = new ArrayList();
            Consulta consulta = null;
            c = g.conectar();
            
            String sql = "SELECT numero_consulta, data_consulta, medico_id, paciente_cod_paciente, custo_consulta FROM Consulta WHERE id=?";
            
            try{
                
                PreparedStatement pst = c.prepareStatement(sql);
                pst.setInt(1, codigo);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    consulta = new Consulta();
                    Medico med = new Medico();
                    Paciente pac = new Paciente();
                    
                    consulta.setNumero_consulta(rs.getInt("numero_consulta"));
                    consulta.setData_consulta(rs.getDate("data_consulta"));
                    
                    med.setId(rs.getInt("medico_id"));
                    consulta.setMedico(med);
                    pac.setCod_paciente(rs.getInt("paciente_cod_paciente"));
                    consulta.setPaciente(pac);
                    
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
    public ArrayList<Consulta> pesquisarPorData(Date data) throws DatabaseException {
        ArrayList<Consulta> lista = new ArrayList();
            Consulta consulta = null;
            c = g.conectar();
            
            String sql = "SELECT numero_consulta, data_consulta, medico_id, paciente_cod_paciente, custo_consulta FROM Consulta WHERE data_consulta=?";
            
            try{
                
                PreparedStatement pst = c.prepareStatement(sql);
                pst.setDate(1, data);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    consulta = new Consulta();
                    Medico med = new Medico();
                    Paciente pac = new Paciente();
                    
                    consulta.setNumero_consulta(rs.getInt("numero_consulta"));
                    consulta.setData_consulta(rs.getDate("data_consulta"));
                    
                    med.setId(rs.getInt("medico_id"));
                    consulta.setMedico(med);
                    pac.setCod_paciente(rs.getInt("paciente_cod_paciente"));
                    consulta.setPaciente(pac);
                    
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
    public ArrayList<Consulta> pesquisarPorMedico(String medico) throws DatabaseException {
        ArrayList<Consulta> lista = new ArrayList();
            Consulta consulta = null;
            c = g.conectar();
            
            String sql = "SELECT CONS.numero_consulta, CONS.data_consulta, CONS.medico_id, CONS.paciente_cod_paciente, CONS.custo_consulta FROM Consulta AS CONS INNER JOIN Medico AS MED ON CONS.medico_id = MED.medico_id WHERE nome=?";
            
            try{
                
                PreparedStatement pst = c.prepareStatement(sql);
                pst.setString(1, medico);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    consulta = new Consulta();
                    Medico med = new Medico();
                    Paciente pac = new Paciente();
                    
                    consulta.setNumero_consulta(rs.getInt("numero_consulta"));
                    consulta.setData_consulta(rs.getDate("data_consulta"));
                    
                    med.setId(rs.getInt("medico_id"));
                    consulta.setMedico(med);
                    pac.setCod_paciente(rs.getInt("paciente_cod_paciente"));
                    consulta.setPaciente(pac);
                    
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
    public ArrayList<Consulta> pesquisarPorPaciente(String paciente) throws DatabaseException {
        ArrayList<Consulta> lista = new ArrayList();
            Consulta consulta = null;
            c = g.conectar();
            
            String sql = "SELECT CONS.numero_consulta, CONS.data_consulta, CONS.medico_id, CONS.paciente_cod_paciente, CONS.custo_consulta FROM Consulta AS CONS INNER JOIN Paciente AS PAC ON CONS.paciente_cod_paciente = PAC.cod_paciente WHERE nome=?";
            
            try{
                
                PreparedStatement pst = c.prepareStatement(sql);
                pst.setString(1, paciente);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    consulta = new Consulta();
                    Medico med = new Medico();
                    Paciente pac = new Paciente();
                    
                    consulta.setNumero_consulta(rs.getInt("numero_consulta"));
                    consulta.setData_consulta(rs.getDate("data_consulta"));
                    
                    med.setId(rs.getInt("medico_id"));
                    consulta.setMedico(med);
                    pac.setCod_paciente(rs.getInt("paciente_cod_paciente"));
                    consulta.setPaciente(pac);
                    
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
