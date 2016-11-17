/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes_basicas.Medico;
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
 * @author l.bezerra.ferreira
 */
public class RepositorioMedico implements IRepositorioMedico{

    private final IGerenciadorConexao g;
    private Connection c;
    
    public RepositorioMedico(){
        g = GerenciadorConexaoMysql.getInstancia();
    }
    
    @Override
    public void inserir(Medico med) throws DatabaseException {
        c = g.conectar();
        String sql = "INSERT INTO Medico (nome, crm, especialidade) VALUES (?, ?, ?)";
        try{
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, med.getNome());
            pst.setString(2, med.getCrm());
            pst.setString(3, med.getEspecialidade());
            pst.executeUpdate();
        }catch(SQLException e){
            throw new DatabaseException(e);
        }finally{
            g.desconectar(c);
        }
    }

    @Override
    public void excluir(Medico med) throws DatabaseException {
        c = g.conectar();
        
        String sql = "DELETE FROM Medico WHERE id=?";
        try{
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, med.getId());
            pst.executeUpdate();
            pst.close();
        }catch(SQLException e){
            throw new DatabaseException(e);
        }finally{
            g.desconectar(c);
        }
    }
    
    @Override
    public void alterar(Medico med) throws DatabaseException {
        c = g.conectar();
        String sql = "UPDATE Medico SET nome=?,crm=?,especialidade=? WHERE id=?";
        try{
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1,med.getNome());
            pst.setString(2, med.getCrm());
            pst.setString(3, med.getEspecialidade());
            pst.setInt(4, med.getId());
            pst.executeUpdate();
        }catch(SQLException e){
            throw new DatabaseException(e);
        }finally{
            g.desconectar(c);
        }
    }

    @Override
    public ArrayList<Medico> listar() throws DatabaseException {
        ArrayList<Medico> lista = new ArrayList();
        Medico x;
        c = g.conectar();
        String sql = "SELECT id,nome,crm,especialidade FROM medico";
        try{
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                x = new Medico();
                x.setId(rs.getInt("id") );
                x.setNome(rs.getString("nome") );
                x.setCrm(rs.getString("crm") );
                x.setEspecialidade(rs.getString("especialidade") );
                lista.add(x);
            }
            
            return lista;
        }catch(SQLException e){
            throw new DatabaseException(e);
        }finally{
            g.desconectar(c);
        }
    }

    @Override
    public ArrayList<Medico> pesquisar(String nome) throws DatabaseException {
        ArrayList<Medico> x = new ArrayList<>();
        c = g.conectar();
        String sql = "SELECT id,nome, crm, especialidade FROM medico WHERE nome=?";
        g.desconectar(c);
        return x;
    }
    
}
