package com.libraria.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class CreateAccountView {

    private TextField emailField;
    private PasswordField passwordField;
    private TextField passwordVisible;
    private Button togglePassword;
    private TextField secretQuestionField;
    private TextField secretAnswerField;
    private Button createButton;
    private Hyperlink loginLink;
    private Label errorLabel;
    private Label successLabel;
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

    public CreateAccountView() {
        buildView();
    }

    private void buildView() {

        Label titleLabel = new Label("Sign Up");
        titleLabel.setStyle(
            "-fx-font-size: 32px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #000000;"
        );

        Label subtitleLabel = new Label("Already have an account? ");
        subtitleLabel.setStyle("-fx-font-size: 13px; -fx-text-fill: #555555;");

        loginLink = new Hyperlink("Log In");
        loginLink.setStyle(
            "-fx-font-size: 13px;" +
            "-fx-text-fill: #1a3fa0;" +
            "-fx-font-weight: bold;" +
            "-fx-border-color: transparent;"
        );

        HBox subtitleBox = new HBox(subtitleLabel, loginLink);
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

        secretQuestionField = new TextField();
        secretQuestionField.setPromptText("Secret Question");
        secretQuestionField.setStyle(fieldStyle);

        secretAnswerField = new TextField();
        secretAnswerField.setPromptText("The Answer of Secret Question");
        secretAnswerField.setStyle(fieldStyle);

        errorLabel = new Label("");
        errorLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #cc0000;");

        successLabel = new Label("");
        successLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #00cc00;");
        successLabel.setVisible(false);
        successLabel.setManaged(false);


        createButton = new Button("Create");
        createButton.setStyle(buttonStyle);
        createButton.setOnMouseEntered(e -> createButton.setStyle(buttonHoverStyle));
        createButton.setOnMouseExited(e -> createButton.setStyle(buttonStyle));

        VBox card = new VBox(15);
        card.setAlignment(Pos.CENTER);
        card.setMaxWidth(500);
        card.getChildren().addAll(
            titleLabel,
            subtitleBox,
            emailField,
            passwordPane,
            secretQuestionField,
            secretAnswerField,
            errorLabel,
            successLabel,
            createButton
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

    public TextField getEmailField() {
        return emailField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public TextField getPasswordVisible() {
        return passwordVisible;
    }

    public TextField getSecretQuestionField() {
        return secretQuestionField;
    }

    public TextField getSecretAnswerField() {
        return secretAnswerField;
    }

    public Button getCreateButton() {
        return createButton;
    }

    public Hyperlink getLoginLink() {
        return loginLink;
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