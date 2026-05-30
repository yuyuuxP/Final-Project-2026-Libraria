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
        VBox leftPane = new VBox(15);
        leftPane.setPadding(new Insets(40));
        leftPane.setPrefWidth(380);
        leftPane.setMinWidth(350);
        leftPane.setStyle("-fx-background-color: linear-gradient(to bottom, #2C426F, #172440);");
        leftPane.setAlignment(Pos.CENTER_LEFT);

        Label titleLabel = new Label("📕 Borrow Book");
        titleLabel.setStyle("-fx-font-family: 'Arial Black', 'Segoe UI', sans-serif; -fx-font-size: 28px; -fx-text-fill: #FFFFFF; -fx-padding: 0 0 10 0;");
        
        Label lblJudul = new Label("Book Title:");
        lblJudul.setStyle("-fx-font-family: 'Segoe UI'; -fx-text-fill: #FFFFFF; -fx-font-weight: bold;");
        
        judulField = new TextField();
        judulField.setPromptText("Enter book title...");
        judulField.setStyle("-fx-background-radius: 8; -fx-padding: 12; -fx-font-size: 14px;");

        Label lblNama = new Label("Borrower Name:");
        lblNama.setStyle("-fx-font-family: 'Segoe UI'; -fx-text-fill: #FFFFFF; -fx-font-weight: bold;");

        namaPeminjamField = new TextField();
        namaPeminjamField.setPromptText("Enter borrower name...");
        namaPeminjamField.setStyle("-fx-background-radius: 8; -fx-padding: 12; -fx-font-size: 14px;");

        pinjamButton = new Button("📤 Execute Borrow");
        pinjamButton.setMaxWidth(Double.MAX_VALUE);
        pinjamButton.setStyle(
            "-fx-background-color: #004AAD;" +
            "-fx-text-fill: white;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 8;" +
            "-fx-padding: 12;" +
            "-fx-font-size: 15px;" +
            "-fx-cursor: hand;"
        );

        kembaliButton = new Button("⬅ Back to Dashboard");
        kembaliButton.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: #FFAAA6;" +
            "-fx-font-weight: bold;" +
            "-fx-font-size: 14px;" +
            "-fx-cursor: hand;"
        );
        kembaliButton.setMaxWidth(Double.MAX_VALUE);
        kembaliButton.setAlignment(Pos.CENTER);

        leftPane.getChildren().addAll(titleLabel, lblJudul, judulField, lblNama, namaPeminjamField, pinjamButton, kembaliButton);

        VBox rightPane = new VBox(20);
        rightPane.setPadding(new Insets(40, 35, 40, 35));
        rightPane.setStyle("-fx-background-color: #FFFFFF;");
        HBox.setHgrow(rightPane, Priority.ALWAYS);

        Label tableTitle = new Label("Book Catalog Status");
        tableTitle.setStyle("-fx-font-family: 'Arial Black', 'Segoe UI', sans-serif; -fx-font-size: 24px; -fx-text-fill: #172440;");

        tableBuku = new TableView<>();
        tableBuku.setStyle(
            "-fx-background-color: #FFFFFF;" +
            "-fx-border-color: #E2E8F0;" +
            "-fx-border-radius: 12;" +
            "-fx-background-radius: 12;" +
            "-fx-padding: 10;" +
            "-fx-font-size: 15px;"
        );

        TableColumn<Peminjaman, String> colJudul = new TableColumn<>("Book Title");
        colJudul.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Peminjaman, String> colPenulis = new TableColumn<>("Author");
        colPenulis.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Peminjaman, String> colStatus = new TableColumn<>("Status");

        tableBuku.getColumns().addAll(colJudul, colPenulis, colStatus);
        tableBuku.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        VBox.setVgrow(tableBuku, Priority.ALWAYS);

        rightPane.getChildren().addAll(tableTitle, tableBuku);

        root = new HBox(leftPane, rightPane);
        root.setMaxWidth(Double.MAX_VALUE);
        root.setMaxHeight(Double.MAX_VALUE);
    }

    public HBox getRoot() { 
        return root; 
    }
    public TextField getJudulField() { 
        return judulField; 
    }
    public TextField getNamaPeminjamField() { 
        return namaPeminjamField; 
    }
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