package com.libraria.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PengembalianView {
    private HBox root;
    private TextField judulField;
    private Button kembalikanButton, kembaliButton;

    public PengembalianView() {
        VBox mainPane = new VBox(25);
        mainPane.setPadding(new Insets(50, 45, 50, 45));
        
        mainPane.setPrefWidth(460);
        mainPane.setMinWidth(400);
        mainPane.setMaxWidth(500);
        mainPane.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #2C426F, #172440);" +
            "-fx-background-radius: 16;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 15, 0, 0, 8);"
        );
        mainPane.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("🔄 Return Book");
        titleLabel.setStyle("-fx-font-family: 'Arial Black', 'Segoe UI', sans-serif; -fx-font-size: 28px; -fx-text-fill: #FFFFFF;");

        Label subLabel = new Label("Enter the title of the book you want to return");
        subLabel.setStyle("-fx-font-family: 'Segoe UI'; -fx-text-fill: #A0AEC0; -fx-font-size: 13px; -fx-text-alignment: center;");
        subLabel.setWrapText(true);

        judulField = new TextField();
        judulField.setPromptText("Enter book title...");
        judulField.setStyle("-fx-background-radius: 8; -fx-padding: 12; -fx-font-size: 14px;");

        kembalikanButton = new Button("📥 Execute Return");
        kembalikanButton.setMaxWidth(Double.MAX_VALUE);
        kembalikanButton.setStyle(
            "-fx-background-color: #22C55E;" +
            "-fx-text-fill: white;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 8;" +
            "-fx-padding: 12;" +
            "-fx-font-size: 15px;" +
            "-fx-cursor: hand;"
        );

        kembaliButton = new Button("⬅ Back to Dashboard");
        kembaliButton.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: #FFAAA6;" +
            "-fx-font-weight: bold;" +
            "-fx-font-size: 14px;" +
            "-fx-cursor: hand;"
        );
        kembaliButton.setMaxWidth(Double.MAX_VALUE);
        kembaliButton.setAlignment(Pos.CENTER);

        mainPane.getChildren().addAll(titleLabel, subLabel, judulField, kembalikanButton, kembaliButton);

        root = new HBox(mainPane);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #0F172A;");
        root.setMaxWidth(Double.MAX_VALUE);
        root.setMaxHeight(Double.MAX_VALUE);
    }

    public HBox getRoot() { 
        return root; 
    }
    public TextField getJudulField() { 
        return judulField; 
    }
    public Button getKembalikanButton() { 
        return kembalikanButton; 
    }
    public Button getKembaliButton() { 
        return kembaliButton; 
    }
}