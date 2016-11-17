
package classes_basicas;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author aluno
 */
public class Consulta {
    private int numero_consulta;
    private Date data_consulta;
    
    private Medico medico;
    private Paciente paciente;
    private ArrayList<Procedimento> procedimentos;
    private double custo_consulta;

    /**
     * @return the numero_consulta
     */
    public int getNumero_consulta() {
        return numero_consulta;
    }

    /**
     * @param numero_consulta the numero_consulta to set
     */
    public void setNumero_consulta(int numero_consulta) {
        this.numero_consulta = numero_consulta;
    }

    /**
     * @return the data_consulta
     */
    public Date getData_consulta() {
        return data_consulta;
    }

    /**
     * @param data_consulta the data_consulta to set
     */
    public void setData_consulta(Date data_consulta) {
        this.data_consulta = data_consulta;
    }

    /**
     * @return the medico
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * @param medico the medico to set
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public ArrayList<Procedimento> getProcedimentos(){
        return this.procedimentos;
    }
    
    public void setProcedimentos(ArrayList<Procedimento> arrayProcedimentos){
        this.procedimentos = arrayProcedimentos;
    }
    
    public double getCusto_consulta(){
        return this.custo_consulta;
    }
    
    public void setCusto_consulta(double custo_consulta){
        this.custo_consulta = custo_consulta;
    }
}
