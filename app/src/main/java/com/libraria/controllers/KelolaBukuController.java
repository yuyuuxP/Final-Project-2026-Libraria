package com.libraria.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import com.libraria.views.KelolaBukuView;

public class KelolaBukuController {
    public static void show(Stage stage) {
        KelolaBukuView view = new KelolaBukuView();

        view.getViewButton().setOnAction(e -> {
            ViewBukuController.show(stage);
        });
        view.getAddButton().setOnAction(e -> {
            BukuController.show(stage);
        });
        view.getDeleteButton().setOnAction(e -> {
            DeleteBukuController.show(stage);
        });
        view.getBackButton().setOnAction(e -> {
            DashboardController.show(stage);
        });

        Scene scene = new Scene(view.getRoot(), 700, 550);
        stage.setTitle("Libraria - Book Management");
        stage.setScene(scene);
        stage.show();
    }
}