package com.libraria.views;

import com.libraria.models.Buku;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TambahBukuView {
    private HBox root;
    private TextField judulField;
    private TextField penulisField;
    private TextField kategoriField;
    private TextField genreField;
    private Button tambahButton;
    private Button kembaliButton;
    private TableView<Buku> tableBuku;

    @SuppressWarnings("unchecked")
    public TambahBukuView() {
        Label formTitle = new Label("➕ Add New Book");
        formTitle.setStyle("-fx-font-family: 'Segoe UI', Arial, sans-serif; -fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: #FFFFFF; -fx-padding: 0 0 10 0;");

        judulField = new TextField();
        judulField.setPromptText("Book Title");
        penulisField = new TextField();
        penulisField.setPromptText("Author Name");
        kategoriField = new TextField();
        kategoriField.setPromptText("Category");
        genreField = new TextField();
        genreField.setPromptText("Genre");

        String fieldStyle = 
            "-fx-background-color: #FFFFFF;" +
            "-fx-background-radius: 12;" +
            "-fx-border-radius: 12;" +
            "-fx-padding: 14;" +
            "-fx-font-family: 'Segoe UI', sans-serif;" +
            "-fx-font-size: 15px;" +
            "-fx-text-fill: #172440;";

        judulField.setStyle(fieldStyle);
        penulisField.setStyle(fieldStyle);
        kategoriField.setStyle(fieldStyle);
        genreField.setStyle(fieldStyle);

        judulField.setMaxWidth(320);
        penulisField.setMaxWidth(320);
        kategoriField.setMaxWidth(320);
        genreField.setMaxWidth(320);

        tambahButton = new Button("📥 Save Book");
        tambahButton.setStyle(
            "-fx-background-color: #004AAD;" +
            "-fx-text-fill: white;" +
            "-fx-font-family: 'Segoe UI', sans-serif;" +
            "-fx-font-size: 16px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 12;" +
            "-fx-cursor: hand;" +
            "-fx-max-width: 320;" +
            "-fx-padding: 14;"
        );
        tambahButton.setMaxWidth(320);

        kembaliButton = new Button("⬅ Back to Book Management");
        kembaliButton.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: #FFAAA6;" + 
            "-fx-font-family: 'Segoe UI', sans-serif;" +
            "-fx-font-size: 15px;" +
            "-fx-font-weight: bold;" +
            "-fx-cursor: hand;"
        );

        VBox leftPane = new VBox(25);
        leftPane.setAlignment(Pos.CENTER);
        leftPane.setPadding(new Insets(40));
        leftPane.setPrefWidth(380);
        leftPane.setMinWidth(350);
        leftPane.setStyle("-fx-background-color: linear-gradient(to bottom, #2C426F, #172440);");
        leftPane.getChildren().addAll(formTitle, judulField, penulisField, kategoriField, genreField, tambahButton, kembaliButton);

        Label tableTitle = new Label("New Book List");
        tableTitle.setStyle("-fx-font-family: 'Segoe UI', Arial, sans-serif; -fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #172440;");

        tableBuku = new TableView<>();
        tableBuku.setStyle(
            "-fx-background-color: #FFFFFF;" +
            "-fx-border-color: #E2E8F0;" +
            "-fx-border-radius: 8;" +
            "-fx-background-radius: 8;" +
            "-fx-font-size: 15px;"
        );

        TableColumn<Buku, String> colJudul = new TableColumn<>("Title");
        colJudul.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Buku, String> colPenulis = new TableColumn<>("Author");
        colPenulis.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Buku, String> colKategori = new TableColumn<>("Category");
        colKategori.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<Buku, String> colGenre = new TableColumn<>("Genre");
        colGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));

        tableBuku.getColumns().addAll(colJudul, colPenulis, colKategori, colGenre);
        tableBuku.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);

        VBox rightPane = new VBox(20);
        rightPane.setAlignment(Pos.TOP_LEFT);
        rightPane.setPadding(new Insets(40, 35, 40, 35));
        rightPane.setStyle("-fx-background-color: #FFFFFF;");
        rightPane.getChildren().addAll(tableTitle, tableBuku);
        VBox.setVgrow(tableBuku, Priority.ALWAYS); 
        HBox.setHgrow(rightPane, Priority.ALWAYS); 

        root = new HBox();
        root.getChildren().addAll(leftPane, rightPane);
        root.setMaxWidth(Double.MAX_VALUE);
        root.setMaxHeight(Double.MAX_VALUE);
    }

    public HBox getRoot() {
        return root; 
    }
    public TextField getJudulField() { 
        return judulField; 
    }
    public TextField getPenulisField() { 
        return penulisField; 
    }
    public TextField getKategoriField() { 
        return kategoriField; 
    }
    public TextField getGenreField() { 
        return genreField; 
    }
    public Button getTambahButton() { 
        return tambahButton; 
    }
    public Button getKembaliButton() { 
        return kembaliButton; 
    }
    public TableView<Buku> getTableBuku() { 
        return tableBuku;
    }
}