package javafx.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author linha
 */
public class FXMLLoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button buttonLogin;

    @FXML
    private Button buttoncloseLogin;

    @FXML
    private TextField textuserLogin;

    @FXML
    private PasswordField senha;
    @FXML
    private AnchorPane AnchorPaneLogin;
    @FXML
    private ImageView imagemBotaoLogin;
    @FXML
    private ImageView imagem01;
    @FXML
    private ImageView imagemSigin;
    @FXML
    private ImageView imagemclose;
    @FXML
    private HBox hboxtela;

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeStageDraggable();
    }

    private void makeStageDraggable() {
        AnchorPaneLogin.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        AnchorPaneLogin.setOnMouseDragged((MouseEvent event) -> {
            Stage stage = (Stage) AnchorPaneLogin.getScene().getWindow();
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
    }

    public void handlebuttonLogin() throws IOException {
        /*   AnchorPane login = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafx/view/FXMLMenu.fxml"));
        AnchorPaneLogin.getChildren().setAll(login);
       
        AnchorPaneLogin.setMinWidth(995);
        AnchorPaneLogin.setMinHeight(676);*/

        String usuario = textuserLogin.getText();
        String senhaa = senha.getText();

        if (usuario != null && senha != null && usuario.equals("admin") && senhaa.equals("1234")) {
            Stage currentStage = (Stage) buttonLogin.getScene().getWindow();
            currentStage.close();

            Parent root = FXMLLoader.load(getClass().getResource("/javafx/view/FXMLMenu.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            root.setOnMousePressed((MouseEvent event) -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            root.setOnMouseDragged((MouseEvent event) -> {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            });

            stage.initStyle(StageStyle.UNDECORATED); // Remove as decorações da janela
            stage.setScene(scene);
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro de login");
            alert.setHeaderText(null);
            alert.setContentText("Usuário ou senha inválidos. Tente novamente");
            alert.showAndWait();
        }

    }

    @FXML
    public void buttonFecharPrograma() {
        Stage stage = (Stage) buttoncloseLogin.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

}
