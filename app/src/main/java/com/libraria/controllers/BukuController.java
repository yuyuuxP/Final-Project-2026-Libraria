package com.libraria.controllers;

import com.libraria.models.Buku;
import com.libraria.services.BukuService;
import com.libraria.utils.AlertHelper;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BukuController {
    public static void show(Stage stage) {
        Label title = new Label("➕ ADD BOOK");

        title.setStyle(
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #1E3A5F;"
        );

        TextField judulField = new TextField();
        judulField.setPromptText("Book Title");
        TextField penulisField = new TextField();
        penulisField.setPromptText("Author");
        TextField kategoriField = new TextField();
        kategoriField.setPromptText("Category");
        TextField genreField = new TextField();
        genreField.setPromptText("Genre");

        String inputStyle =
                "-fx-background-radius: 10;" +
                "-fx-border-radius: 10;" +
                "-fx-padding: 10;" +
                "-fx-font-size: 13px;";

        judulField.setStyle(inputStyle);
        penulisField.setStyle(inputStyle);
        kategoriField.setStyle(inputStyle);
        genreField.setStyle(inputStyle);

        judulField.setMaxWidth(250);
        penulisField.setMaxWidth(250);
        kategoriField.setMaxWidth(250);
        genreField.setMaxWidth(250);

        Button tambahButton =
                new Button("Add Book");
        Button kembaliButton =
                new Button("⬅ Back");

        tambahButton.setPrefWidth(250);
        kembaliButton.setPrefWidth(250);

        tambahButton.setStyle(
                "-fx-background-color: #2ECC71;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 10;" +
                "-fx-cursor: hand;"
        );
        kembaliButton.setStyle(
                "-fx-background-color: #E74C3C;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 10;" +
                "-fx-cursor: hand;"
        );

        BukuService bukuService = new BukuService();

        tambahButton.setOnAction(e -> {
            Buku buku = new Buku( 
                    judulField.getText(),
                    penulisField.getText(),
                    genreField.getText(),
                    kategoriField.getText()
            );

            if(bukuService.tambahBuku(buku)) {
                AlertHelper.success("Book successfully added!");

                judulField.clear();
                penulisField.clear();
                kategoriField.clear();
                genreField.clear();
            } else {
                AlertHelper.error("Book data is incomplete!");
            }
        });

        kembaliButton.setOnAction(e -> {
            KelolaBukuController.show(stage);
        });

        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.setStyle(
                "-fx-background-color: #F5F7FA;"
        );

        root.getChildren().addAll(
                title,
                judulField,
                penulisField,
                kategoriField,
                genreField,
                tambahButton,
                kembaliButton
        );

        Scene scene = new Scene(root, 500, 600);
        stage.setTitle("Add Book");
        stage.setScene(scene);
        stage.show();
    }
}