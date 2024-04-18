/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author linha
 */
public class FXMLMenuController implements Initializable {

    @FXML
    private Button buttonAgendamento;
    @FXML
    private Button buttonEntrada;
    @FXML
    private Button buttonSaida;
    @FXML
    private Menu menuCadastros;
    @FXML
    private MenuItem menuItemCliente;
    @FXML
    private MenuItem menuItemVeiculos;
    @FXML
    private MenuItem menuItemServicos;
    @FXML
    private MenuItem menuItemGerente;
    @FXML
    private MenuItem menuItemFuncionario;
    @FXML
    private Menu menuRelatorios;
    @FXML
    private MenuItem menuItemVeiculoCliente;
    @FXML
    private MenuItem menuItemTotalServicos;
    @FXML
    private MenuItem menuItemServicosCliente;
    @FXML
    private MenuItem menuItemQntAgendamentos;
    @FXML
    private Menu menuGraficos;
    @FXML
    private MenuItem menuItemAgendamentosGrafico;
    @FXML
    private MenuItem menuItemVeiculoMarca;
    @FXML
    private Button buttonSobre;
    @FXML
    private ImageView logo;
    @FXML
    private ImageView fecharmenu;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView ImagemCarro;
    @FXML
    private Text textNomeEmpresa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void handleButtonCadastrosAgendamentos() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafx/view/FXMLCadastroAgendamentos.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    public void handleButtonCadastrosEntradas() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafx/view/FXMLCadastroEntradas.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    public void handleButtonCadastrosSaidas() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafx/view/FXMLCadastroSaidaVeiculo.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    
 
    @FXML
    public void handleButtonCadastrosClientes() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafx/view/FXMLCadastrosClientes.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    public void handleButtonCadastrosVeiculos() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafx/view/FXMLCadastrosVeiculos.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    public void handleButtonCadastrosServicos() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafx/view/FXMLCadastrosServicos.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    public void handleButtonCadastrosGerentes() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafx/view/FXMLCadastroGerente.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    public void handleButtonCadastrosFuncionarios() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafx/view/FXMLCadastroFuncionario.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    public void handleButtonRelatorioVeiculosClientes() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafx/view/FXMLRelatoriosVeiculosClientes.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    public void handleButtonRelatorioValorTotalServicoPorCliente() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafx/view/FXMLRelatoriosValorTotalServicosPorCliente.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    public void handleButtonRelatorioQuantidadeETipoServicoPorCliente() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafx/view/FXMLRelatoriosQuantidadeETipoServicoPorCliente.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    public void handleButtonRelatorioQuantidadeAgendamentosPorCliente() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafx/view/FXMLAnchorPaneRelatoriosAgendamentosCliente.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    public void handleButtonGraficoAgendamentosPorMes() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafx/view/FXMLGraficosAgendamentosPorMes.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    public void handleButtonPaneGraficoVeiculoMarca() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafx/view/FXMLAnchorPaneGraficoVeiculoMarca.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    public void handleButtonSobre() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafx/view/FXMLSobre.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    public void buttonFecharPrograma() {
        Stage stage = (Stage) fecharmenu.getScene().getWindow();
        stage.close();
        Platform.exit();
    }
}
