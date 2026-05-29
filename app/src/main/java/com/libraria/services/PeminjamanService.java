package com.libraria.services;

import com.libraria.dao.PeminjamanDAO;
import com.libraria.models.Peminjaman;
import java.util.ArrayList;

public class PeminjamanService {
    private PeminjamanDAO peminjamanDAO = new PeminjamanDAO();

    public ArrayList<Peminjaman> ambilKatalogPeminjaman() {
        return peminjamanDAO.getKatalogPeminjaman();
    }

    public boolean eksekusiPeminjaman(String judul, String nama) {
        return peminjamanDAO.pinjamBuku(judul, nama);
    }
}