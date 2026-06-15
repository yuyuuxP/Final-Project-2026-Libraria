package com.libraria.services;

import com.libraria.dao.BukuDAO;
import com.libraria.models.Buku;
import java.util.ArrayList;

public class BukuService {
    BukuDAO bukuDAO = new BukuDAO();

    public boolean tambahBuku(Buku buku) {
        if (buku.getTitle().trim().isEmpty() || 
        buku.getAuthor().trim().isEmpty() || 
        buku.getCategory().trim().isEmpty() || 
        buku.getGenre().trim().isEmpty()) {
        return false;
        }
        if (bukuDAO.isJudulExist(buku.getTitle())) {
            return false; 
        }
        return bukuDAO.tambahBuku(buku);
    }

    public ArrayList<Buku> ambilSemuaBuku() {
        return bukuDAO.getAllBuku();
    }

    public boolean deleteBuku(String title) {
        return bukuDAO.hapusBuku(title);
    }

    public boolean isJudulExist(String title) {
        return bukuDAO.isJudulExist(title);
    }
}