package com.example.tictac;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class TicTacToeController {

    @FXML
    private ToggleButton toggleButton1;

    @FXML
    private ToggleButton toggleButton2;

    @FXML
    private ToggleButton toggleButton3;

    @FXML
    private ToggleButton toggleButton4;

    @FXML
    private ToggleButton toggleButton5;

    @FXML
    private ToggleButton toggleButton6;

    @FXML
    private ToggleButton toggleButton7;

    @FXML
    private ToggleButton toggleButton8;

    @FXML
    private ToggleButton toggleButton9;

    @FXML
    private Label playerLabel;

    @FXML
    private VBox ticTacToeVbox;
    @FXML
    private Label welcomeText;

    private void checkResult() {
        for (int row = 0; row < 3; row++) {
            if (checkRow(row, "X")) {
                System.out.println("Wygrana X");
                return;
            } else if (checkRow(row, "O")) {
                System.out.println("Wygrana O");
                return;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (checkColumn(col, "X")) {
                System.out.println("Wygrana X");
                return;
            } else if (checkColumn(col, "O")) {
                System.out.println("Wygrana O");
                return;
            }
        }

        if (checkDiagonal("X")) {
            System.out.println("Wygrana X");
        } else if (checkDiagonal("O")) {
            System.out.println("Wygrana O");
        }
    }

    private boolean checkRow(int row, String player) {
        return toggleButton(row, 0).getId().equals(player) &&
                toggleButton(row, 1).getId().equals(player) &&
                toggleButton(row, 2).getId().equals(player);
    }

    private boolean checkColumn(int col, String player) {
        return toggleButton(0, col).getId().equals(player) &&
                toggleButton(1, col).getId().equals(player) &&
                toggleButton(2, col).getId().equals(player);
    }

    private boolean checkDiagonal(String player) {
        return toggleButton(0, 0).getId().equals(player) &&
                toggleButton(1, 1).getId().equals(player) &&
                toggleButton(2, 2).getId().equals(player) ||
                toggleButton(0, 2).getId().equals(player) &&
                        toggleButton(1, 1).getId().equals(player) &&
                        toggleButton(2, 0).getId().equals(player);
    }

    private ToggleButton toggleButton(int row, int col) {
        switch (row * 3 + col) {
            case 0: return toggleButton1;
            case 1: return toggleButton2;
            case 2: return toggleButton3;
            case 3: return toggleButton4;
            case 4: return toggleButton5;
            case 5: return toggleButton6;
            case 6: return toggleButton7;
            case 7: return toggleButton8;
            case 8: return toggleButton9;
            default: throw new IllegalArgumentException("Nieprawidłowe indeksy row i col");
        }
    }
    private boolean player = true;
    @FXML
    void handleSelected(ActionEvent event) {
        ToggleButton toggleButton = (ToggleButton) event.getSource();
        System.out.println(toggleButton.getId());
        System.out.println("klik");
        ImageView imageView = new ImageView();

        if (player) {
            imageView.setImage(new Image(getClass().getResource("/img/circle1.png").toString()));
            player = false;
            playerLabel.setText("X");
            toggleButton.setId("O");
            checkResult();
        } else {
            imageView.setImage(new Image(getClass().getResource("/img/cross1.png").toString()));
            player = true;
            playerLabel.setText("O");
            toggleButton.setId("X");
            checkResult();
        }

        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        toggleButton.setGraphic(imageView);

        toggleButton.setDisable(true);
    }

}