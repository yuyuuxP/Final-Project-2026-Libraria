package com.libraria.controllers;

import com.libraria.dao.UserDAO;
import com.libraria.utils.Validator;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public abstract class LoginBaseController {
    UserDAO data = new UserDAO();
    Validator validator = new Validator();

    protected void loadScene(Stage stage, Parent root, String title) {
        
        boolean wasMaximized = stage.isMaximized();
        
        if (!wasMaximized && !stage.isShowing()) {
            wasMaximized = true;
        }

        Scene scene = new Scene(root, 600, 600);
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