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
        mainPane.setPadding(new Insets(50));
        mainPane.setPrefWidth(450);
        mainPane.setStyle("-fx-background-color: #172440;");
        mainPane.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("🔄 Return Book");
        titleLabel.setStyle("-fx-font-family: 'Arial Black', sans-serif; -fx-font-size: 26px; -fx-text-fill: #FFFFFF;");

        Label subLabel = new Label("Enter the title of the book you want to return");
        subLabel.setStyle("-fx-text-fill: #A0AEC0; -fx-font-size: 12px;");
        subLabel.setWrapText(true);

        judulField = new TextField();
        judulField.setPromptText("Enter book title...");
        judulField.setStyle("-fx-background-radius: 8; -fx-padding: 12; -fx-font-size: 14px;");

        kembalikanButton = new Button("📥 Execute Return");
        kembalikanButton.setMaxWidth(Double.MAX_VALUE);
        kembalikanButton.setStyle("-fx-background-color: #22C55E; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 12; -fx-font-size: 14px;");

        kembaliButton = new Button("⬅ Back to Dashboard");
        kembaliButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #E74C3C; -fx-font-weight: bold; -fx-cursor: hand;");

        mainPane.getChildren().addAll(titleLabel, subLabel, judulField, kembalikanButton, kembaliButton);

        root = new HBox(mainPane);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #0F172A;");
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