package negocio;

import classes_basicas.Consulta;
import classes_basicas.Medico;
import classes_basicas.Paciente;
import dao.IRepositorioConsulta;
import dao.RepositorioConsulta;
import exceptions.DatabaseException;
import exceptions.RepositorioException;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author macbookwhite
 */
public class NGConsulta {
    IRepositorioConsulta repConsulta = new RepositorioConsulta();
    
    public void inserirConsulta(Consulta c) throws DatabaseException{
        try{
            repConsulta.inserir(c);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public void excluirConsulta(Consulta c) throws DatabaseException{
        try{
            repConsulta.excluir(c);
        }catch(DatabaseException e){
            throw new DatabaseException (e);
        }
    }
    
    public void alterarConsulta(Consulta c) throws DatabaseException{
        try{
        repConsulta.alterar(c);
    
        }catch(DatabaseException e){
          throw new DatabaseException(e);  
        }
    }
    
    public ArrayList<Consulta> listarConsulta(Consulta c) throws DatabaseException{
        try{
            return repConsulta.listar();
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }  
    }
    
    public ArrayList<Consulta> pesquisarConsulta(int numeroConsulta) throws DatabaseException{
        try{
            Consulta consulta = new Consulta();
            consulta.setNumero_consulta(numeroConsulta);
            return repConsulta.pesquisar(consulta);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public ArrayList<Consulta> pesquisarConsultaPorPaciente(int paciente_codigo_paciente) throws DatabaseException{
        try{
            Consulta consulta = new Consulta();
            Paciente paciente = new Paciente();
            paciente.setCod_paciente(paciente_codigo_paciente);
            consulta.setPaciente(paciente);
            return repConsulta.pesquisar(consulta);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public ArrayList<Consulta> pesquisarConsultaPorMedito(int medico_id) throws DatabaseException{
        try{
            Consulta consulta = new Consulta();
            Medico medico = new Medico();
            medico.setId(medico_id);
            consulta.setMedico(medico);
            return repConsulta.pesquisar(consulta);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
}
