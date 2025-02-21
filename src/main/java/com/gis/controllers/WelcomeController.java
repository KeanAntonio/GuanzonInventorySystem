package com.gis.controllers;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import com.gis.database.DatabaseController;

public class WelcomeController {

    @FXML
    private ImageView ImageView; // This matches the fx:id="ImageView" in FXML
    @FXML
    private TextField txtUsername;  // Reference to the username field
    @FXML
    private PasswordField txtPassword;  // Reference to the password field
    @FXML
    private Button btnLogin;  // Reference to the login button
    @FXML
    private Hyperlink forgotPasswordLink;

    public void initialize() {
        // Fade transition for the image
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(5), ImageView);
        fadeTransition.setFromValue(0); // Start fully transparent
        fadeTransition.setToValue(1);   // End fully visible
        fadeTransition.setCycleCount(1); // Run once
        fadeTransition.setAutoReverse(false); // No auto reverse
        fadeTransition.play(); // Start the transition
    }

    // Event handler for the login button
    @FXML
    private void handleLoginButtonAction() {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        // Example validation logic
        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Please enter both username and password.");
        } else {
            // Validate against the database
            boolean isValid = DatabaseController.validateUser(username, password);
            if (isValid) {
                showAlert("Success", "Login successful!");
                // Proceed with further logic (e.g., navigate to another screen)
            } else {
                showAlert("Error", "Invalid username or password.");
            }
        }
    }

    // Helper method to display an alert
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
