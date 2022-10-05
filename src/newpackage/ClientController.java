package newpackage;

import com.krd.notificationSong.SongEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author kurd
 */
public class ClientController implements Initializable {

    @FXML
    private AnchorPane ap_main;
    @FXML
    private TextField tf_messsage;
    @FXML
    private Button buttone_send;
    @FXML
    private ScrollPane sp_main;
    @FXML
    private VBox vbox_message;
    Client client;
    @FXML
    private Label lableUsername;

    UserInfo userInfo;

    public void setServerInfo(UserInfo obj) {
        this.userInfo = obj;
        lableUsername.setText(obj.getUsername());
        System.out.println(obj);

        try {
            client = new Client(new Socket(userInfo.getIpAddress(),
                    Integer.parseInt(userInfo.getPortNumber())));

            //       client = new Client(new Socket("127.0.0.1",1234));
            // TODO
        } catch (IOException ex) {
            System.out.println(ex);
        }

        vbox_message.heightProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            sp_main.setVvalue((Double) newValue);
        });
        client.receiveMessageFromServer(vbox_message);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        buttone_send.setOnAction((ActionEvent event) -> {
            SongEvent.getInstance().onClickOne();
            sendMessage();
        });
        tf_messsage.setOnKeyTyped((KeyEvent event) -> {
            SongEvent.getInstance().onKeyType();
        });
        tf_messsage.setOnKeyReleased(
                (KeyEvent event) -> {
                    if (event.getCode() == KeyCode.ENTER) {
                        sendMessage();
                    }
                }
        );

    }

    void sendMessage() {
        String messeageToSend = tf_messsage.getText();
        if (!messeageToSend.isEmpty()) {
            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER_RIGHT);
            hBox.setPadding(new Insets(5, 5, 5, 10));
            Text text = new Text(messeageToSend);

            TextFlow textFlow = new TextFlow(text);
            textFlow.setStyle("-fx-color:rgb(239,242,255);"
                    + "-fx-background-color:rgb(0,150,136);"
                    + "-fx-background-radius:20px;");

            textFlow.setPadding(new Insets(5, 10, 5, 10));
            text.setFill(Color.rgb(0, 0, 0));

            hBox.getChildren().add(textFlow);
            vbox_message.getChildren().add(hBox);

            client.sendMessageToServer(messeageToSend);
            tf_messsage.clear();
        }
    }

    public static void addLable(String messageFromServer, VBox vbox) {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setPadding(new Insets(5, 5, 5, 10));
        Text text = new Text(messageFromServer);

        TextFlow textFlow = new TextFlow(text);
        textFlow.setStyle("-fx-background-color:rgb(233,233,233);"
                + "-fx-background-radius:20px;");
        textFlow.setPadding(new Insets(5, 10, 5, 10));
        hBox.getChildren().add(textFlow);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vbox.getChildren().add(hBox);
            }
        });
    }

}
