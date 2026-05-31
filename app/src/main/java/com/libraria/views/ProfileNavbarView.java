package com.libraria.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class ProfileNavbarView {

    private HBox navbar;
    private Hyperlink changePasswordLink;
    private Hyperlink deleteAccountLink;
    private Hyperlink logoutLink;

    private String linkStyle =
            "-fx-font-size: 14px;" +
            "-fx-text-fill: #1a3fa0;" +
            "-fx-border-color: transparent;";

    private String deleteStyle =
            "-fx-font-size: 14px;" +
            "-fx-text-fill: #E74C3C;" +
            "-fx-border-color: transparent;";

    public ProfileNavbarView() {
        changePasswordLink = new Hyperlink("Change Password");
        changePasswordLink.setStyle(linkStyle);

        deleteAccountLink = new Hyperlink("Delete Account");
        deleteAccountLink.setStyle(deleteStyle);

        logoutLink = new Hyperlink("Logout");
        logoutLink.setStyle(linkStyle);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        navbar = new HBox(20, spacer, changePasswordLink, deleteAccountLink, logoutLink);
        navbar.setAlignment(Pos.CENTER_RIGHT);
        navbar.setPadding(new Insets(8, 20, 8, 20));
        navbar.setStyle("-fx-background-color: white; -fx-border-color: #e0e0e0; -fx-border-width: 0 0 1 0;");
        navbar.setMaxHeight(40);
    }

    public HBox getNavbar() {
        return navbar;
    }

    public Hyperlink getChangePasswordLink() {
        return changePasswordLink;
    }

    public Hyperlink getDeleteAccountLink() {
        return deleteAccountLink;
    }

    public Hyperlink getLogoutLink() {
        return logoutLink;
    }
}