package com.libraria.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import com.libraria.views.DashboardView;
import com.libraria.utils.AlertHelper;

public class DashboardController {
    public static void show(Stage stage) {
        DashboardView view = new DashboardView();

        view.getBukuButton().setOnAction(e -> {
            KelolaBukuController.show(stage);
        });
        view.getPinjamButton().setOnAction(e -> {
            AlertHelper.info("Borrow feature is under development!");
        });
        view.getKembaliButton().setOnAction(e -> {
            AlertHelper.info("Return book feature is under development!");
        });

        Scene scene = new Scene(view.getRoot(), 700, 450);
        stage.setScene(scene);
        stage.setTitle("Libraria - Dashboard");
        stage.show();
    }
}