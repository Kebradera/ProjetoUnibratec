
package classes_basicas;

import java.util.Date;

/**
 *
 * @author aluno
 */
public class Paciente {
    private int cod_paciente;
    private String cpf;
    private String nome;
    private Date dt_nascimento;
    private String telefone;
    private String numero_carteira;
    
    private Plano_Saude plano;

    /**
     * @return the cod_paciente
     */
    public int getCod_paciente() {
        return cod_paciente;
    }

    /**
     * @param cod_paciente the cod_paciente to set
     */
    public void setCod_paciente(int cod_paciente) {
        this.cod_paciente = cod_paciente;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the dt_nascimento
     */
    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    /**
     * @param dt_nascimento the dt_nascimento to set
     */
    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the numero_carteira
     */
    public String getNumero_carteira() {
        return numero_carteira;
    }

    /**
     * @param numero_carteira the numero_carteira to set
     */
    public void setNumero_carteira(String numero_carteira) {
        this.numero_carteira = numero_carteira;
    }

    /**
     * @return the plano
     */
    public Plano_Saude getPlano() {
        return plano;
    }

    /**
     * @param plano the plano to set
     */
    public void setPlano(Plano_Saude plano) {
        this.plano = plano;
    }
}
