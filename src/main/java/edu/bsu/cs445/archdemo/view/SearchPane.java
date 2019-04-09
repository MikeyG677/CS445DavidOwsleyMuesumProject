package edu.bsu.cs445.archdemo.view;

import com.google.common.base.Preconditions;
import edu.bsu.cs445.archdemo.model.ArtifactRecord;
import edu.bsu.cs445.archdemo.model.DomaArtifactRecordCollection;
import edu.bsu.cs445.archdemo.model.SearchEngine;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SearchPane extends VBox {

    @FXML
    @SuppressWarnings("unused") // Used in FXML binding
    private TextField searchFieldTitle;
    @FXML
    @SuppressWarnings("unused") // Used in FXML binding
    private TextField searchFieldSubject;
    @FXML
    @SuppressWarnings("unused") // Used in FXML binding
    private Button searchButtonTitle;
    @FXML
    @SuppressWarnings("unused") // Used in FXML binding
    private Button searchButtonSubject;
    @FXML
    @SuppressWarnings("unused") // Used in FXML binding
    private Label resultCount;
    @FXML
    @SuppressWarnings("unused") // Used in FXML binding
    private SplitPane searchPanes;
    @FXML
    @SuppressWarnings("unused") // Used in FXML binding
    private VBox resultBox;
    @FXML
    @SuppressWarnings("unused") // Used in FXML binding
    private CheckBox isExactWordTitle;
    @FXML
    @SuppressWarnings("unused") // Used in FXML binding
    private CheckBox isExactWordSubject;
    @FXML
    @SuppressWarnings("unused") // Used in FXML binding
    private VBox subjectPresets;

    //private final JaxbArtifactRecordCollection collection;
    private final DomaArtifactRecordCollection collection;
    private final SearchEngine search;

    public SearchPane(DomaArtifactRecordCollection collection) {
        this.collection = Preconditions.checkNotNull(collection);
        this.search = new SearchEngine(collection);


        URL fxmlUrl = getClass().getClassLoader().getResource("edu/bsu/cs445/archdemo/searchPane.fxml");
        Preconditions.checkNotNull(fxmlUrl, "Fxml asset location is not specified correctly.");
        FXMLLoader loader = new FXMLLoader(fxmlUrl);
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @SuppressWarnings("unused") // This method is used by searchPane.fxml.
    @FXML
    private void initializeSearch() { // Precondition for all search methods.
        Preconditions.checkNotNull(collection, "The collection should already be in memory");
        searchPanes.setDisable(true);
    }

    @SuppressWarnings("unused") // This method is used by searchPane.fxml.
    @FXML
    public void searchByTitle() {
        initializeSearch();
        List<ArtifactRecord> records = new ArrayList<>();
        String searchTerm = searchFieldTitle.getText();


        if(!searchTerm.isEmpty() && searchTerm.length()>1) {
            if(isExactWordTitle.isSelected()){
                records = search.searchTitle_WholeWord(searchTerm);
            }
            else{
                records = search.searchTitle_Contains(searchTerm);
            }
        }

        if(searchTerm.length()<=1 || records.size()==0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Search Error");
            alert.setHeaderText("Invalid Search Query");
            if(searchTerm.length()<=1) {
                alert.setContentText("Please enter a search query longer than one character.");
            }
            else if(records.size()<1){
                alert.setContentText("No results available for " + "'" + searchTerm + "'" + ". Please enter a different query.");
            }
            alert.showAndWait();
        }
        returnResults(records);
    }

    @SuppressWarnings("unused") // This method is used by artifactView.fxml.
    @FXML
    void searchRelatedWorks(ArtifactRecord record){
        initializeSearch();
        returnResults(search.searchRelatedWorks(record));
    }

    @SuppressWarnings("unused") // This method is used by searchPane.fxml.
    @FXML
    private void returnResults(List<ArtifactRecord> records) {
        resultBox.getChildren().clear();
        if (records.size() > 0) {
            for (ArtifactRecord record : records) {
                ArtifactView newArtifactView = new ArtifactView(record);
                newArtifactView.parent = this;
                resultBox.getChildren().add(newArtifactView);
            }
        }
        resultCount.setText(String.valueOf(records.size()));
        searchPanes.setDisable(false);

    }
}
