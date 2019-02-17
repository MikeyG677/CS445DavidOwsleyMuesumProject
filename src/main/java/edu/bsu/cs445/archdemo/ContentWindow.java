package edu.bsu.cs445.archdemo;

import com.google.common.base.Preconditions;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class ContentWindow extends VBox {

    @FXML
    @SuppressWarnings("unused") // Used in FXML binding
    private Button newWindow;

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

    ContentWindow(ArtifactRecord record) {
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

}
