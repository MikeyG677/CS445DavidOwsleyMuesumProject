package edu.bsu.cs445.historicmachine;

import com.google.common.base.Preconditions;
import edu.bsu.cs445.historicmachine.model.ContentConverter;
import edu.bsu.cs445.historicmachine.model.DomaArtifactRecordCollection;
import edu.bsu.cs445.historicmachine.model.JaxbArtifactRecordCollection;
import edu.bsu.cs445.historicmachine.model.JaxbParser;
import edu.bsu.cs445.historicmachine.view.SearchPane;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.CompletableFuture;

public class Main extends Application {

    private JaxbArtifactRecordCollection jaxbCollection;

    @Override
    public void start(Stage primaryStage) {
        createInitialScene(primaryStage);
        JaxbParser parser = JaxbParser.create();
        InputStream owsleyStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("owsley.xml");
        CompletableFuture.runAsync(() -> jaxbCollection = parser.parse(owsleyStream))
                .thenRun(() -> Platform.runLater(() -> {
                            ContentConverter artifactRecordConverter = new ContentConverter(jaxbCollection);
                            DomaArtifactRecordCollection convertedCollection = artifactRecordConverter.createDomaCollection();
                            SearchPane searchPane = new SearchPane(convertedCollection);
                            Scene searchPaneScene = new Scene(searchPane);
                            primaryStage.setScene(searchPaneScene);
                        }
                ));
    }

    private void createInitialScene(Stage stage) {
        Parent root;
        try {
            URL url = getClass().getClassLoader().getResource("edu/bsu/cs445/historicmachine/loading.fxml");
            Preconditions.checkNotNull(url, "Cannot load fxml resource");
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        stage.setTitle("David Owsley Museum of Art Historic Machine");
        stage.setScene(scene);
        stage.setMinWidth(300);
        stage.setMinHeight(400);
        stage.show();
    }

}