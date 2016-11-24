package fachada;

import classes_basicas.Consulta;
import classes_basicas.Medico;
import classes_basicas.Paciente;
import classes_basicas.Plano_Saude;
import classes_basicas.Procedimento;
import exceptions.DadosFaltandoException;
import exceptions.DatabaseException;
import exceptions.ParametroInvalidoException;
import exceptions.RepositorioException;
import java.sql.Date;
import java.util.ArrayList;
import negocio.*;

/**
 *
 * @author macbookwhite
 */
public class Fachada {
    private NGConsulta negocio_consulta;
    private NGMedico negocio_medico;
    private NGPaciente negocio_paciente;
    private NGPlano_Saude negocio_plano;
    private NGProcedimento negocio_proc;
    
    public Fachada(){
        negocio_consulta = new NGConsulta();
        negocio_medico = new NGMedico();
        negocio_paciente = new NGPaciente();
        negocio_plano = new NGPlano_Saude();
        negocio_proc = new NGProcedimento();
    }
    
    
    /*  
        Consulta
    */
    
    public void inserirConsulta(Consulta c) throws DadosFaltandoException, DatabaseException {
        this.negocio_consulta.inserirConsulta(c);
    }
    
    public void excluirConsulta(Consulta c) throws DatabaseException {
        this.negocio_consulta.excluirConsulta(c);
    }
       
    public void alterarConsulta(Consulta c) throws DatabaseException, DadosFaltandoException{
        this.negocio_consulta.alterarConsulta(c);
    }
    
    public ArrayList<Consulta> listarConsultas(Consulta c) throws DatabaseException{
        return this.negocio_consulta.listarConsulta(c);
    }
    
    public ArrayList<Consulta> pesquisarConsultaPorCodigo(int numeroConsulta) throws DatabaseException, ParametroInvalidoException{
        return this.pesquisarConsultaPorCodigo(numeroConsulta);
    }
    
    public ArrayList<Consulta> pesquisarConsultaPorPaciente(String nome_paciente) throws DatabaseException, ParametroInvalidoException{
        return this.negocio_consulta.pesquisarConsultaPorPaciente(nome_paciente);
    }
    
    public ArrayList<Consulta> pesquisarConsultaPorMedico(String nome_medico) throws DatabaseException, ParametroInvalidoException{
        return this.negocio_consulta.pesquisarConsultaPorMedico(nome_medico);
    }
    
    public ArrayList<Consulta> pesquisarConsultaPorData(Date data_consulta) throws DatabaseException, ParametroInvalidoException{
        return this.negocio_consulta.pesquisarConsultaPorData(data_consulta);
    }
    
    
    /*  
        Medico
    */
    
    public void inserirMedico(Medico med) throws DatabaseException, DadosFaltandoException{
        this.negocio_medico.inserir(med);
    }
    
    public void alterarMedico(Medico med) throws DatabaseException, DadosFaltandoException {
        this.negocio_medico.alterar(med);
    }
    
    public void excluirMedico(Medico med) throws DatabaseException{
        this.negocio_medico.excluir(med);
    }
        
    public ArrayList<Medico> listarMedicos()throws DatabaseException{
        return this.negocio_medico.listar();
    }
    
    public ArrayList<Medico> pesquisarMedicoPorNome(String nome)throws DatabaseException, RepositorioException, ParametroInvalidoException{
        return this.negocio_medico.pesquisarPorNome(nome);
    }
    
    public ArrayList<Medico> pesquisarMedicoPorCRM(String crm)throws DatabaseException, RepositorioException, ParametroInvalidoException{
        return this.negocio_medico.pesquisarPorCRM(crm);
    }
    
    public ArrayList<Medico> pesquisarMedicoPorEspecialidade(String especialidade)throws DatabaseException, RepositorioException, ParametroInvalidoException{
        return this.negocio_medico.pesquisarMedicoPorEspecialidade(especialidade);
    }
    
    /*  
        Paciente
    */
    
    public void inserirPaciente(Paciente p) throws DatabaseException, DadosFaltandoException{
        this.negocio_paciente.inserirPaciente(p);
    }
    
    public void excluirPaciente(Paciente p) throws DatabaseException {
        this.negocio_paciente.excluirPaciente(p);
    }
    
    public void alterarPaciente(Paciente p) throws DatabaseException, DadosFaltandoException {
        this.negocio_paciente.alterarPaciente(p);
    }
    
    public ArrayList<Paciente> listarPacientes() throws DatabaseException{
        return this.negocio_paciente.listarPacientes();
    }
    
    public ArrayList<Paciente> pesquisarPacientePorCPF(String cpf) throws DatabaseException, ParametroInvalidoException{
        return this.negocio_paciente.pesquisarPacientePorCPF(cpf);
    }
    
    public ArrayList<Paciente> pesquisarPacientePorCodigo(int codigo) throws DatabaseException, ParametroInvalidoException{
        return this.negocio_paciente.pesquisarPacientePorCodigo(codigo);
    }
    
    public ArrayList<Paciente> pesquisarPacientesPorNome(String nome) throws DatabaseException, ParametroInvalidoException{
        return this.negocio_paciente.pesquisarPacientePorNome(nome);
    }
    
    public ArrayList<Paciente> pesquisarPacientePorNumeroCarteira(String numero_carteira) throws DatabaseException, ParametroInvalidoException{
        return this.negocio_paciente.pesquisarPorNumeroCarteira(numero_carteira);
    }
    
    /*  
        Plano de Saúde
    */
    
    public void inserirPlanoSaude(Plano_Saude ps) throws DatabaseException, DadosFaltandoException{
        this.negocio_plano.inserirPlanoSaude(ps);
    }
    
    public void excluirPlanoSaude(Plano_Saude ps) throws DatabaseException{
        this.negocio_plano.excluirPlanoSaude(ps);
    }
    
    public void alterarPlanoSaude(Plano_Saude ps) throws DatabaseException, DadosFaltandoException{
        this.negocio_plano.alterarPlanoSaude(ps);
    }
    
    public ArrayList<Plano_Saude> listarPlanosSaude(Plano_Saude ps) throws DatabaseException{
        return this.negocio_plano.listarPlanoSaude(ps);
    }
    
    public ArrayList<Plano_Saude> pesquisarPlanoPorCodigo(int cod_plano) throws DatabaseException, ParametroInvalidoException{     
        return this.negocio_plano.pesquisarPlanoPorCodigo(cod_plano);
    }
    
    public ArrayList<Plano_Saude> pesquisarPlanoSaudePorOperadora(String nome_operadora) throws DatabaseException, ParametroInvalidoException{     
        return this.negocio_plano.pesquisarPlanoSaudePorOperadora(nome_operadora);
    }
    
    /*  
        Procedimento
    */
    
    public void inserirProcedimento(Procedimento p) throws DatabaseException, DadosFaltandoException{
        this.negocio_proc.inserirProcedimento(p);
    }
    
    public void excluirProcedimento(Procedimento p) throws DatabaseException{
        this.negocio_proc.excluirProcedimento(p);
    }
    
    public void alterarProcedimento(Procedimento p) throws DatabaseException, DadosFaltandoException{
        this.negocio_proc.alterarProcedimento(p);
    }
    
    public ArrayList<Procedimento> listarProcedimento(Procedimento p) throws DatabaseException{
        return this.negocio_proc.listarProcedimento(p);
    }
    
    public ArrayList<Procedimento> pesquisarProcedimentoPorCodigo(int cod_procedimento) throws DatabaseException, ParametroInvalidoException{
        return this.negocio_proc.pesquisarProcedimento(cod_procedimento);
    }
    
    public ArrayList<Procedimento> pesquisarProcedimentoPorDescricao(String descricao) throws DatabaseException, ParametroInvalidoException{
        return this.negocio_proc.pesquisarProcedimentoPorDescricao(descricao);
    }
    
}
