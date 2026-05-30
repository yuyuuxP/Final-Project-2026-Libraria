package com.libraria.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ListBookView {
    private VBox root;
    private FlowPane catalogGrid;
    private ScrollPane scrollPane;
    private Button kembaliButton;

    public ListBookView() {
        Label titleLabel = new Label("📖 Book Collection");
        titleLabel.setStyle(
            "-fx-font-family: 'Arial Black', 'Segoe UI', sans-serif;" +
            "-fx-font-size: 32px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #004AAD;"
        );

        Label descLabel = new Label("Explore our entire collection of registered books in the Libraria system");
        descLabel.setStyle("-fx-font-family: 'Segoe UI', sans-serif; -fx-font-size: 14px; -fx-text-fill: #7F8C8D;");

        VBox headerContainer = new VBox(8, titleLabel, descLabel);
        headerContainer.setAlignment(Pos.CENTER);

        catalogGrid = new FlowPane();
        catalogGrid.setHgap(25);
        catalogGrid.setVgap(25);
        catalogGrid.setAlignment(Pos.TOP_CENTER);
        catalogGrid.setPadding(new Insets(20));
        catalogGrid.setStyle("-fx-background-color: #F8FAFC;");

        scrollPane = new ScrollPane(catalogGrid);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle(
            "-fx-background: #F8FAFC;" +
            "-fx-background-color: #F8FAFC;" +
            "-fx-border-color: transparent;" +
            "-fx-bar-policy: as-needed;"
        );

        kembaliButton = new Button("⬅ Back to Book Management");
        kembaliButton.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: #7F8C8D;" +
            "-fx-font-family: 'Segoe UI', sans-serif;" +
            "-fx-font-size: 15px;" +
            "-fx-font-weight: bold;" +
            "-fx-cursor: hand;"
        );
        kembaliButton.setOnMouseEntered(e -> kembaliButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #E74C3C; -fx-underline: true;"));
        kembaliButton.setOnMouseExited(e -> kembaliButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #7F8C8D;"));

        root = new VBox(25);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(35, 20, 25, 20));
        root.setStyle("-fx-background-color: #F8FAFC;");
        root.getChildren().addAll(headerContainer, scrollPane, kembaliButton);

        VBox.setVgrow(scrollPane, Priority.ALWAYS);
        root.setMaxWidth(Double.MAX_VALUE);
        root.setMaxHeight(Double.MAX_VALUE);
    }

    public VBox getRoot() { 
        return root; 
    }
    public FlowPane getCatalogGrid() { 
        return catalogGrid; 
    }
    public Button getKembaliButton() { 
        return kembaliButton; 
    }
}