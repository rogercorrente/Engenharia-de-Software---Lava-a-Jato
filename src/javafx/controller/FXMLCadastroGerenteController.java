package javafx.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.model.dao.FuncionarioDAO;
import javafx.model.dao.GerenteDAO;
import javafx.model.database.Database;
import javafx.model.database.DatabaseFactory;
import javafx.model.domain.Gerente;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXMLCadastroGerenteController implements Initializable {

    @FXML
    private TableView<Gerente> tableViewGerente;
    @FXML
    private TableColumn<Gerente, String> tableColumnNome;
    @FXML
    private TableColumn<Gerente, String> tableColumnCPF;
    @FXML
    private Label labelCodigo;
    @FXML
    private Label labelNome;
    @FXML
    private Label labelCPF;
    @FXML
    private Label labelTelefone;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelCargo;
    @FXML
    private Label labelSalario;
    @FXML
    private Button buttonInserir;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonRemover;

    private double xOffset = 0;
    private double yOffset = 0;

    private List<Gerente> listGerente;
    private ObservableList<Gerente> observableListGerente;

    //Atributos para manipulação de Banco de Dados
    private final Database database = DatabaseFactory.getDatabase("postgresql");
    private final Connection connection = database.conectar();
    private final GerenteDAO gerenteDAO = new GerenteDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gerenteDAO.setConnection(connection);

        carregarTableViewFuncionarios();
        makeStageDraggable();
        // Limpando a exibição dos detalhes do cliente
        selecionarItemTableViewFuncionarios(null);

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tableViewGerente.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewFuncionarios(newValue));
    }

    public void carregarTableViewFuncionarios() {
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        listGerente = gerenteDAO.listar();

        observableListGerente = FXCollections.observableArrayList(listGerente);
        tableViewGerente.setItems(observableListGerente);
    }

    public void selecionarItemTableViewFuncionarios(Gerente gerente) {
        if (gerente != null) {
            labelCodigo.setText(String.valueOf(gerente.getIdGere()));
            labelNome.setText(gerente.getNome());
            labelCPF.setText(gerente.getCpf());
            labelTelefone.setText(gerente.getTelefone());
            labelEmail.setText(gerente.getEmail());
            labelCargo.setText(gerente.getCargo());
            labelSalario.setText(String.valueOf(gerente.getSalario()));
        } else {
            labelCodigo.setText("");
            labelNome.setText("");
            labelCPF.setText("");
            labelTelefone.setText("");
            labelEmail.setText("");
            labelCargo.setText("");
            labelSalario.setText("");
        }
    }

    @FXML
    public void handleButtonInserir() throws IOException {
        Gerente gerente = new Gerente();
        boolean buttonConfirmarClicked = showFXMLCadastroGerenteDialog(gerente);
        if (buttonConfirmarClicked) {
            gerenteDAO.inserir(gerente);
            carregarTableViewFuncionarios();
        }
    }

    @FXML
    public void handleButtonAlterar() throws IOException {
        Gerente gerente = tableViewGerente.getSelectionModel().getSelectedItem();
        if (gerente != null) {
            boolean buttonConfirmarClicked = showFXMLCadastroGerenteDialog(gerente);
            if (buttonConfirmarClicked) {
                gerenteDAO.alterar(gerente);
                carregarTableViewFuncionarios();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um funcionario na Tabela!");
            alert.show();
        }
    }

    @FXML
    public void handleButtonRemover() throws IOException {
        Gerente gerente = tableViewGerente.getSelectionModel().getSelectedItem();
        if (gerente != null) {
            gerenteDAO.remover(gerente);
            carregarTableViewFuncionarios();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um funcionario na Tabela!");
            alert.show();
        }
    }

    public boolean showFXMLCadastroGerenteDialog(Gerente gerente) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLCadastroFuncionarioDialogController.class.getResource("/javafx/view/FXMLCadastroGerenteDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Gerente");
        //dialogStage.initStyle(StageStyle.UNDECORATED);

        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        FXMLCadastroGerenteDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setGerente(gerente);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();

    }

    private void makeStageDraggable() {
        tableViewGerente.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        tableViewGerente.setOnMouseDragged((MouseEvent event) -> {
            Stage stage = (Stage) tableViewGerente.getScene().getWindow();
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
    }

}
