package edu.bsu.cs445.archdemo;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

public class Main extends Application {

    private JaxbArtifactRecordCollection jaxbCollection;

    @Override
    public void start(Stage primaryStage) {
        DomaArtifactRecordCollection domaCollection = new DomaArtifactRecordCollection();
        CreateInitialScene createScene = new CreateInitialScene();
        createScene.createInitialScene(primaryStage);
        JaxbParser parser = JaxbParser.create();
        InputStream owsleyStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("owsley.xml");
        CompletableFuture.runAsync(() -> jaxbCollection = parser.parse(owsleyStream))
                .thenRun(() -> Platform.runLater(() -> {
                            DomaArtifactRecordCollection convertedCollection = domaCollection.convertJaxbToDoma(jaxbCollection);
                            SearchPane searchPane = new SearchPane(convertedCollection);
                            Scene searchPaneScene = new Scene(searchPane);
                            primaryStage.setScene(searchPaneScene);

                        }
                ));
    }

}