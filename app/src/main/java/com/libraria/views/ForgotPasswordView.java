package com.libraria.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ForgotPasswordView {

    private TextField emailField;
    private Button submitButton;
    private Hyperlink loginLink;
    private Hyperlink signUpLink;
    private Label errorLabel;
    private VBox root;

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
            "-fx-padding: 0 16 0 16;";

    public ForgotPasswordView() {
        buildView();
    }

    private void buildView() {

        Label titleLabel = new Label("Forgot Password");
        titleLabel.setStyle(
            "-fx-font-size: 32px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #000000;"
        );

        Label subtitleLabel = new Label("Enter your email to find your account.");
        subtitleLabel.setStyle("-fx-font-size: 13px; -fx-text-fill: #555555;");

        emailField = new TextField();
        emailField.setPromptText("Email Address");
        emailField.setStyle(fieldStyle);

        errorLabel = new Label("");
        errorLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #cc0000;");

        submitButton = new Button("Find Account");
        submitButton.setStyle(buttonStyle);
        submitButton.setOnMouseEntered(e -> submitButton.setStyle(buttonHoverStyle));
        submitButton.setOnMouseExited(e -> submitButton.setStyle(buttonStyle));

        loginLink = new Hyperlink("Back to Login");
        loginLink.setStyle(
            "-fx-font-size: 13px;" +
            "-fx-text-fill: #1a3fa0;" +
            "-fx-font-weight: bold;" +
            "-fx-border-color: transparent;"
        );

        signUpLink = new Hyperlink("Sign Up");
        signUpLink.setStyle(
            "-fx-font-size: 13px;" +
            "-fx-text-fill: #1a3fa0;" +
            "-fx-font-weight: bold;" +
            "-fx-border-color: transparent;"
        );
        signUpLink.setVisible(false);
        signUpLink.setManaged(false);

        VBox card = new VBox(15);
        card.setAlignment(Pos.CENTER);
        card.setMaxWidth(500);
        card.getChildren().addAll(
            titleLabel,
            subtitleLabel,
            emailField,
            errorLabel,
            submitButton,
            loginLink,
            signUpLink
        );

        root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));
        root.setStyle("-fx-background-color: white;");
        root.getChildren().add(card);
    }

    public TextField getEmailField() {
        return emailField;
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    public Hyperlink getLoginLink() {
        return loginLink;
    }

    public Hyperlink getSignUpLink() {
        return signUpLink;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

    public VBox getRoot() {
        return root;
    }
}