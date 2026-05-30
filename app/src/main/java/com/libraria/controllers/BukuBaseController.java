package com.libraria.controllers;

import com.libraria.services.BukuService;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class BukuBaseController {
    protected static BukuService bukuService = new BukuService();
    
    protected void aturDanTampilkanScene(Stage stage, Scene scene, String title) {
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setMaximized(true);
        stage.show();
    }

    public abstract void show(Stage stage);
}