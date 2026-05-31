package com.libraria.controllers;

import com.libraria.dao.UserDAO;
import com.libraria.views.ProfileNavbarView;
import com.libraria.utils.AlertHelper;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProfileNavbarController {

    private ProfileNavbarView profileNavbarView;
    private Stage stage;
    private String email;

    public ProfileNavbarController(Stage stage, String email, VBox parentRoot) {
        this.stage = stage;
        this.email = email;
        this.profileNavbarView = new ProfileNavbarView();

        VBox.setVgrow(profileNavbarView.getNavbar(), Priority.NEVER);
        parentRoot.getChildren().add(0, profileNavbarView.getNavbar());

        setupEvents();
    }

    public ProfileNavbarController(Stage stage, String email, HBox parentRoot) {
        this.stage = stage;
        this.email = email;
        this.profileNavbarView = new ProfileNavbarView();

        parentRoot.getChildren().add(0, profileNavbarView.getNavbar());

        setupEvents();
    }

    private void setupEvents() {
        profileNavbarView.getChangePasswordLink().setOnAction(e -> {
            if (UserDAO.getUsersRole(email).equals("admin")) {
                AlertHelper.error("Cannot change Admin's password.");
                return;
            }
            AlertHelper.showConfirm("Change Password?", "Are you sure you want to change your password?", stage, () -> {
                ForgotPasswordController forgotPasswordController = new ForgotPasswordController();
                forgotPasswordController.showSecretQuestion(stage);
            });
        });

        profileNavbarView.getDeleteAccountLink().setOnAction(e -> {
            if (UserDAO.getUsersRole(email).equals("admin")) {
                AlertHelper.error("Cannot delete Admin's account.");
                return;
            }
            AlertHelper.showConfirm("Delete Account?", "Are you sure you want to delete your account?", stage, () -> {
                UserDAO.deleteAccount(email);
                LoginController loginController = new LoginController();
                loginController.show(stage);
            });
        });

        profileNavbarView.getLogoutLink().setOnAction(e -> {
            AlertHelper.showConfirm("Logout?", "Are you sure you want to logout?", stage, () -> {
                LoginController loginController = new LoginController();
                loginController.show(stage);
            });
        });
    }
}