package com.libraria.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import com.libraria.dao.UserDAO;
import com.libraria.utils.AlertHelper;
import com.libraria.views.KelolaBukuView;

public class KelolaBukuController extends BukuBaseController {
    @Override
    public void show(Stage stage) {
        KelolaBukuView view = new KelolaBukuView();
        BukuController bukuController = new BukuController();
        DashboardController dashboardController = new DashboardController();
        DeleteBukuController deleteBukuController = new DeleteBukuController();
        BukuBaseController viewBukuController = new ViewBukuController();

        view.getViewButton().setOnAction(e -> {
            viewBukuController.show(stage);
        });
        view.getAddButton().setOnAction(e -> {
            if (UserDAO.getUsersRole(LoginController.getCurrentEmail()).equals("admin")) {
                bukuController.show(stage);
            } else {
                AlertHelper.error("Only admins can add books.");
            }
        });
        view.getDeleteButton().setOnAction(e -> {
            if (UserDAO.getUsersRole(LoginController.getCurrentEmail()).equals("admin")) {
                deleteBukuController.show(stage);
            } else {
                AlertHelper.error("Only admins can delete books.");
            }
        });
        view.getBackButton().setOnAction(e -> {
            dashboardController.show(stage);
        });

        double currentWidth = stage.isMaximized() ? stage.getWidth() : 850;
        double currentHeight = stage.isMaximized() ? stage.getHeight() : 600;
        Scene scene = new Scene(view.getRoot(), currentWidth, currentHeight);
        aturDanTampilkanScene(stage, scene, "Libraria - Book Management");
    }
}