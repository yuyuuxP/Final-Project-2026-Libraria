package com.libraria.views;

import com.libraria.models.Buku;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DeleteBukuView {
    private VBox root;
    private TableView<Buku> tableBuku;
    private Button kembaliButton;
    private boolean confirmResult = false;

    @SuppressWarnings("unchecked")
    public DeleteBukuView() {
        Label titleLabel = new Label("🗑️ Delete Book");
        titleLabel.setStyle(
            "-fx-font-family: 'Arial Black', 'Segoe UI', sans-serif;" +
            "-fx-font-size: 32px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #004AAD;"
        );

        Label descLabel = new Label("Please select a book and click the delete button on the row you want to remove");
        descLabel.setStyle("-fx-font-family: 'Segoe UI', sans-serif; -fx-font-size: 14px; -fx-text-fill: #7F8C8D;");

        tableBuku = new TableView<>();
        tableBuku.setStyle(
            "-fx-background-color: #FFFFFF;" +
            "-fx-border-color: #E2E8F0;" +
            "-fx-border-radius: 12;" +
            "-fx-background-radius: 12;" +
            "-fx-padding: 10;"
        );

        TableColumn<Buku, String> colJudul = new TableColumn<>("Title");
        colJudul.setCellValueFactory(new PropertyValueFactory<>("title"));
        colJudul.setPrefWidth(220);

        TableColumn<Buku, String> colPenulis = new TableColumn<>("Author");
        colPenulis.setCellValueFactory(new PropertyValueFactory<>("author"));
        colPenulis.setPrefWidth(160);

        TableColumn<Buku, String> colKategori = new TableColumn<>("Category");
        colKategori.setCellValueFactory(new PropertyValueFactory<>("category"));
        colKategori.setPrefWidth(120);

        tableBuku.getColumns().addAll(colJudul, colPenulis, colKategori);

        kembaliButton = new Button("⬅ Back to Book Management");
        kembaliButton.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: #7F8C8D;" +
            "-fx-font-family: 'Segoe UI', sans-serif;" +
            "-fx-font-size: 14px;" +
            "-fx-font-weight: bold;" +
            "-fx-cursor: hand;"
        );
        kembaliButton.setOnMouseEntered(e -> kembaliButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #E74C3C; -fx-underline: true;"));
        kembaliButton.setOnMouseExited(e -> kembaliButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #7F8C8D;"));

        root = new VBox(25);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));
        root.setStyle("-fx-background-color: #F8FAFC;");
        root.getChildren().addAll(titleLabel, descLabel, tableBuku, kembaliButton);
    }

    public boolean showConfirmationPopup(Stage ownerStage, String judulBuku) {
        confirmResult = false; // Reset nilai awal
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initOwner(ownerStage);
        popupStage.initStyle(StageStyle.TRANSPARENT);

        Label alertTitle = new Label("⚠️ CONFIRMATION");
        alertTitle.setStyle("-fx-font-family: 'Arial Black', sans-serif; -fx-font-size: 18px; -fx-text-fill: #E74C3C;");

        Label msgLabel = new Label("Are you sure you want to delete the book:\n'" + judulBuku + "'?");
        msgLabel.setStyle("-fx-font-family: 'Segoe UI', sans-serif; -fx-font-size: 14px; -fx-text-fill: #2C3E50; -fx-text-alignment: center;");
        msgLabel.setWrapText(true);

        Button yaButton = new Button("Yes, Delete");
        yaButton.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-pref-width: 110; -fx-padding: 8; -fx-cursor: hand;");
        yaButton.setOnAction(e -> {
            confirmResult = true;
            popupStage.close();
        });

        Button batalButton = new Button("Cancel");
        batalButton.setStyle("-fx-background-color: #BDC3C7; -fx-text-fill: #2C3E50; -fx-font-weight: bold; -fx-background-radius: 8; -fx-pref-width: 110; -fx-padding: 8; -fx-cursor: hand;");
        batalButton.setOnAction(e -> {
            confirmResult = false;
            popupStage.close();
        });

        HBox btnContainer = new HBox(15, batalButton, yaButton);
        btnContainer.setAlignment(Pos.CENTER);

        VBox popupRoot = new VBox(20);
        popupRoot.setAlignment(Pos.CENTER);
        popupRoot.setPadding(new Insets(25));
        popupRoot.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 16; -fx-border-color: #E74C3C; -fx-border-radius: 16; -fx-border-width: 2;");
        popupRoot.getChildren().addAll(alertTitle, msgLabel, btnContainer);

        Scene popupScene = new Scene(popupRoot, 340, 200);
        popupScene.setFill(Color.TRANSPARENT);
        popupStage.setScene(popupScene);
        popupStage.showAndWait();

        return confirmResult;
    }

    public void showSuccessPopup(Stage ownerStage, String message) {
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initOwner(ownerStage);
        popupStage.initStyle(StageStyle.TRANSPARENT);

        Circle circle = new Circle(30, Color.web("#004AAD"));
        Line line1 = new Line(-10, 2, -2, 9); line1.setStroke(Color.WHITE); line1.setStrokeWidth(4);
        Line line2 = new Line(-3, 9, 13, -7); line2.setStroke(Color.WHITE); line2.setStrokeWidth(4);
        StackPane iconCheck = new StackPane(circle, line1, line2);

        Label statusLabel = new Label("SUCCESS!");
        statusLabel.setStyle("-fx-font-family: 'Arial Black', sans-serif; -fx-font-size: 18px; -fx-text-fill: #004AAD;");

        Label msgLabel = new Label(message);
        msgLabel.setStyle("-fx-font-family: 'Segoe UI', sans-serif; -fx-font-size: 13px; -fx-text-fill: #2C3E50; -fx-text-alignment: center;");
        msgLabel.setWrapText(true);

        Button okButton = new Button("OK");
        okButton.setStyle("-fx-background-color: #004AAD; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-pref-width: 100; -fx-padding: 8; -fx-cursor: hand;");
        okButton.setOnAction(e -> popupStage.close());

        VBox popupRoot = new VBox(15);
        popupRoot.setAlignment(Pos.CENTER);
        popupRoot.setPadding(new Insets(25));
        popupRoot.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 16; -fx-border-color: #004AAD; -fx-border-radius: 16; -fx-border-width: 2;");
        popupRoot.getChildren().addAll(iconCheck, statusLabel, msgLabel, okButton);

        Scene popupScene = new Scene(popupRoot, 320, 240);
        popupScene.setFill(Color.TRANSPARENT);
        popupStage.setScene(popupScene);
        popupStage.showAndWait();
    }

    public VBox getRoot() { 
        return root; 
    }
    public TableView<Buku> getTableBuku() { 
        return tableBuku; 
    }
    public Button getKembaliButton() { 
        return kembaliButton; 
    }
}