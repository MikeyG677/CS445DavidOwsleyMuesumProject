package edu.bsu.cs445.archdemo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class ContentWindow extends VBox {

    @FXML
    @SuppressWarnings("unused") // Used in FXML binding
    private Button newWindow;

    @SuppressWarnings("unused") // This method is used by searchPane.fxml.
    @FXML
    public void newWindow(){
    }

}
