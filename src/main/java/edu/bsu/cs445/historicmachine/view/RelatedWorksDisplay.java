package edu.bsu.cs445.historicmachine.view;

import com.google.common.base.Preconditions;
import edu.bsu.cs445.historicmachine.model.DomaArtifactRecord;
import edu.bsu.cs445.historicmachine.model.SearchEngine;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import java.awt.*;
import java.io.IOException;
import java.util.List;


public class RelatedWorksDisplay extends HBox {

    @SuppressWarnings("unused")
    @FXML
    private ImageView relatedWorksImage;

    @SuppressWarnings("unused")
    @FXML
    private Label relatedWorksTitle;

    RelatedWorks(List<DomaArtifactRecord> record) {
        Preconditions.checkNotNull(record);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("edu/bsu/cs445/historicmachine/relatedWorks.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();

            this.records = record;
            javafx.scene.image.Image image = new Image("http://cspvggp.dhcp.bsu.edu/OMI/" + record.getFileName());
            relatedWorksImage.setImage(image);
            relatedWorksTitle.setText("Title: ");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
