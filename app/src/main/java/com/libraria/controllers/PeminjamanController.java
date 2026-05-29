package com.libraria.controllers;

import com.libraria.models.Peminjaman;
import com.libraria.services.PeminjamanService;
import com.libraria.utils.AlertHelper;
import com.libraria.views.PeminjamanView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PeminjamanController extends BukuBaseController {
    private PeminjamanService peminjamanService = new PeminjamanService();
    private ObservableList<Peminjaman> katalogList = FXCollections.observableArrayList();
    private DashboardController dashboardController; 
    
    public PeminjamanController(DashboardController dashboardController) {
        this.dashboardController = dashboardController;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void show(Stage stage) {
        PeminjamanView view = new PeminjamanView();

        TableColumn<Peminjaman, String> colJudul = (TableColumn<Peminjaman, String>) view.getTableBuku().getColumns().get(0);
        TableColumn<Peminjaman, String> colPenulis = (TableColumn<Peminjaman, String>) view.getTableBuku().getColumns().get(1);
        TableColumn<Peminjaman, String> colStatus = (TableColumn<Peminjaman, String>) view.getTableBuku().getColumns().get(2);
        colJudul.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("Title"));
        colPenulis.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("Author"));
        colStatus.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("Status"));
        colStatus.setCellFactory(param -> new TableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item);
                    setAlignment(Pos.CENTER);
                    if (item.equalsIgnoreCase("Tersedia")) {
                        setTextFill(Color.web("#166534")); // Hijau
                        setStyle("-fx-font-weight: bold;");
                    } else {
                        setTextFill(Color.web("#E74C3C")); // Merah
                        setStyle("-fx-font-weight: bold;");
                    }
                }
            }
        });
        katalogList.clear();
        katalogList.addAll(peminjamanService.ambilKatalogPeminjaman());
        view.getTableBuku().setItems(katalogList);

        view.getPinjamButton().setOnAction(e -> {
            String judulIn = view.getJudulField().getText().trim();
            String namaIn = view.getNamaPeminjamField().getText().trim();
            if (judulIn.isEmpty() || namaIn.isEmpty()) {
                AlertHelper.error("Failed! Please fill in both the book title and borrower name fields.");
                return;
            }
            String judulProses = kapitalisasiTeks(judulIn);
            String namaProses = kapitalisasiTeks(namaIn);

            Peminjaman bukuTarget = null;
            for (Peminjaman p : katalogList) {
                if (p.getTitle().trim().equalsIgnoreCase(judulProses)) {
                    bukuTarget = p;
                    break;
                }
            }
            if (bukuTarget == null) {
                AlertHelper.error("Failed! Book '" + judulProses + "' not found in the catalog. Please check the title and try again.");
                return;
            }
            if (bukuTarget.getStatus().equalsIgnoreCase("Tidak Tersedia")) {
                AlertHelper.error("Failed! Book '" + judulProses + "' is currently not available (already borrowed).");
                return;
            }
            if (peminjamanService.eksekusiPeminjaman(judulProses, namaProses)) {
                AlertHelper.success("Book '" + judulProses + "' successfully borrowed by " + namaProses + "!");
                view.getJudulField().clear();
                view.getNamaPeminjamField().clear();
                
                katalogList.clear();
                katalogList.addAll(peminjamanService.ambilKatalogPeminjaman());
                view.getTableBuku().setItems(katalogList);
            } else {
                AlertHelper.error("Failed to process the borrowing transaction in the database.");
            }
        });

        view.getKembaliButton().setOnAction(e -> dashboardController.show(stage));
        Scene scene = new Scene(view.getRoot(), 950, 580);
        stage.setTitle("Libraria - Transaksi Peminjaman");
        stage.setScene(scene);
        stage.show();
    }

    private String kapitalisasiTeks(String input) {
        if (input == null || input.isEmpty()) return input;
        input = input.toLowerCase();
        StringBuilder hasil = new StringBuilder();
        boolean harusKapital = true;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ' ') {
                harusKapital = true;
                hasil.append(c);
            } else {
                if (harusKapital) {
                    hasil.append(Character.toUpperCase(c));
                    harusKapital = false;
                } else {
                    hasil.append(c);
                }
            }
        }
        return hasil.toString();
    }
}