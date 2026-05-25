package com.libraria.views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class DashboardView {
    
    private VBox root;
    private Button bukuButton;
    private Button pinjamButton;
    private Button kembaliButton;

    public DashboardView() {
        String fontName = "Segoe Script";
        try {
            Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/libraria/styles/Signature.ttf"), 46);
            if (customFont != null) {
                fontName = customFont.getFamily();
            }
        } catch (Exception e) {
            System.out.println("Custom font failed to load... Error: " + e.getMessage() + ", using default font...");
        }

        Label welcomeText = new Label("Welcome to ");
        welcomeText.setStyle("-fx-font-family: 'Arial Black', 'Segoe UI', sans-serif; -fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: #004AAD;");
        Label brandText = new Label("Libraria !");
        brandText.setStyle("-fx-font-family: '" + fontName + "'; -fx-font-size: 46px; -fx-font-weight: bold; -fx-text-fill: #004AAD; -fx-padding: -5 0 0 10;");
        
        HBox titleContainer = new HBox();
        titleContainer.setAlignment(Pos.BASELINE_CENTER);
        titleContainer.getChildren().addAll(welcomeText, brandText);

        bukuButton = new Button("Book\nManagement");
        pinjamButton = new Button("Borrow\nBook");
        kembaliButton = new Button("Return\nBook");

        String folderShape = "M 0 25 C 0 10, 10 0, 25 0 L 75 0 C 85 0, 90 8, 97 15 L 107 24 L 195 24 C 205 24, 210 29, 210 39 L 210 150 C 210 160, 200 170, 190 170 L 15 170 C 5 170, 0 160, 0 150 Z";

        String folderStyle = 
            "-fx-shape: \"" + folderShape + "\";" +
            "-fx-background-color: linear-gradient(to bottom, #2C426F, #172440);" + 
            "-fx-text-fill: #FFFFFF;" +
            "-fx-font-family: 'Segoe UI', 'Arial', sans-serif;" +
            "-fx-font-size: 22px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-alignment: left;" +
            "-fx-alignment: bottom-left;" + 
            "-fx-padding: 0 0 30 25;" + 
            "-fx-pref-width: 185px;" +
            "-fx-pref-height: 150px;" +
            "-fx-cursor: hand;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 10, 0, 0, 5);";

        bukuButton.setStyle(folderStyle);
        pinjamButton.setStyle(folderStyle);
        kembaliButton.setStyle(folderStyle);

        bukuButton.setOnMouseEntered(e -> bukuButton.setStyle(folderStyle + "-fx-background-color: linear-gradient(to bottom, #39558F, #1E2F54);"));
        bukuButton.setOnMouseExited(e -> bukuButton.setStyle(folderStyle));

        pinjamButton.setOnMouseEntered(e -> pinjamButton.setStyle(folderStyle + "-fx-background-color: linear-gradient(to bottom, #39558F, #1E2F54);"));
        pinjamButton.setOnMouseExited(e -> pinjamButton.setStyle(folderStyle));

        kembaliButton.setOnMouseEntered(e -> kembaliButton.setStyle(folderStyle + "-fx-background-color: linear-gradient(to bottom, #39558F, #1E2F54);"));
        kembaliButton.setOnMouseExited(e -> kembaliButton.setStyle(folderStyle));

        HBox buttonContainer = new HBox(30); 
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.getChildren().addAll(bukuButton, pinjamButton, kembaliButton);

        root = new VBox(55); 
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #FFFFFF; -fx-padding: 40;"); 
        root.getChildren().addAll(titleContainer, buttonContainer);
    }

    public VBox getRoot() {
        return root;
    }
    public Button getBukuButton() {
        return bukuButton;
    }
    public Button getPinjamButton() {
        return pinjamButton;
    }
    public Button getKembaliButton() { 
        return kembaliButton;
    }
}