package edu.bsu.cs445.archdemo.view;

import com.google.common.base.Preconditions;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class SceneController {

    public void changeScene(Stage stage){
        Parent root;
        try {
            URL url = getClass().getClassLoader().getResource("edu/bsu/cs445/archdemo/artifactView.fxml");
            Preconditions.checkNotNull(url, "Cannot load fxml resource");
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene ArtifactViewScene = new Scene(root);
        stage.setScene(ArtifactViewScene);

    }

}
