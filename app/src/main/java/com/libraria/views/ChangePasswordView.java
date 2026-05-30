package com.libraria.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ChangePasswordView {

    private PasswordField passwordField;
    private TextField passwordVisible;
    private Button togglePassword;
    private PasswordField confirmPasswordField;
    private TextField confirmPasswordVisible;
    private Button toggleConfirmPassword;
    private Button submitButton;
    private Label errorLabel;
    private Label successLabel;
    private VBox root;
    private boolean isPasswordVisible = false;
    private boolean isConfirmPasswordVisible = false;

    private String buttonStyle =
            "-fx-background-color: #1a3fa0;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 16px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 30;" +
            "-fx-pref-width: 420px;" +
            "-fx-pref-height: 55px;" +
            "-fx-cursor: hand;";

    private String buttonHoverStyle =
            "-fx-background-color: #15328a;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 16px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 30;" +
            "-fx-pref-width: 420px;" +
            "-fx-pref-height: 55px;" +
            "-fx-cursor: hand;";

    private String fieldStyle =
            "-fx-background-color: #f0f0f0;" +
            "-fx-background-radius: 24;" +
            "-fx-border-color: transparent;" +
            "-fx-pref-height: 52px;" +
            "-fx-pref-width: 420px;" +
            "-fx-font-size: 14px;" +
            "-fx-padding: 0 40 0 16;";

    public ChangePasswordView() {
        buildView();
    }

    private void buildView() {

        Label titleLabel = new Label("New Password");
        titleLabel.setStyle(
            "-fx-font-size: 32px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #000000;"
        );

        Label subtitleLabel = new Label("Create a new password for your account.");
        subtitleLabel.setStyle("-fx-font-size: 13px; -fx-text-fill: #555555;");

        passwordField = new PasswordField();
        passwordField.setPromptText("New Password");
        passwordField.setStyle(fieldStyle);

        passwordVisible = new TextField();
        passwordVisible.setPromptText("New Password");
        passwordVisible.setStyle(fieldStyle);
        passwordVisible.setVisible(false);
        passwordVisible.setManaged(false);

        togglePassword = new Button("👁");
        togglePassword.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-cursor: hand;" +
            "-fx-font-size: 14px;"
        );
        togglePassword.setOnAction(e -> {
            isPasswordVisible = !isPasswordVisible;
            if (isPasswordVisible) {
                passwordVisible.setText(passwordField.getText());
                passwordVisible.setVisible(true);
                passwordVisible.setManaged(true);
                passwordField.setVisible(false);
                passwordField.setManaged(false);
                togglePassword.setText("︶");
            } else {
                passwordField.setText(passwordVisible.getText());
                passwordField.setVisible(true);
                passwordField.setManaged(true);
                passwordVisible.setVisible(false);
                passwordVisible.setManaged(false);
                togglePassword.setText("👁");
            }
        });

        StackPane passwordPane = new StackPane();
        StackPane.setAlignment(togglePassword, Pos.CENTER_RIGHT);
        togglePassword.setTranslateX(-10);
        passwordPane.getChildren().addAll(passwordField, passwordVisible, togglePassword);

        confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm New Password");
        confirmPasswordField.setStyle(fieldStyle);

        confirmPasswordVisible = new TextField();
        confirmPasswordVisible.setPromptText("Confirm New Password");
        confirmPasswordVisible.setStyle(fieldStyle);
        confirmPasswordVisible.setVisible(false);
        confirmPasswordVisible.setManaged(false);

        toggleConfirmPassword = new Button("👁");
        toggleConfirmPassword.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-cursor: hand;" +
            "-fx-font-size: 14px;"
        );
        toggleConfirmPassword.setOnAction(e -> {
            isConfirmPasswordVisible = !isConfirmPasswordVisible;
            if (isConfirmPasswordVisible) {
                confirmPasswordVisible.setText(confirmPasswordField.getText());
                confirmPasswordVisible.setVisible(true);
                confirmPasswordVisible.setManaged(true);
                confirmPasswordField.setVisible(false);
                confirmPasswordField.setManaged(false);
                toggleConfirmPassword.setText("︶");
            } else {
                confirmPasswordField.setText(confirmPasswordVisible.getText());
                confirmPasswordField.setVisible(true);
                confirmPasswordField.setManaged(true);
                confirmPasswordVisible.setVisible(false);
                confirmPasswordVisible.setManaged(false);
                toggleConfirmPassword.setText("👁");
            }
        });

        StackPane confirmPasswordPane = new StackPane();
        StackPane.setAlignment(toggleConfirmPassword, Pos.CENTER_RIGHT);
        toggleConfirmPassword.setTranslateX(-10);
        confirmPasswordPane.getChildren().addAll(confirmPasswordField, confirmPasswordVisible, toggleConfirmPassword);

        errorLabel = new Label("");
        errorLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #cc0000;");

        successLabel = new Label("");
        successLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #00cc00;");
        successLabel.setVisible(false);
        successLabel.setManaged(false);

        submitButton = new Button("Change Password");
        submitButton.setStyle(buttonStyle);
        submitButton.setOnMouseEntered(e -> submitButton.setStyle(buttonHoverStyle));
        submitButton.setOnMouseExited(e -> submitButton.setStyle(buttonStyle));

        VBox card = new VBox(15);
        card.setAlignment(Pos.CENTER);
        card.setMaxWidth(500);
        card.getChildren().addAll(
            titleLabel,
            subtitleLabel,
            passwordPane,
            confirmPasswordPane,
            errorLabel,
            successLabel,
            submitButton
        );

        root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));
        root.setStyle("-fx-background-color: white;");
        root.getChildren().add(card);
    }

    public String getPasswordText() {
        if (isPasswordVisible) {
            return passwordVisible.getText();
        } else {
            return passwordField.getText();
        }
    }

    public String getConfirmPasswordText() {
        if (isConfirmPasswordVisible) {
            return confirmPasswordVisible.getText();
        } else {
            return confirmPasswordField.getText();
        }
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public TextField getPasswordVisible() {
        return passwordVisible;
    }

    public PasswordField getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public TextField getConfirmPasswordVisible() {
        return confirmPasswordVisible;
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

    public Label getSuccessLabel() {
        return successLabel;
    }

    public VBox getRoot() {
        return root;
    }   
}