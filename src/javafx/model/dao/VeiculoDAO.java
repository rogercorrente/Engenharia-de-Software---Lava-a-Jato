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
import javafx.model.domain.Veiculo;

public class VeiculoDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Veiculo veiculo) {
        String sql = "INSERT INTO veiculos(tipo_veiculo, placa, modelo, marca, categoria, cdCliente) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, veiculo.getTipoVeiculo());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setString(3, veiculo.getModelo());
            stmt.setString(4, veiculo.getMarca());
            stmt.setString(5, veiculo.getCategoria());
            stmt.setInt(6, veiculo.getCliente().getCdCliente());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Veiculo veiculo) {
        String sql = "UPDATE veiculos SET tipo_veiculo=?, placa=?, modelo=?, marca=?, categoria=?, cdCliente=? WHERE cdVeiculo=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, veiculo.getTipoVeiculo());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setString(3, veiculo.getModelo());
            stmt.setString(4, veiculo.getMarca());
            stmt.setString(5, veiculo.getCategoria());
            stmt.setInt(6, veiculo.getCliente().getCdCliente());
            stmt.setInt(7, veiculo.getCdVeiculo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Veiculo veiculo) {
        String sql = "DELETE FROM veiculos WHERE cdVeiculo=?";
        try {
            // Verifica se o veiculo tem registros relacionados na outra tabela
            String consulta = "SELECT COUNT(*) FROM veiculos WHERE cdVeiculo=?";
            PreparedStatement stmtConsulta = connection.prepareStatement(consulta);
            stmtConsulta.setInt(1, veiculo.getCdVeiculo());
            ResultSet resultado = stmtConsulta.executeQuery();
            if (resultado.next() && resultado.getInt(1) > 0) {
                // Se o veiculo tiver registros relacionados, exclui os registros antes de excluir o agendamento
                String sql2 = "DELETE FROM agendamentos WHERE cdVeiculo=?";
                PreparedStatement stmtsql2 = connection.prepareStatement(sql2);
                stmtsql2.setInt(1, veiculo.getCdVeiculo());
                stmtsql2.executeUpdate();
            }

            // Exclui o cliente da tabela
            PreparedStatement stmtVeiculos = connection.prepareStatement(sql);
            stmtVeiculos.setInt(1, veiculo.getCdVeiculo());
            stmtVeiculos.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Veiculo> listar() {
        String sql = "SELECT * FROM veiculos";
        List<Veiculo> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Veiculo veiculo = new Veiculo();
                Cliente cliente = new Cliente();
                veiculo.setCdVeiculo(resultado.getInt("cdVeiculo"));
                veiculo.setTipoVeiculo(resultado.getString("tipo_veiculo"));
                veiculo.setPlaca(resultado.getString("placa"));
                veiculo.setModelo(resultado.getString("modelo"));
                veiculo.setMarca(resultado.getString("marca"));
                veiculo.setCategoria(resultado.getString("categoria"));
                cliente.setCdCliente(resultado.getInt("cdCliente"));

                ClienteDAO clienteDAO = new ClienteDAO();
                clienteDAO.setConnection(connection);
                cliente = clienteDAO.buscar(cliente);

                veiculo.setCliente(cliente);
                retorno.add(veiculo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public Veiculo buscar(Veiculo veiculo) {
        String sql = "SELECT * FROM veiculos WHERE cdVeiculo=?";
        Veiculo retorno = new Veiculo();
        Cliente cliente = new Cliente();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, veiculo.getCdVeiculo());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                veiculo.setTipoVeiculo(resultado.getString("tipo_veiculo"));
                veiculo.setPlaca(resultado.getString("placa"));
                veiculo.setModelo(resultado.getString("modelo"));
                veiculo.setMarca(resultado.getString("marca"));
                veiculo.setCategoria(resultado.getString("categoria"));
                cliente.setCdCliente(resultado.getInt("cdCliente"));

                retorno = veiculo; // MUDEI AQUI PARA FUNCIONAR O VEICULO NO AGENDAMENTO
            }
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public List<Veiculo> listarPorCliente(Cliente cliente) {
        String sql = "SELECT * FROM veiculos WHERE cdCliente=?";
        List<Veiculo> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getCdCliente());
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setCdVeiculo(resultado.getInt("cdVeiculo"));
                veiculo.setTipoVeiculo(resultado.getString("tipo_veiculo"));
                veiculo.setPlaca(resultado.getString("placa"));
                veiculo.setModelo(resultado.getString("modelo"));
                veiculo.setMarca(resultado.getString("marca"));
                veiculo.setCategoria(resultado.getString("categoria"));
                veiculo.setCliente(cliente);
                retorno.add(veiculo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public Veiculo buscarPorCliente(Cliente cliente) {
        String sql = "SELECT * FROM veiculos WHERE cdCliente=?";
        Veiculo veiculo = null;

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getCdCliente());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                veiculo = new Veiculo();
                veiculo.setCdVeiculo(resultado.getInt("cdVeiculo"));
                veiculo.setTipoVeiculo(resultado.getString("tipo_veiculo"));
                veiculo.setPlaca(resultado.getString("placa"));
                veiculo.setModelo(resultado.getString("modelo"));
                veiculo.setMarca(resultado.getString("marca"));
                veiculo.setCategoria(resultado.getString("categoria"));
                veiculo.setCliente(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veiculo;
    }

}
