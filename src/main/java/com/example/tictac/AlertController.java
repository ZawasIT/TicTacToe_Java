package com.example.tictac;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AlertController {

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
    void handleNewGame(ActionEvent event) {

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

}
