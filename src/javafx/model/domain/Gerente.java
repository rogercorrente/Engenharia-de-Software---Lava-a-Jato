
package javafx.model.domain;

public class Gerente {

    private int idGere;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String cargo;
    private double salario;

    public Gerente() {

    }

    public Gerente(String nome, String cpf, String telefone, String email, String cargo, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.cargo = cargo;
        this.salario = salario;
    }

    public int getIdGere() {
        return idGere;
    }

    public void setIdGere(int idFunc) {
        this.idGere = idFunc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
