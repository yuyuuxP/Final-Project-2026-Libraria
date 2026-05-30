package com.libraria.controllers;

import com.libraria.services.BukuService;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class BukuBaseController {
    protected static BukuService bukuService = new BukuService();
    
    protected void aturDanTampilkanScene(Stage stage, Scene scene, String title) {
        boolean wasMaximized = stage.isMaximized();
        stage.setTitle(title);
        stage.setScene(scene);
        if (wasMaximized) {
            stage.setMaximized(false); 
            stage.setMaximized(true); 
        } else {
            stage.setMaximized(true);
        }
        stage.show();
    }
    public abstract void show(Stage stage);
}