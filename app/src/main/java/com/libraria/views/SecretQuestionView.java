package com.libraria.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class SecretQuestionView {

    private Label questionLabel;
    private TextField answerField;
    private Button submitButton;
    private Hyperlink findUsernameLink;
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

    public SecretQuestionView() {
        buildView();
    }

    private void buildView() {

        Label titleLabel = new Label("Security Question");
        titleLabel.setStyle(
            "-fx-font-size: 32px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #000000;"
        );

        Label subtitleLabel = new Label("Answer your secret question to reset your password.");
        subtitleLabel.setStyle("-fx-font-size: 13px; -fx-text-fill: #555555;");

        questionLabel = new Label("");
        questionLabel.setStyle(
            "-fx-font-size: 15px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #1a3fa0;" +
            "-fx-wrap-text: true;" +
            "-fx-max-width: 420px;"
        );

        answerField = new TextField();
        answerField.setPromptText("Your Answer");
        answerField.setStyle(fieldStyle);

        errorLabel = new Label("");
        errorLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #cc0000;");

        submitButton = new Button("Submit");
        submitButton.setStyle(buttonStyle);
        submitButton.setOnMouseEntered(e -> submitButton.setStyle(buttonHoverStyle));
        submitButton.setOnMouseExited(e -> submitButton.setStyle(buttonStyle));

        findUsernameLink = new Hyperlink("Back to Find Username");
        findUsernameLink.setStyle(
            "-fx-font-size: 13px;" +
            "-fx-text-fill: #1a3fa0;" +
            "-fx-font-weight: bold;" +
            "-fx-border-color: transparent;"
        );

        VBox card = new VBox(15);
        card.setAlignment(Pos.CENTER);
        card.setMaxWidth(500);
        card.getChildren().addAll(
            titleLabel,
            subtitleLabel,
            questionLabel,
            answerField,
            errorLabel,
            submitButton,
            findUsernameLink
        );

        root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));
        root.setStyle("-fx-background-color: white;");
        root.getChildren().add(card);
    }

    public Label getQuestionLabel() {
        return questionLabel;
    }

    public TextField getAnswerField() {
        return answerField;
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    public Hyperlink getFindUsernameLink() {
        return findUsernameLink;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

    public VBox getRoot() {
        return root;
    }
}