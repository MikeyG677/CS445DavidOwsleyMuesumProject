package edu.bsu.cs445.archdemo;

import com.google.common.base.Preconditions;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class CreateInitialScene {

    public void createInitialScene(Stage stage) {
        Parent root;
        try {
            URL url = getClass().getResource("loading.fxml");
            Preconditions.checkNotNull(url, "Cannot load fxml resource");
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        stage.setTitle("DOMA: Historic Machine");
        stage.setScene(scene);
        stage.setMinWidth(300);
        stage.setMinHeight(400);
        stage.show();
    }
}
