package com.libraria.controllers;

import com.libraria.views.LoginView;
import com.libraria.models.Member;
import javafx.stage.Stage;

public class LoginController extends LoginBaseController {
    LoginView loginView = new LoginView();

    @Override
    public void show(Stage stage) {
        loadScene(stage, loginView.getRoot(), "Libraria - Log In");

        loginView.getLoginButton().setOnAction(e -> {
            String email = loginView.getEmailField().getText().trim();
            String password = loginView.getPasswordText().trim();
            String result = verifyLogin(email, password);

            if (result.equals("Success")) {
                DashboardController dashboardController = new DashboardController();
                dashboardController.show(stage);
            } else {
                loginView.getErrorLabel().setText(result);
            }
        });

        loginView.getCreateAccountLink().setOnAction(e -> {
            CreateAccountController createAccountController = new CreateAccountController();
            createAccountController.show(stage);
        });

        loginView.getForgotPasswordLink().setOnAction(e -> {
            ForgotPasswordController forgotPasswordController = new ForgotPasswordController();
            forgotPasswordController.show(stage);
        });
    }

    public String verifyLogin(String email, String password) {
        if (validator.isFieldNotEmpty(email) && validator.isFieldNotEmpty(password)) {
            if (validator.isEmailValid(email)) {
                if (validator.isPasswordValid(password)) {
                    Member member = new Member(email, password);
                    if (data.login(member)) {
                        return "Success";
                    } else {
                        return "Email or password is incorrect!";
                    }
                } else {
                    return "Password must be at least 8 characters!";
                }
            } else {
                return "Email must end with @gmail.com";
            }
        } else {
            return "Email and password are required!";
        }
    }
}