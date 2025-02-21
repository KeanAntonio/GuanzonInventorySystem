package com.javafx.guanzoninventorysystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML and set up the scene
        scene = new Scene(loadFXML("/com/gis/fxml/welcome"));
        
        
        // Set up the stage (window)
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.setTitle("Guanzon Inventory Management");
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
