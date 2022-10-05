/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author kurd
 */
public class UserController implements Initializable {

    @FXML
    private TextField textFieldUsername;
    @FXML
    private TextField textFieldIpaddress;
    @FXML
    private TextField textFieldPortNumber;
    @FXML
    private Button buttonLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        buttonLogin.setOnAction((ActionEvent event) -> {
            showCliend();
        });
    }
    private Stage stage;

    public void showCliend() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("client.fxml"));
            Parent root = loader.load();
            ((ClientController) loader.getController())
                    .setServerInfo(new UserInfo(textFieldUsername.getText(),
                            textFieldIpaddress.getText(),
                            textFieldPortNumber.getText()));

            stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);

            IconsSFX.setStageIcon(stage);
            stage.show();
        } catch (IOException ex) {

        }
    }
}
