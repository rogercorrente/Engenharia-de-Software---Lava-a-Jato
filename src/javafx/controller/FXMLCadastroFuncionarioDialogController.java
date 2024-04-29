package javafx.controller;

import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.model.domain.Funcionario;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLCadastroFuncionarioDialogController implements Initializable {

    @FXML
    private TextField textFieldNome;
    @FXML
    private TextField textFieldCpf;
    @FXML
    private TextField textFieldTelefone;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldCargo;
    @FXML
    private TextField textFieldSalario;
    @FXML
    private Button buttonConfirmar;
    @FXML
    private Button buttonCancelar;

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Funcionario funcionario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public Funcionario getCliente() {
        return this.funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
        this.textFieldNome.setText(funcionario.getNome());
        this.textFieldCpf.setText(funcionario.getCpf());
        this.textFieldTelefone.setText(funcionario.getTelefone());
        this.textFieldEmail.setText(funcionario.getEmail());
        this.textFieldCargo.setText(funcionario.getCargo());
        this.textFieldSalario.setText(String.valueOf(funcionario.getSalario()));

    }

    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    @FXML
    public void handleButtonConfirmar() throws ParseException {
        if (validarEntradaDeDados()) {

            funcionario.setNome(textFieldNome.getText());
            funcionario.setCpf(textFieldCpf.getText());
            funcionario.setTelefone(textFieldTelefone.getText());
            funcionario.setEmail(textFieldEmail.getText());
            funcionario.setCargo(textFieldCargo.getText());
            funcionario.setSalario(Double.parseDouble(textFieldSalario.getText()));

            buttonConfirmarClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    public void handleButtonCancelar() {
        getDialogStage().close();
    }

    //Validar entrada de dados para o cadastro
    private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (textFieldNome.getText() == null || textFieldNome.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
        }
        if (textFieldCpf.getText() == null || textFieldCpf.getText().length() == 0) {
            errorMessage += "Favricante inválido!\n";
        }
        if (textFieldTelefone.getText() == null || textFieldTelefone.getText().length() == 0) {
            errorMessage += "Quantidade inválida!\n";
        }
        if (textFieldEmail.getText() == null || textFieldEmail.getText().length() == 0) {
            errorMessage += "Quantidade inválida!\n";
        }
        if (textFieldTelefone.getText() == null || textFieldTelefone.getText().length() == 0) {
            errorMessage += "Quantidade inválida!\n";
        }
        if (textFieldSalario.getText() == null || textFieldSalario.getText().length() == 0) {
            errorMessage += "Quantidade inválida!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Mostrando a mensagem de erro
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Campos inválidos, por favor, corrija...");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }
}
