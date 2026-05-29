package com.libraria.views;

import com.libraria.models.Peminjaman;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PeminjamanView {
    private HBox root;
    private TextField judulField, namaPeminjamField;
    private Button pinjamButton, kembaliButton;
    private TableView<Peminjaman> tableBuku;

    @SuppressWarnings("unchecked")
    public PeminjamanView() {
        VBox leftPane = new VBox(20);
        leftPane.setPadding(new Insets(40));
        leftPane.setPrefWidth(380);
        leftPane.setStyle("-fx-background-color: #172440;");
        leftPane.setAlignment(Pos.CENTER_LEFT);

        Label titleLabel = new Label("📕 Borrow Book");
        titleLabel.setStyle("-fx-font-family: 'Arial Black', sans-serif; -fx-font-size: 28px; -fx-text-fill: #FFFFFF;");

        judulField = new TextField();
        judulField.setPromptText("Enter book title...");
        judulField.setStyle("-fx-background-radius: 8; -fx-padding: 10;");

        namaPeminjamField = new TextField();
        namaPeminjamField.setPromptText("Enter borrower name...");
        namaPeminjamField.setStyle("-fx-background-radius: 8; -fx-padding: 10;");

        pinjamButton = new Button("📤 Execute Borrow");
        pinjamButton.setMaxWidth(Double.MAX_VALUE);
        pinjamButton.setStyle("-fx-background-color: #004AAD; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-padding: 12;");

        kembaliButton = new Button("⬅ Back to Dashboard");
        kembaliButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #E74C3C; -fx-font-weight: bold;");

        leftPane.getChildren().addAll(titleLabel, new Label("Book Title:"), judulField, new Label("Borrower Name:"), namaPeminjamField, pinjamButton, kembaliButton);

        VBox rightPane = new VBox(20);
        rightPane.setPadding(new Insets(40));
        rightPane.setStyle("-fx-background-color: #F8FAFC;");
        HBox.setHgrow(rightPane, Priority.ALWAYS);

        Label tableTitle = new Label("Book Catalog Status");
        tableTitle.setStyle("-fx-font-family: 'Arial Black', sans-serif; -fx-font-size: 24px; -fx-text-fill: #172440;");

        tableBuku = new TableView<>();
        TableColumn<Peminjaman, String> colJudul = new TableColumn<>("Book Title");
        colJudul.setCellValueFactory(new PropertyValueFactory<>("title"));
        colJudul.setPrefWidth(220);

        TableColumn<Peminjaman, String> colPenulis = new TableColumn<>("Author");
        colPenulis.setCellValueFactory(new PropertyValueFactory<>("author"));
        colPenulis.setPrefWidth(140);

        TableColumn<Peminjaman, String> colStatus = new TableColumn<>("Status");
        colStatus.setPrefWidth(140);

        tableBuku.getColumns().addAll(colJudul, colPenulis, colStatus);
        rightPane.getChildren().addAll(tableTitle, tableBuku);

        root = new HBox(leftPane, rightPane);
    }

    public HBox getRoot() { 
        return root; 
    }
    public TextField getJudulField() { 
        return judulField; 
    }
    public TextField getNamaPeminjamField() { 
        return namaPeminjamField; }
    public Button getPinjamButton() { 
        return pinjamButton; 
    }
    public Button getKembaliButton() { 
        return kembaliButton; 
    }
    public TableView<Peminjaman> getTableBuku() { 
        return tableBuku; 
    }
}