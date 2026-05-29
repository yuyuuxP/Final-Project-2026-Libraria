package com.libraria.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class LoginView {

    private TextField emailField;
    private PasswordField passwordField;
    private TextField passwordVisible;
    private Button togglePassword;
    private Button loginButton;
    private Hyperlink createAccountLink;
    private Hyperlink forgotPasswordLink;
    private Label errorLabel;
    private VBox root;
    private boolean isPasswordVisible = false;

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

    public LoginView() {
        buildView();
    }

    private void buildView() {

        Label titleLabel = new Label("Sign in");
        titleLabel.setStyle(
            "-fx-font-size: 32px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #000000;"
        );

        Label subtitleLabel = new Label("New user? ");
        subtitleLabel.setStyle("-fx-font-size: 13px; -fx-text-fill: #555555;");

        createAccountLink = new Hyperlink("Create an account");
        createAccountLink.setStyle(
            "-fx-font-size: 13px;" +
            "-fx-text-fill: #1a3fa0;" +
            "-fx-font-weight: bold;" +
            "-fx-border-color: transparent;"
        );

        HBox subtitleBox = new HBox(subtitleLabel, createAccountLink);
        subtitleBox.setAlignment(Pos.CENTER);

        emailField = new TextField();
        emailField.setPromptText("Email Address");
        emailField.setStyle(fieldStyle);

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setStyle(fieldStyle);

        passwordVisible = new TextField();
        passwordVisible.setPromptText("Password");
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

        forgotPasswordLink = new Hyperlink("Forgot password?");
        forgotPasswordLink.setStyle(
            "-fx-font-size: 13px;" +
            "-fx-text-fill: #555555;" +
            "-fx-border-color: transparent;"
        );

        errorLabel = new Label("");
        errorLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #cc0000;");

        loginButton = new Button("Login");
        loginButton.setStyle(buttonStyle);
        loginButton.setOnMouseEntered(e -> loginButton.setStyle(buttonHoverStyle));
        loginButton.setOnMouseExited(e -> loginButton.setStyle(buttonStyle));

        VBox card = new VBox(15);
        card.setAlignment(Pos.CENTER);
        card.setMaxWidth(500);
        card.getChildren().addAll(
            titleLabel,
            subtitleBox,
            emailField,
            passwordPane,
            forgotPasswordLink,
            errorLabel,
            loginButton
        );

        root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));
        root.setStyle("-fx-background-color: white;");
        root.getChildren().add(card);
        VBox.setVgrow(card, javafx.scene.layout.Priority.NEVER);
    }

    public String getPasswordText() {
        if (isPasswordVisible) {
            return passwordVisible.getText();
        } else {
            return passwordField.getText();
        }
    }

    public TextField getEmailField() {
        return emailField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public TextField getPasswordVisible() {
        return passwordVisible;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public Hyperlink getCreateAccountLink() {
        return createAccountLink;
    }

    public Hyperlink getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

    public VBox getRoot() {
        return root;
    }
}