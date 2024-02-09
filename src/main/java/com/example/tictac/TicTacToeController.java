package com.example.tictac;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class TicTacToeController implements Initializable {

    @FXML
    public ToggleButton toggleButton1;

    @FXML
    public ToggleButton toggleButton2;

    @FXML
    public ToggleButton toggleButton3;

    @FXML
    public ToggleButton toggleButton4;

    @FXML
    public ToggleButton toggleButton5;

    @FXML
    public ToggleButton toggleButton6;

    @FXML
    public ToggleButton toggleButton7;

    @FXML
    public ToggleButton toggleButton8;

    @FXML
    public ToggleButton toggleButton9;

    @FXML
    private Label playerLabel;

    @FXML
    private VBox ticTacToeVbox;
    @FXML
    private Label welcomeText;


    @FXML
    void handleSelected(ActionEvent event) throws IOException {
        ToggleButton toggleButton = (ToggleButton) event.getSource();
        System.out.println(toggleButton.getId());
        System.out.println("klik");
        ImageView imageView = new ImageView();

        if (Game.player) {
            imageView.setImage(new Image(String.valueOf(getClass().getResource("/img/circle.png"))));
            Game.player = false;
            playerLabel.setText(Game.getPlayerX().getName() + ", make your move!");
            toggleButton.setId("O");
            toggleButton.setOnAction(null);
            Game.checkResult();
        } else {
            imageView.setImage(new Image(String.valueOf(getClass().getResource("/img/cross.png"))));
            Game.player = true;
            playerLabel.setText(Game.getPlayerO().getName() + ", its your turn!");
            toggleButton.setId("X");
            toggleButton.setOnAction(null);
            Game.checkResult();
        }
        toggleButton.setGraphic(imageView);

        if(Game.checkResult() == 0 || Game.checkResult() == 1) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("alert.fxml"));
            VBox alertBox = fxmlLoader.load();

            AlertController alertController = fxmlLoader.getController();
            alertController.setPlayerLabel((Game.checkResult() == 0) ? "Wygrywa "+Game.getPlayerX().getName() :
                    "Wygrywa "+Game.getPlayerO().getName());

            Stage alertStage = new Stage();
            alertStage.setScene(new Scene(alertBox));
            alertStage.initModality(Modality.WINDOW_MODAL);

            alertStage.initOwner(this.ticTacToeVbox.getScene().getWindow());

            alertStage.showAndWait();
        }


        if(Game.checkDraw()) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("alert.fxml"));
            VBox alertBox = fxmlLoader.load(); // Wczytaj VBox z pliku FXML

            // Pobierz kontroler z FXMLLoadera, aby przekazać wynik
            AlertController alertController = fxmlLoader.getController();
            alertController.setPlayerLabel("Remis!!!");

            Stage alertStage = new Stage();
            alertStage.setScene(new Scene(alertBox));
            alertStage.initModality(Modality.WINDOW_MODAL);
            alertStage.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Game.setTicTacToeController(this);
    }
}