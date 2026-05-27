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
        refreshTable(view);

        view.getTambahButton().setOnAction(e -> {
            String judul = view.getJudulField().getText();
            String penulis = view.getPenulisField().getText();
            String kategori = view.getKategoriField().getText();
            String genre = view.getGenreField().getText();

            Buku bukuBaru = new Buku(judul, penulis, genre, kategori);

            if (bukuService.tambahBuku(bukuBaru)) {
                AlertHelper.success("New book added successfully!");
                
                view.getJudulField().clear();
                view.getPenulisField().clear();
                view.getKategoriField().clear();
                view.getGenreField().clear();

                refreshTable(view);
            } else {
                AlertHelper.error("Failed to add new book! Please ensure all form fields are filled correctly.");
            }
        });
        view.getKembaliButton().setOnAction(e -> {
            kelolaBukuController.show(stage);
        });

        Scene scene = new Scene(view.getRoot(), 920, 580);
        stage.setTitle("Libraria - Add New Book");
        stage.setScene(scene);
        stage.show();
    }

    private static void refreshTable(TambahBukuView view) {
        bukuList.clear();
        bukuList.addAll(bukuService.ambilSemuaBuku());
        view.getTableBuku().setItems(bukuList);
    }
}