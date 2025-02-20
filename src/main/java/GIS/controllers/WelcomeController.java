package GIS.controllers;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class WelcomeController {

    @FXML
    private ImageView ImageView; // This matches the fx:id="ImageView" in FXML

    public void initialize() {
        // Fade transition for the image
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), ImageView);
        fadeTransition.setFromValue(0); // Start fully transparent
        fadeTransition.setToValue(1);   // End fully visible
        fadeTransition.setCycleCount(1); // Run once
        fadeTransition.setAutoReverse(false); // No auto reverse
        fadeTransition.play(); // Start the transition
    }
}
