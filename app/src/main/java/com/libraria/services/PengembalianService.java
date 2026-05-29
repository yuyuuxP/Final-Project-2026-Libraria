package com.libraria.services;

import com.libraria.dao.PengembalianDAO;

public class PengembalianService {
    private PengembalianDAO pengembalianDAO = new PengembalianDAO();

    public boolean eksekusiPengembalian(String judul) {
        return pengembalianDAO.kembalikanBuku(judul);
    }
}