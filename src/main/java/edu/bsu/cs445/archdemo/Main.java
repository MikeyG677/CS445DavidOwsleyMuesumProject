package edu.bsu.cs445.archdemo;

import com.google.common.base.Preconditions;
import edu.bsu.cs445.archdemo.model.DomaArtifactRecordCollection;
import edu.bsu.cs445.archdemo.model.JaxbArtifactRecordCollection;
import edu.bsu.cs445.archdemo.model.JaxbParser;
import edu.bsu.cs445.archdemo.view.SceneController;
import edu.bsu.cs445.archdemo.view.SearchPane;
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


        DomaArtifactRecordCollection domaCollection = new DomaArtifactRecordCollection();
        createInitialScene(primaryStage);
        JaxbParser parser = JaxbParser.create();
        InputStream owsleyStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("owsley.xml");
        CompletableFuture.runAsync(() -> jaxbCollection = parser.parse(owsleyStream))
                .thenRun(() -> Platform.runLater(() -> {
                            DomaArtifactRecordCollection convertedCollection = domaCollection.convertCollectionToDoma(jaxbCollection);
                            SearchPane searchPane = new SearchPane(convertedCollection, primaryStage);
                            Scene searchPaneScene = new Scene(searchPane);

                            primaryStage.setScene(searchPaneScene);

                        }
                ));
    }

    private void createInitialScene(Stage stage) {
        Parent root;
        try {
            URL url = getClass().getClassLoader().getResource("edu/bsu/cs445/archdemo/loading.fxml");
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