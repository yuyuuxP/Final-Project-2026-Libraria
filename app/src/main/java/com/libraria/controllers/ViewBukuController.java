package com.libraria.controllers;

import com.libraria.models.Buku;
import com.libraria.views.ListBookView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class ViewBukuController extends BukuBaseController{
    private BukuBaseController kelolaBukuController = new KelolaBukuController();

    @Override
    public void show(Stage stage) {
        ListBookView view = new ListBookView();

        ArrayList<Buku> listBuku = bukuService.ambilSemuaBuku();

        if (listBuku.isEmpty()) {
            Label emptyLabel = new Label("Belum ada koleksi buku yang tersedia.");
            emptyLabel.setStyle("-fx-font-family: 'Segoe UI'; -fx-font-size: 15px; -fx-text-fill: #95A5A6; -fx-padding: 40;");
            view.getCatalogGrid().getChildren().add(emptyLabel);
        } else {
            for (Buku buku : listBuku) {
                Label iconBook = new Label("📖");
                iconBook.setStyle("-fx-font-size: 32px;");
                
                StackPane coverMockup = new StackPane(iconBook);
                coverMockup.setPrefHeight(100);
                coverMockup.setStyle(
                    "-fx-background-color: linear-gradient(to bottom, #2C426F, #172440);" +
                    "-fx-background-radius: 10 10 0 0;"
                );

                Label lblJudul = new Label(buku.getTitle());
                lblJudul.setWrapText(true);
                lblJudul.setStyle("-fx-font-family: 'Segoe UI', sans-serif; -fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: #172440;");

                Label lblPenulis = new Label(buku.getAuthor());
                lblPenulis.setStyle("-fx-font-family: 'Segoe UI'; -fx-font-size: 12px; -fx-text-fill: #7F8C8D;");

                Label lblGenre = new Label("Genre: " + buku.getGenre());
                lblGenre.setStyle("-fx-font-family: 'Segoe UI'; -fx-font-size: 11px; -fx-text-fill: #004AAD; -fx-background-color: #EBF5FB; -fx-padding: 2 6 2 6; -fx-background-radius: 4;");

                VBox infoBox = new VBox(6, lblJudul, lblPenulis, lblGenre);
                infoBox.setPadding(new Insets(12));
                infoBox.setAlignment(Pos.TOP_LEFT);

                VBox bookCard = new VBox();
                bookCard.setPrefWidth(160);
                bookCard.setMaxWidth(160);
                bookCard.setPrefHeight(210);
                bookCard.setStyle(
                    "-fx-background-color: #FFFFFF;" +
                    "-fx-background-radius: 12;" +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.06), 8, 0, 0, 3);" +
                    "-fx-cursor: hand;"
                );
                
                bookCard.setOnMouseEntered(e -> bookCard.setStyle(
                    "-fx-background-color: #FFFFFF;" +
                    "-fx-background-radius: 12;" +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,74,173,0.2), 12, 0, 0, 5);" +
                    "-fx-transform: translateY(-3px);"
                ));
                bookCard.setOnMouseExited(e -> bookCard.setStyle(
                    "-fx-background-color: #FFFFFF;" +
                    "-fx-background-radius: 12;" +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.06), 8, 0, 0, 3);"
                ));

                bookCard.getChildren().addAll(coverMockup, infoBox);
                view.getCatalogGrid().getChildren().add(bookCard);
            }
        }
        view.getKembaliButton().setOnAction(e -> {
            kelolaBukuController.show(stage);
        });

        Scene scene = new Scene(view.getRoot(), 850, 600);
        stage.setTitle("Libraria - Katalog Koleksi Buku");
        stage.setScene(scene);
        stage.show();
    }
}