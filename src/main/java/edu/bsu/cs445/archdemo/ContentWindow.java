package edu.bsu.cs445.archdemo;

import com.google.common.base.Preconditions;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class ContentWindow extends VBox {

    @FXML
    @SuppressWarnings("unused") // Used in FXML binding
    private Button newWindow;


    ContentWindow() {

    }

    @SuppressWarnings("unused") // Used in FXML binding
    @FXML
    void contentWindow(){
        System.out.println("Running");
    }

}
