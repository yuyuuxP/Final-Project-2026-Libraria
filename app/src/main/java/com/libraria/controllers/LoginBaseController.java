package com.libraria.controllers;

import com.libraria.dao.UserDAO;
import com.libraria.utils.Validator;
import javafx.stage.Stage;

public abstract class LoginBaseController {
    UserDAO data = new UserDAO();
    Validator validator = new Validator();

    protected void loadScene(Stage stage, javafx.scene.Parent root, String title) {
        boolean wasMaximized = stage.isMaximized();
        javafx.scene.Scene scene = new javafx.scene.Scene(root, 600, 600);
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
