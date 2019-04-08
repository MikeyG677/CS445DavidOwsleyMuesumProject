package edu.bsu.cs445.archdemo;
import com.google.common.base.Preconditions;
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
    private DomaArtifactRecordCollection domaCollection;

    @Override
    public void start(Stage primaryStage) {
        DomaArtifactRecordCollection domaCollection = new DomaArtifactRecordCollection();
        CreateInitialScene createScene = new CreateInitialScene();
        createScene.createInitialScene(primaryStage);
        JaxbParser parser = JaxbParser.create();
        InputStream owsleyStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("owsley.xml");
        CompletableFuture.runAsync(() -> jaxbCollection = parser.parse(owsleyStream))
                .thenRun(() -> Platform.runLater(() -> {
                            System.out.println(jaxbCollection.size());
                            DomaArtifactRecordCollection convertedCollection = domaCollection.convertJaxbToDoma(jaxbCollection);
                            System.out.println(convertedCollection.records.toString());
                            SearchPane searchPane = new SearchPane(convertedCollection);
                            Scene searchPaneScene = new Scene(searchPane);
                            primaryStage.setScene(searchPaneScene);

                        }
                ));
    }

}