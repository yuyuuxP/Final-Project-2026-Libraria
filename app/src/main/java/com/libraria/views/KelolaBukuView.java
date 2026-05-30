package com.libraria.views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class KelolaBukuView {
    private VBox root;
    private Button viewButton;
    private Button addButton;
    private Button deleteButton;
    private Button backButton;

    public KelolaBukuView() {
        Label titleLabel = new Label("📚 Book Management");
        titleLabel.setStyle(
            "-fx-font-family: 'Arial Black', 'Segoe UI', sans-serif;" +
            "-fx-font-size: 46px;" + 
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #004AAD;" +
            "-fx-alignment: center;"
        );

        HBox titleContainer = new HBox();
        titleContainer.setAlignment(Pos.CENTER);
        titleContainer.getChildren().add(titleLabel);

        viewButton = new Button("View Books");
        addButton = new Button("Add Book");
        deleteButton = new Button("Delete Book");
        backButton = new Button("⬅ Back to Dashboard");

        String wideFolderShape = "M 0 20 C 0 8, 8 0, 20 0 L 80 0 C 90 0, 93 6, 98 12 L 106 20 L 415 20 C 425 20, 430 25, 430 35 L 430 115 C 430 125, 420 135, 410 135 L 15 135 C 5 135, 0 125, 0 115 Z";

        String menuButtonStyle = 
            "-fx-shape: \"" + wideFolderShape + "\";" +
            "-fx-background-color: linear-gradient(to bottom, #2C426F, #172440);" + 
            "-fx-text-fill: #FFFFFF;" +
            "-fx-font-family: 'Segoe UI', 'Arial', sans-serif;" +
            "-fx-font-size: 26px;" + 
            "-fx-font-weight: bold;" +
            "-fx-alignment: center_left;" + 
            "-fx-padding: 20 0 0 45;" + 
            "-fx-pref-width: 440px;" + 
            "-fx-pref-height: 135px;" +
            "-fx-cursor: hand;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.25), 10, 0, 0, 5);";

        viewButton.setStyle(menuButtonStyle);
        addButton.setStyle(menuButtonStyle);
        deleteButton.setStyle(menuButtonStyle);

        backButton.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: #E74C3C;" +
            "-fx-font-family: 'Segoe UI', sans-serif;" +
            "-fx-font-size: 18px;" + 
            "-fx-font-weight: bold;" +
            "-fx-cursor: hand;"
        );

        viewButton.setOnMouseEntered(e -> viewButton.setStyle(menuButtonStyle + "-fx-background-color: linear-gradient(to bottom, #39558F, #1E2F54);"));
        viewButton.setOnMouseExited(e -> viewButton.setStyle(menuButtonStyle));

        addButton.setOnMouseEntered(e -> addButton.setStyle(menuButtonStyle + "-fx-background-color: linear-gradient(to bottom, #39558F, #1E2F54);"));
        addButton.setOnMouseExited(e -> addButton.setStyle(menuButtonStyle));

        deleteButton.setOnMouseEntered(e -> deleteButton.setStyle(menuButtonStyle + "-fx-background-color: linear-gradient(to bottom, #39558F, #1E2F54);"));
        deleteButton.setOnMouseExited(e -> deleteButton.setStyle(menuButtonStyle));
        
        backButton.setOnMouseEntered(e -> backButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #C0392B; -fx-underline: true; -fx-cursor: hand;"));
        backButton.setOnMouseExited(e -> backButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #E74C3C;"));

        VBox menuContainer = new VBox(22);
        menuContainer.setAlignment(Pos.CENTER);
        menuContainer.getChildren().addAll(viewButton, addButton, deleteButton);

        root = new VBox(60); 
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #FFFFFF; -fx-padding: 40;");
        root.getChildren().addAll(titleContainer, menuContainer, backButton);
        root.setMaxWidth(Double.MAX_VALUE);
        root.setMaxHeight(Double.MAX_VALUE);
        menuContainer.setMaxWidth(Double.MAX_VALUE);
        titleContainer.setMaxWidth(Double.MAX_VALUE);
    }

    public VBox getRoot() {
        return root;
    }
    public Button getViewButton() {
        return viewButton;
    }
    public Button getAddButton() {
        return addButton;
    }
    public Button getDeleteButton() {
        return deleteButton;
    }
    public Button getBackButton() {
        return backButton; 
    }
}