package com.libraria.dao;

import com.libraria.database.DatabaseConnection;
import com.libraria.models.Peminjaman;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PeminjamanDAO {
    public ArrayList<Peminjaman> getKatalogPeminjaman() {
        ArrayList<Peminjaman> listKatalog = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DatabaseConnection.connect();
            String query = "SELECT b.title, b.author, b.genre, b.category, " +
                            "CASE WHEN bb.borrow_date IS NOT NULL THEN 'Tidak Tersedia' " +
                            "ELSE 'Tersedia' END AS status_buku " +
                            "FROM books b " +
                            "LEFT JOIN borrowed_books bb ON b.title = bb.book_title";
                        
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Peminjaman data = new Peminjaman(
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("genre"),
                    rs.getString("category"),
                    rs.getString("status_buku")
                );
                listKatalog.add(data);
            }
        } catch (Exception e) {
            System.out.println("Failed! Error in PeminjamanDAO (Get JOIN): " + e.getMessage());
        } finally {
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return listKatalog;
    }

    public boolean pinjamBuku(String judulBuku, String namaPeminjam) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DatabaseConnection.connect();
            String query = "INSERT INTO borrowed_books (book_title, borrower_name, borrow_date) VALUES (?, ?, date('now'))";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, judulBuku.trim());
            pstmt.setString(2, namaPeminjam.trim());

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            System.out.println("Failed! Error in PeminjamanDAO (Insert): " + e.getMessage());
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {}
        }
    }
}