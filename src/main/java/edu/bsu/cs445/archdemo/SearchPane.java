package edu.bsu.cs445.archdemo;
import com.google.common.base.Preconditions;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
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
    private HBox searchHBox;
    @FXML
    @SuppressWarnings("unused") // Used in FXML binding
    private VBox resultBox;
    @FXML
    @SuppressWarnings("unused") // Used in FXML binding
    private CheckBox JapanSearchToggle;
    @FXML
    @SuppressWarnings("unused") // Used in FXML binding
    private CheckBox AmericaSearchToggle;
    @FXML
    @SuppressWarnings("unused") // Used in FXML binding
    private CheckBox NatureSearchToggle;
    @FXML
    @SuppressWarnings("unused") // Used in FXML binding
    private CheckBox AbstractSearchToggle;
    @FXML
    @SuppressWarnings("unused") // Used in FXML binding
    private CheckBox isExactWordTitle;
    @FXML
    @SuppressWarnings("unused") // Used in FXML binding
    private CheckBox isExactWordSubject;

    private final ArtifactRecordCollection collection;

    SearchPane(ArtifactRecordCollection collection) {
        this.collection = Preconditions.checkNotNull(collection);
        URL fxmlUrl = getClass().getResource("searchPane.fxml");
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
    private void initSearch() { // Preconditions all search methods.
        Preconditions.checkNotNull(collection, "The collection should already be in memory");
        searchHBox.setDisable(true);
    }

    @SuppressWarnings("unused") // This method is used by searchPane.fxml.
    @FXML
    public void searchBySubject() {
        initSearch();
        List<ArtifactRecord> records = new ArrayList<>();
        HashSet<String> subjectList = new HashSet<>();
        String searchTerm = searchFieldSubject.getText();

        if (!searchTerm.isEmpty()) { subjectList.add(searchTerm); }
        if (JapanSearchToggle.isSelected()) { subjectList.add("Japan"); }
        if (AmericaSearchToggle.isSelected()) { subjectList.add("America"); }
        if (AbstractSearchToggle.isSelected()) { subjectList.add("Abstract"); }
        if (NatureSearchToggle.isSelected()) { subjectList.add("Nature"); }
        if(!subjectList.isEmpty()){
            records = collection.searchThroughSubjects(subjectList, isExactWordSubject.isSelected());
        }
        returnResults(records);
        searchFieldTitle.setText("");
    }

    @SuppressWarnings("unused") // This method is used by searchPane.fxml.
    @FXML
    public void searchByTitle() {
        initSearch();
        List<ArtifactRecord> records = new ArrayList<>();
        String searchTerm = searchFieldTitle.getText();

        if(!searchTerm.isEmpty()) {
            records = collection.searchThroughTitles(searchTerm, isExactWordTitle.isSelected());
        }
        returnResults(records);
        searchFieldSubject.setText("");
        JapanSearchToggle.setSelected(false);
    }

    @SuppressWarnings("unused") // This method is used by searchPane.fxml.
    @FXML
    private void returnResults(List<ArtifactRecord> records) {
        resultBox.getChildren().clear();
        if (records.size() > 0) {
            for (ArtifactRecord record : records) {
                resultBox.getChildren().add(new ArtifactView(record));
            }
        }
        resultCount.setText(String.valueOf(records.size()));
        searchHBox.setDisable(false);
    }
}
