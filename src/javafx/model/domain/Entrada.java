package javafx.model.domain;

import java.time.LocalDate;

public class Entrada {
    private int cdEntrada;
    private Cliente cdCliente;
    private Veiculo cdVeiculo;
    private Servico cdServico;
    private String hora_entrada;
    private Agendamento agendamento;

    public Entrada() {
    }

    public Entrada(int cdEntrada, Cliente cdCliente, Veiculo cdVeiculo, Servico cdServico, String hora_entrada) {
        this.cdEntrada = cdEntrada;
        this.cdCliente = cdCliente;
        this.cdVeiculo = cdVeiculo;
        this.cdServico = cdServico;
        this.hora_entrada = hora_entrada;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public int getCdEntrada() {
        return cdEntrada;
    }

    public void setCdEntrada(int cdAgendamento) {
        this.cdEntrada = cdAgendamento;
    }

    public Cliente getCliente() {
        return cdCliente;
    }

    public void setCliente(Cliente cdCliente) {
        this.cdCliente = cdCliente;
    }

    public Veiculo getVeiculo() {
        return cdVeiculo;
    }

    public void setVeiculo(Veiculo cdVeiculo) {
        this.cdVeiculo = cdVeiculo;
    }

    public Servico getServico() {
        return cdServico;
    }

    public void setServico(Servico cdServico) {
        this.cdServico = cdServico;
    }

    public String getHorarioEntrada() {
        return hora_entrada;
    }

    public void setHorarioEntrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getPlacaVeiculo() {
        return cdVeiculo.getPlaca();
    }

    public String getNomeServico() {
        return cdServico.getTipoServico();
    }

    public double getValorAVista() {
        return cdServico.getValorAVista();
    }

    @Override
    public String toString() {
        return this.hora_entrada;
    }
}
