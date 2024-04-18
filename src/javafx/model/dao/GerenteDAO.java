/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.model.domain.Gerente;

/**
 *
 * @author 20211si022
 */
public class GerenteDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Gerente gerente) {
        String sql = "INSERT INTO gerente(nome, cpf, telefone, email, cargo, salario) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, gerente.getNome());
            stmt.setString(2, gerente.getCpf());
            stmt.setString(3, gerente.getTelefone());
            stmt.setString(4, gerente.getEmail());
            stmt.setString(5, gerente.getCargo());
            stmt.setDouble(6, gerente.getSalario());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Gerente gerente) {
        String sql = "UPDATE gerente SET nome=?, cpf=?, telefone=?, email=?, cargo=?, salario=? WHERE idGere=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, gerente.getNome());
            stmt.setString(2, gerente.getCpf());
            stmt.setString(3, gerente.getTelefone());
            stmt.setString(4, gerente.getEmail());
            stmt.setString(5, gerente.getCargo());
            stmt.setDouble(6, gerente.getSalario());
            stmt.setInt(7, gerente.getIdGere());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Gerente gerente) {
        String sql = "DELETE FROM gerente WHERE idGere=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, gerente.getIdGere());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GerenteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Gerente> listar() {
        String sql = "SELECT * FROM gerente";
        List<Gerente> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Gerente gerente = new Gerente();
                gerente.setIdGere(resultado.getInt("idGere"));
                gerente.setNome(resultado.getString("nome"));
                gerente.setCpf(resultado.getString("cpf"));
                gerente.setTelefone(resultado.getString("telefone"));
                gerente.setEmail(resultado.getString("email"));
                gerente.setCargo(resultado.getString("cargo"));
                gerente.setSalario(resultado.getDouble("salario"));
                retorno.add(gerente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public Gerente buscar(Gerente gerente) {
        String sql = "SELECT * FROM funcionario WHERE idGere=?";
        Gerente retorno = new Gerente();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, gerente.getIdGere());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                gerente.setNome(resultado.getString("nome"));
                gerente.setCpf(resultado.getString("cpf"));
                gerente.setTelefone(resultado.getString("telefone"));
                gerente.setEmail(resultado.getString("email"));
                gerente.setCargo(resultado.getString("cargo"));
                gerente.setSalario(resultado.getDouble("salario"));
                retorno = gerente;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

}
