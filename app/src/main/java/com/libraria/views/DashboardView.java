package com.libraria.views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DashboardView {
    private VBox root;
    private Button bukuButton;
    private Button pinjamButton;
    private Button kembaliButton;

    public DashboardView() {
        Label welcomeText = new Label("Welcome to ");
        welcomeText.getStyleClass().add("welcome-text");
        Label brandText = new Label("Libraria !");
        brandText.getStyleClass().add("brand-text");
        
        HBox titleContainer = new HBox(5);
        titleContainer.setAlignment(Pos.CENTER);
        titleContainer.getChildren().addAll(welcomeText, brandText);

        bukuButton = new Button("Kelola\nBuku");
        pinjamButton = new Button("Pinjam\nBuku");
        kembaliButton = new Button("Kembalikan\nBuku");

        bukuButton.getStyleClass().add("folder-button");
        pinjamButton.getStyleClass().add("folder-button");
        kembaliButton.getStyleClass().add("folder-button");

        HBox buttonContainer = new HBox(25);
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.getChildren().addAll(bukuButton, pinjamButton, kembaliButton);

        root = new VBox(50);
        root.setAlignment(Pos.CENTER);
        root.getStyleClass().add("dashboard-root");
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