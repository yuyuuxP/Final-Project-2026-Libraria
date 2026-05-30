package com.libraria.controllers;

import com.libraria.models.Buku;
import com.libraria.utils.AlertHelper;
import com.libraria.views.DeleteBukuView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.util.Callback;

public class DeleteBukuController extends BukuBaseController {
    private static ObservableList<Buku> bukuList = FXCollections.observableArrayList();
    private BukuBaseController kelolaBukuController = new KelolaBukuController();

    @SuppressWarnings("unchecked")
    @Override
    public void show(Stage stage) {
        DeleteBukuView view = new DeleteBukuView();

        TableColumn<Buku, String> colJudul = (TableColumn<Buku, String>) view.getTableBuku().getColumns().get(0);
        TableColumn<Buku, String> colPenulis = (TableColumn<Buku, String>) view.getTableBuku().getColumns().get(1);
        TableColumn<Buku, String> colKategori = (TableColumn<Buku, String>) view.getTableBuku().getColumns().get(2);
        
        Callback<TableColumn<Buku, String>, TableCell<Buku, String>> centerCellFactory = param -> new TableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item);
                    setAlignment(Pos.CENTER);
                }
            }
        };

        colJudul.setCellFactory(centerCellFactory);
        colPenulis.setCellFactory(centerCellFactory);
        colKategori.setCellFactory(centerCellFactory);

        TableColumn<Buku, Void> colAksi = new TableColumn<>("Action");
        colAksi.setPrefWidth(120);

        Callback<TableColumn<Buku, Void>, TableCell<Buku, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Buku, Void> call(final TableColumn<Buku, Void> param) {
                return new TableCell<>() {
                    private final Button btnHapus = new Button("Delete");
                    {
                        btnHapus.setStyle(
                            "-fx-background-color: #E74C3C;" +
                            "-fx-text-fill: white;" +
                            "-fx-font-weight: bold;" +
                            "-fx-background-radius: 6;" +
                            "-fx-cursor: hand;" +
                            "-fx-padding: 5 12 5 12;"
                        );
                        
                        btnHapus.setOnAction(event -> {
                            Buku dataBuku = getTableView().getItems().get(getIndex());
                            boolean yakinHapus = view.showConfirmationPopup(stage, dataBuku.getTitle());
                            if (yakinHapus) {
                                if (bukuService.deleteBuku(dataBuku.getTitle())) {
                                    view.showSuccessPopup(stage, "The '" + dataBuku.getTitle() + "' book is successfully deleted!");
                                    refreshTable(view); 
                                } else {
                                    AlertHelper.error("Failed to delete book data from database!");
                                }
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnHapus);
                            setAlignment(Pos.CENTER);
                        }
                    }
                };
            }
        };

        colAksi.setCellFactory(cellFactory);
        if (view.getTableBuku().getColumns().size() < 4) {
            view.getTableBuku().getColumns().add(colAksi);
        }
        
        refreshTable(view);

        view.getKembaliButton().setOnAction(e -> {
            kelolaBukuController.show(stage);
        });

        double currentWidth = stage.isMaximized() ? stage.getWidth() : 850;
        double currentHeight = stage.isMaximized() ? stage.getHeight() : 600;
        Scene scene = new Scene(view.getRoot(), currentWidth, currentHeight);
        aturDanTampilkanScene(stage, scene, "Libraria - Book Deletion");
    }

    private static void refreshTable(DeleteBukuView view) {
        bukuList.clear();
        bukuList.addAll(bukuService.ambilSemuaBuku());
        view.getTableBuku().setItems(bukuList);
    }
}