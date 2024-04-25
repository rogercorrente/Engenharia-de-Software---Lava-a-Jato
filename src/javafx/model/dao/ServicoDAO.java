package javafx.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.model.domain.Cliente;
import javafx.model.domain.Servico;
import javafx.model.domain.Veiculo;

public class ServicoDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Servico servico) {
        String sql = "INSERT INTO servicos(tipo_servico, descricao, tempo_estimado, valor_avista, valor_aprazo) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, servico.getTipoServico());
            stmt.setString(2, servico.getDescricao());
            stmt.setString(3, servico.getTempoEstimado());
            stmt.setDouble(4, servico.getValorAVista());
            stmt.setDouble(5, servico.getValorAprazo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Servico servico) {
        String sql = "UPDATE servicos SET tipo_servico=?, descricao=?, tempo_estimado=?, valor_avista=?, valor_aprazo=? WHERE cdServico=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, servico.getTipoServico());
            stmt.setString(2, servico.getDescricao());
            stmt.setString(3, servico.getTempoEstimado());
            stmt.setDouble(4, servico.getValorAVista());
            stmt.setDouble(5, servico.getValorAprazo());
            stmt.setInt(6, servico.getCdServico());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Servico servico) {
        String sql = "DELETE FROM servicos WHERE cdServico=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, servico.getCdServico());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Servico> listar() {
        String sql = "SELECT * FROM servicos";
        List<Servico> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Servico servico = new Servico();
                servico.setCdServico(resultado.getInt("cdServico"));
                servico.setTipoServico(resultado.getString("tipo_servico"));
                servico.setDescricao(resultado.getString("descricao"));
                servico.setTempoEstimado(resultado.getString("tempo_estimado"));
                servico.setValorAVista(resultado.getDouble("valor_avista"));
                servico.setValorAprazo(resultado.getDouble("valor_aprazo"));
                retorno.add(servico);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public Servico buscar(Servico servico) {
        String sql = "SELECT * FROM servicos WHERE cdServico=?";
        Servico retorno = new Servico();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, servico.getCdServico());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                servico.setTipoServico(resultado.getString("tipo_servico"));
                servico.setDescricao(resultado.getString("descricao"));
                servico.setTempoEstimado(resultado.getString("tempo_estimado"));
                servico.setValorAVista(resultado.getInt("valor_avista"));
                servico.setValorAprazo(resultado.getInt("valor_aprazo"));
                retorno = servico;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    public List<Servico> listarPorCliente(Cliente cliente) {
    if (connection == null) {
        // Trate o caso em que a conexão é nula
        return new ArrayList<>();
    }

    String sql = "SELECT s.* FROM servicos s " +
                 "JOIN clientes c ON c.cdCliente = s.cdCliente " +
                 "WHERE c.cdCliente = ?";
    List<Servico> servicos = new ArrayList<>();
    try {
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, cliente.getCdCliente());
        ResultSet resultado = stmt.executeQuery();
        while (resultado.next()) {
            Servico servico = new Servico();
            servico.setCdServico(resultado.getInt("cdServico"));
            servico.setTipoServico(resultado.getString("tipo_servico"));
            servico.setDescricao(resultado.getString("descricao"));
            servico.setTempoEstimado(resultado.getString("tempo_estimado"));
            servico.setValorAVista(resultado.getDouble("valor_avista"));
            servico.setValorAprazo(resultado.getDouble("valor_aprazo"));
            servicos.add(servico);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return servicos;
    }
    public List<Servico> listarPorVeiculo(Veiculo veiculo) {
    if (connection == null) {
        // Trate o caso em que a conexão é nula
        return new ArrayList<>();
    }

    String sql = "SELECT s.* FROM servicos s " +
                 "JOIN clientes c ON c.cdCliente = s.cdCliente " +
                 "WHERE c.cdCliente = ?";
    List<Servico> servicos = new ArrayList<>();
    try {
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, veiculo.getCdVeiculo());
        ResultSet resultado = stmt.executeQuery();
        while (resultado.next()) {
            Servico servico = new Servico();
            servico.setCdServico(resultado.getInt("cdServico"));
            servico.setTipoServico(resultado.getString("tipo_servico"));
            servico.setDescricao(resultado.getString("descricao"));
            servico.setTempoEstimado(resultado.getString("tempo_estimado"));
            servico.setValorAVista(resultado.getDouble("valor_avista"));
            servico.setValorAprazo(resultado.getDouble("valor_aprazo"));
            servicos.add(servico);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return servicos;
 }
}
