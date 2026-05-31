package com.libraria.controllers;

import com.libraria.services.BukuService;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class BukuBaseController {
    protected static BukuService bukuService = new BukuService();
    
    protected void aturDanTampilkanScene(Stage stage, Parent root, String title, int width, int height) {
        boolean wasMaximized = stage.isMaximized();
        Scene scene = new Scene(root, width, height);
        stage.setScene(scene);
        stage.setTitle(title);

        if (!wasMaximized) {
            stage.setWidth(600);
            stage.setHeight(600);
        }
        
        stage.setMaximized(wasMaximized);
        stage.show();
    }
    public abstract void show(Stage stage);
}