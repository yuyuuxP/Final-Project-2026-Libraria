package com.libraria.dao;

import com.libraria.database.DatabaseConnection;
import com.libraria.models.Buku;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BukuDAO {
    public boolean tambahBuku(Buku buku) {
        Connection conn = null;
        try {
            conn = DatabaseConnection.connect();
            String query = "INSERT INTO books (title, author, category, genre, status) VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, buku.getTitle());
            pstmt.setString(2, buku.getAuthor());
            pstmt.setString(3, buku.getCategory());
            pstmt.setString(4, buku.getGenre());
            pstmt.setString(5, buku.getStatus()); 

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            System.out.println("Failed to add book: " + e.getMessage());
            e.printStackTrace(); 
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Failed to close connection: " + e.getMessage());
            }
        }
    }

    public ArrayList<Buku> getAllBuku() {
        ArrayList<Buku> listBuku = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DatabaseConnection.connect();
            String query = "SELECT * FROM books";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Buku buku = new Buku(
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("genre"),
                    rs.getString("category")
                );
                listBuku.add(buku);
            }
        } catch (Exception e) {
            System.out.println("Failed to fetch book data: " + e.getMessage());
        } finally {
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return listBuku;
    }

    public boolean hapusBuku(String title) {
        Connection conn = null;
        try {
            conn = DatabaseConnection.connect();
            String query = "DELETE FROM books WHERE title = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, title);

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            System.out.println("Failed to delete book: " + e.getMessage());
            return false;
        } finally {
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    public boolean isJudulExist(String title) {
        String query = "SELECT COUNT(*) FROM books WHERE title = ?";
        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}