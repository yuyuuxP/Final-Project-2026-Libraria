package com.libraria.dao;

import com.libraria.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PengembalianDAO {
    public boolean kembalikanBuku(String judulBuku) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DatabaseConnection.connect();
            String query = "DELETE FROM borrowed_books WHERE LOWER(book_title) = LOWER(?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, judulBuku.trim());

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            System.out.println("Error di PengembalianDAO: " + e.getMessage());
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {}
        }
    }
}