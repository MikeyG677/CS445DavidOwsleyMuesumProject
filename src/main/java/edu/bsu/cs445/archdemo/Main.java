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

    private JaxbArtifactRecordCollection collection;

    @Override
    public void start(Stage primaryStage) {
        CreateInitialScene createScene = new CreateInitialScene();
        createScene.createInitialScene(primaryStage);
        JaxbParser parser = JaxbParser.create();
        InputStream owsleyStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("owsley.xml");
        CompletableFuture.runAsync(() -> collection = parser.parse(owsleyStream))
                .thenRun(() -> Platform.runLater(() -> {
                            SearchPane searchPane = new SearchPane(collection);
                            Scene searchPaneScene = new Scene(searchPane);
                            primaryStage.setScene(searchPaneScene);
                        }
                ));
    }

}
