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
            Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/libraria/styles/Signature.ttf"), 58);
            if (customFont != null) {
                fontName = customFont.getFamily();
            }
        } catch (Exception e) {
            System.out.println("Custom font failed to load... Error: " + e.getMessage() + ", using default font...");
        }

        Label welcomeText = new Label("Welcome to ");
        welcomeText.setStyle("-fx-font-family: 'Arial Black', 'Segoe UI', sans-serif; -fx-font-size: 46px; -fx-font-weight: bold; -fx-text-fill: #004AAD;");
        Label brandText = new Label("Libraria !");
        brandText.setStyle("-fx-font-family: '" + fontName + "'; -fx-font-size: 58px; -fx-font-weight: bold; -fx-text-fill: #004AAD; -fx-padding: -8 0 0 12;"); 
        
        HBox titleContainer = new HBox();
        titleContainer.setAlignment(Pos.BASELINE_CENTER);
        titleContainer.getChildren().addAll(welcomeText, brandText);

        bukuButton = new Button("Book\nManagement");
        pinjamButton = new Button("Borrow\nBook");
        kembaliButton = new Button("Return\nBook");

        String folderShape = "M 0 25 C 0 10, 10 0, 25 0 L 85 0 C 95 0, 100 8, 107 15 L 117 24 L 235 24 C 245 24, 250 29, 250 39 L 250 190 C 250 200, 240 210, 230 210 L 15 210 C 5 210, 0 200, 0 190 Z";

        String folderStyle = 
            "-fx-shape: \"" + folderShape + "\";" +
            "-fx-background-color: linear-gradient(to bottom, #2C426F, #172440);" + 
            "-fx-text-fill: #FFFFFF;" +
            "-fx-font-family: 'Segoe UI', 'Arial', sans-serif;" +
            "-fx-font-size: 26px;" + 
            "-fx-font-weight: bold;" +
            "-fx-text-alignment: left;" +
            "-fx-alignment: bottom-left;" + 
            "-fx-padding: 0 0 35 30;" + 
            "-fx-pref-width: 240px;" +  
            "-fx-pref-height: 190px;" + 
            "-fx-cursor: hand;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 12, 0, 0, 6);";

        bukuButton.setStyle(folderStyle);
        pinjamButton.setStyle(folderStyle);
        kembaliButton.setStyle(folderStyle);

        bukuButton.setOnMouseEntered(e -> bukuButton.setStyle(folderStyle + "-fx-background-color: linear-gradient(to bottom, #39558F, #1E2F54);"));
        bukuButton.setOnMouseExited(e -> bukuButton.setStyle(folderStyle));

        pinjamButton.setOnMouseEntered(e -> pinjamButton.setStyle(folderStyle + "-fx-background-color: linear-gradient(to bottom, #39558F, #1E2F54);"));
        pinjamButton.setOnMouseExited(e -> pinjamButton.setStyle(folderStyle));

        kembaliButton.setOnMouseEntered(e -> kembaliButton.setStyle(folderStyle + "-fx-background-color: linear-gradient(to bottom, #39558F, #1E2F54);"));
        kembaliButton.setOnMouseExited(e -> kembaliButton.setStyle(folderStyle));

        HBox buttonContainer = new HBox(45);
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.getChildren().addAll(bukuButton, pinjamButton, kembaliButton);

        root = new VBox(75);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #FFFFFF; -fx-padding: 40;"); 
        root.getChildren().addAll(titleContainer, buttonContainer);

        root.setMaxWidth(Double.MAX_VALUE);
        root.setMaxHeight(Double.MAX_VALUE);
        buttonContainer.setMaxWidth(Double.MAX_VALUE);
        titleContainer.setMaxWidth(Double.MAX_VALUE);
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