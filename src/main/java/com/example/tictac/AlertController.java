package com.example.tictac;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class AlertController implements Initializable {

    @FXML
    private Label winLabel;

    @FXML
    private Label playerLabel;

    @FXML
    private Button nextGameButton;

    @FXML
    private Button newGameButton;

    private Stage getStage(){
        return (Stage) newGameButton.getScene().getWindow();
    }

    @FXML
    void handleNewGame(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("startWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Game.getTicTacToeController().getStage().close();
        getStage().close();
    }

    @FXML
    void handleNextGame(ActionEvent event) {
        Game.initBoard();
        getStage().close();
    }

    public void setPlayerLabel(String playerLabelText) {
        playerLabel.setText(playerLabelText);
    }

    private void setLanguage(String language) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(language, Locale.getDefault());
//        winLabel.setText(resourceBundle.getString("winLabelText"));
        nextGameButton.setText(resourceBundle.getString("nextGameButtonText"));
        newGameButton.setText(resourceBundle.getString("newGameButtonText"));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if(GlobalVar.getLanguageToggleButton().isSelected()) {
            setLanguage("en");
        } else {
            setLanguage("pl");
        }
    }
}
