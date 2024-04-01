package javafx.model.domain;

import java.io.Serializable;
import java.util.List;

public class Saida implements Serializable {

    private String codigoSaida;
    private Cliente cliente;
    private String cliente_nome; // Novo atributo adicionado
    private Veiculo veiculo;
    private String dataSaida;
    private String statusPagamento;
    private String statusServicoAgendado; // Novo atributo adicionado
    private List<Agendamento> agendamentos;
    private List<Servico> servicos;

    public Saida() {
    }

    public Saida(String codigoSaida, Cliente cliente, String cliente_nome, Veiculo veiculo,
                 String dataSaida, String statusPagamento, String statusServicoAgendado) {
        this.codigoSaida = codigoSaida;
        this.cliente = cliente;
        this.cliente_nome = cliente_nome;
        this.veiculo = veiculo;
        this.dataSaida = dataSaida;
        this.statusPagamento = statusPagamento;
        this.statusServicoAgendado = statusServicoAgendado;
    }

    public String getCodigoSaida() {
        return codigoSaida;
    }

    public void setCodigoSaida(String codigoSaida) {
        this.codigoSaida = codigoSaida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCliente_nome() {
        return cliente_nome;
    }

    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public String getStatusServicoAgendado() {
        return statusServicoAgendado;
    }

    public void setStatusServicoAgendado(String statusServicoAgendado) {
        this.statusServicoAgendado = statusServicoAgendado;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public String getIdSaida() {
        return codigoSaida;
    }

    public void setIdSaida(String idSaida) {
        this.codigoSaida = idSaida;
    }

    public void setClienteNome(String clienteNome) {
        this.cliente_nome = clienteNome;
    }
}
