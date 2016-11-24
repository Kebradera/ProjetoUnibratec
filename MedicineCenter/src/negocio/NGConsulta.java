package negocio;

import classes_basicas.Consulta;
import dao.IRepositorioConsulta;
import dao.RepositorioConsulta;
import exceptions.DatabaseException;
import java.sql.Date;
import java.util.ArrayList;
/**
 *
 * @author macbookwhite
 */
public class NGConsulta {
    IRepositorioConsulta repConsulta;

    public NGConsulta() {
        this.repConsulta = new RepositorioConsulta();
    }
    
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
    
    public ArrayList<Consulta> pesquisarConsultaPorCodigo(int numeroConsulta) throws DatabaseException{
        try{
            return repConsulta.pesquisarPorCodigo(numeroConsulta);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public ArrayList<Consulta> pesquisarConsultaPorPaciente(String nome_paciente) throws DatabaseException{
        try{
            return repConsulta.pesquisarPorPaciente(nome_paciente);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public ArrayList<Consulta> pesquisarConsultaPorMedico(String nome_medico) throws DatabaseException{
        try{
            return repConsulta.pesquisarPorMedico(nome_medico);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
    
    public ArrayList<Consulta> pesquisarConsultaPorData(Date data_consulta) throws DatabaseException{
        try{
            return repConsulta.pesquisarPorData(data_consulta);
        }catch(DatabaseException e){
            throw new DatabaseException(e);
        }
    }
}
