package com.libraria;

import com.libraria.controllers.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    LoginBaseController loginController = new LoginController();

    @Override
    public void start(Stage stage) {
        loginController.show(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}