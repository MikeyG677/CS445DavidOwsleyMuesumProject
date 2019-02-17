package edu.bsu.cs445.archdemo;

import com.google.common.base.Preconditions;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

class ArtifactView extends VBox {

    @SuppressWarnings("unused") // Used in FXML binding
    @FXML
    private TitledPane tiltedPaneView;

    @SuppressWarnings("unused") // Used in FXML binding
    @FXML
    private ImageView imageView;

    @SuppressWarnings("unused") // Used in FXML binding
    @FXML
    private Label titleView;

    @SuppressWarnings("unused") // Used in FXML binding
    @FXML
    private Label artistView;

    @SuppressWarnings("unused") // Used in FXML binding
    @FXML
    private Label subjectView;

    @SuppressWarnings("unused") // Used in FXML binding
    @FXML
    private Label dateView;

    @SuppressWarnings("unused") // Used in FXML binding
    @FXML
    private Button newWindow;

    ArtifactView(ArtifactRecord record) {
        Preconditions.checkNotNull(record);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("artifactView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();

            Image image = new Image("http://cspvggp.dhcp.bsu.edu/OMI/" + record.getFileName());
            imageView.setImage(image);
            titleView.setText("Title: " + record.getTitle());
            artistView.setText("Artist: " + record.getArtist());
            subjectView.setText("Subject: " + record.getSubject_LCSH());
            dateView.setText("Date:  " + record.getDate_Made());
            newWindow.setText("More Information");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unused") // This method is used by searchPane.fxml.
    @FXML
    private void newWindow() {
        Parent root;
        try {
            URL url = getClass().getResource("contentWindow.fxml");
            Preconditions.checkNotNull(url, "Cannot load fxml resource");
            root = FXMLLoader.load(url);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Slightly Less Naive DOMA Search");
        stage.setScene(scene);
        stage.show();
    }
}
