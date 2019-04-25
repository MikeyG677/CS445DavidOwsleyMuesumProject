package edu.bsu.cs445.historicmachine.view;

import com.google.common.base.Preconditions;
import edu.bsu.cs445.historicmachine.model.DomaArtifactRecord;
import edu.bsu.cs445.historicmachine.model.JaxbArtifactRecord;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.IOException;

class ArtifactView extends VBox {

    private final DomaArtifactRecord record;

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
    private TitledPane searchResultPane;
    @SuppressWarnings("unused") // Used in FXML binding
    @FXML
    private Label cultureView;
    @SuppressWarnings("unused") // Used in FXML binding
    @FXML
    private Label centuryView;
    @SuppressWarnings("unused") // Used in FXML binding
    @FXML
    private Label periodStyleView;

    SearchPane parent;

    ArtifactView(DomaArtifactRecord record) {
        Preconditions.checkNotNull(record);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("edu/bsu/cs445/historicmachine/artifactView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();

            this.record = record;
            Image image = new Image("http://cspvggp.dhcp.bsu.edu/OMI/" + record.getFileName());
            imageView.setImage(image);
            titleView.setText("Title: " + record.getTitle());
            artistView.setText("Artist: " + record.getArtist());
            subjectView.setText("Subject: " + record.getSubject_LCSH());
            dateView.setText("Date:  " + record.getDate_Made());
            cultureView.setText("Culture: " + record.getCulture());
            centuryView.setText("Century: " + record.getCentury());
            periodStyleView.setText("Period Style: " + record.getPeriodStyle());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unused") // This method is used by artifactView.fxml.
    @FXML
    void searchRelatedWorks(){
        parent.searchRelatedWorks(this.record);
    }
}
