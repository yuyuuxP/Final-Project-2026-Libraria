package com.libraria.controllers;

import com.libraria.models.Buku;
import com.libraria.utils.AlertHelper;
import com.libraria.views.TambahBukuView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BukuController extends BukuBaseController {
    private static ObservableList<Buku> bukuList = FXCollections.observableArrayList();
    private BukuBaseController kelolaBukuController = new KelolaBukuController();

    @Override
    public void show(Stage stage) {
        TambahBukuView view = new TambahBukuView();
        bukuList.clear();
        view.getTableBuku().setItems(bukuList);

        view.getTambahButton().setOnAction(e -> {
            String judulInput = view.getJudulField().getText().trim();
            String penulisInput = view.getPenulisField().getText().trim();
            String kategoriInput = view.getKategoriField().getText().trim();
            String genreInput = view.getGenreField().getText().trim();
            if (judulInput.isEmpty() || penulisInput.isEmpty() || kategoriInput.isEmpty() || genreInput.isEmpty()) {
                AlertHelper.error("All fields must be filled out! Please complete the form before submitting");
                return;
            }
            
            String judul = kapitalisasiTeks(judulInput);
            String penulis = kapitalisasiTeks(penulisInput);
            String kategori = kapitalisasiTeks(kategoriInput);
            String genre = kapitalisasiTeks(genreInput);

            Buku bukuBaru = new Buku(judul, penulis, genre, kategori);
            if (bukuService.tambahBuku(bukuBaru)) {
                AlertHelper.success("New book added successfully!");
                bukuList.add(bukuBaru);

                view.getJudulField().clear();
                view.getPenulisField().clear();
                view.getKategoriField().clear();
                view.getGenreField().clear();
            } else {
                AlertHelper.error("Failed to add new book! Please ensure all form fields are filled correctly.");
            }
        });
        view.getKembaliButton().setOnAction(e -> {
            bukuList.clear();
            kelolaBukuController.show(stage);
        });

        Scene scene = new Scene(view.getRoot(), 920, 580);
        aturDanTampilkanScene(stage, scene, "Libraria - Add New Book");
    }

    private String kapitalisasiTeks(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        input = input.toLowerCase();
        StringBuilder hasil = new StringBuilder();
        boolean harusKapital = true;

        for (int i = 0; i < input.length(); i++) {
            char hurufSekarang = input.charAt(i);

            if (hurufSekarang == ' ') {
                harusKapital = true;
                hasil.append(hurufSekarang);
            } else {
                if (harusKapital) {
                    hasil.append(Character.toUpperCase(hurufSekarang));
                    harusKapital = false;
                } else {
                    hasil.append(hurufSekarang);
                }
            }
        }
        return hasil.toString();
    }
}