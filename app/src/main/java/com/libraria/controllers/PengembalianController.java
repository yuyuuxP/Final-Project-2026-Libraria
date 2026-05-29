package com.libraria.controllers;

import com.libraria.services.PengembalianService;
import com.libraria.utils.AlertHelper;
import com.libraria.views.PengembalianView;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class PengembalianController extends BukuBaseController {
    private PengembalianService pengembalianService = new PengembalianService();
    private DashboardController dashboardController;
    
    public PengembalianController(DashboardController dashboardController) {
        this.dashboardController = dashboardController;
    }

    @Override
    public void show(Stage stage) {
        PengembalianView view = new PengembalianView();

        view.getKembalikanButton().setOnAction(e -> {
            String judulIn = view.getJudulField().getText().trim();

            if (judulIn.isEmpty()) {
                AlertHelper.error("Failed! Please enter the title of the book you want to return.");
                return;
            }

            String judulProses = kapitalisasiTeks(judulIn);

            // Eksekusi hapus di database borrowed_books
            if (pengembalianService.eksekusiPengembalian(judulProses)) {
                AlertHelper.success("Success! The book '" + judulProses + "' has been successfully returned.");
                view.getJudulField().clear();
            } else {
                AlertHelper.error("Failed! The book '" + judulProses + "' was not found in the list of active loans.");
            }
        });

        view.getKembaliButton().setOnAction(e -> dashboardController.show(stage));

        Scene scene = new Scene(view.getRoot(), 950, 580);
        stage.setTitle("Libraria - Book Return");
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