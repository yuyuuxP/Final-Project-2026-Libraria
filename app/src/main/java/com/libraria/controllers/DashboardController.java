package com.libraria.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import com.libraria.views.DashboardView;

public class DashboardController extends BukuBaseController {
    private BukuBaseController kelolaBukuController = new KelolaBukuController();
    private PeminjamanController peminjamanController = new PeminjamanController(this);
    private PengembalianController pengembalianController = new PengembalianController(this);

    @Override
    public void show(Stage stage) {
        DashboardView view = new DashboardView();

        view.getBukuButton().setOnAction(e -> {
            kelolaBukuController.show(stage);
        });
        view.getPinjamButton().setOnAction(e -> {
            peminjamanController.show(stage);
        });
        view.getKembaliButton().setOnAction(e -> {
            pengembalianController.show(stage);
        });

        Scene scene = new Scene(view.getRoot(), 700, 450);
        aturDanTampilkanScene(stage, scene, "Libraria - Dashboard");
    }
}