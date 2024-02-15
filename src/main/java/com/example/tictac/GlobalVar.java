package com.example.tictac;

import javafx.scene.control.ToggleButton;

public class GlobalVar {
    public static ToggleButton getLanguageToggleButton() {
        return languageToggleButton;
    }

    public static void setLanguageToggleButton(ToggleButton languageToggleButton) {
        GlobalVar.languageToggleButton = languageToggleButton;
    }

    private static ToggleButton languageToggleButton;


}
