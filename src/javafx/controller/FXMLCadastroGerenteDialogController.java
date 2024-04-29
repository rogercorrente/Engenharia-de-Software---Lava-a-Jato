package javafx.controller;

import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.model.domain.Gerente;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLCadastroGerenteDialogController implements Initializable {

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
    private Gerente gerente;

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

    public Gerente getCliente() {
        return this.gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
        this.textFieldNome.setText(gerente.getNome());
        this.textFieldCpf.setText(gerente.getCpf());
        this.textFieldTelefone.setText(gerente.getTelefone());
        this.textFieldEmail.setText(gerente.getEmail());
        this.textFieldCargo.setText(gerente.getCargo());
        this.textFieldSalario.setText(String.valueOf(gerente.getSalario()));

    }

    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    @FXML
    public void handleButtonConfirmar() throws ParseException {
        if (validarEntradaDeDados()) {

            gerente.setNome(textFieldNome.getText());
            gerente.setCpf(textFieldCpf.getText());
            gerente.setTelefone(textFieldTelefone.getText());
            gerente.setEmail(textFieldEmail.getText());
            gerente.setCargo(textFieldCargo.getText());
            gerente.setSalario(Double.parseDouble(textFieldSalario.getText()));

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
