# 📚 Libraria
Aplikasi manajemen perpustakaan desktop berbasis Java dengan antarmuka grafis JavaFX. Libraria memudahkan pengelolaan koleksi buku, proses peminjaman, dan pengembalian buku secara terintegrasi dalam satu sistem.

---

## ✨ Fitur
### Autentikasi
- **Login:** validasi email dan password
- **Buat Akun:** registrasi akun untuk member baru
- **Lupa Password:** reset password menggunakan secret question & answer
- **Ganti Password:** ubah password dari dalam aplikasi

### Manajemen Buku (Admin)
- **Tambah Buku:** Input judul, penulis, kategori, dan genre
- **Kelola Buku:** lihat daftar seluruh buku beserta informasi lengkapnya
- **Hapus Buku:** hapus buku dari koleksi perpustakaan

### Peminjaman & Pengembalian
- **Peminjaman:** cari buku berdasarkan judul dan catat nama peminjam; status buku akan otomatis berubah menjadi _Not Available_
- **Pengembalian**: Proses pengembalian buku; status buku akan kembali menjadi _Available_

### Dashboard
- Navigasi utama menuju fitur kelola buku, Peminjaman, dan Pengembalian

---

## 🤝 Panduan Kontribusi
Ikuti langkah-langkah berikut untuk berkontribusi dalam proyek ini:
### Langkah 1: Fork Repository
Fork repository ini ke akun Github kamu.

### Langkah 2: Clone Repository
Clone repository yang telah di-fork laptop kamu:

```text
git clone https://github.com/username-kamu/Final-Project-2026-Libraria.git
```

### Langkah 3: Buka di Code Editor
Buka project di Visual Studio Code dan buka terminal.

### Langkah 4: Ganti Branch
Pindah ke branch yang telah dibuat sebelumnya:

```text
git checkout nama-branch-anda
```

contoh: `git checkout H071251007`

### Langkah 5: Push ke Branch Personal
- Setiap perubahan akan di-push ke branch personal kamu, **bukan ke branch main**.
- Setelah selesai, buat Pull Request ke branch utama (main).
- Review kode terlebih dahulu sebelum digabungkan ke main.
- Tujuannya untuk mencegah terjadi konflik dan menjaga integrasi kode.
  
### Langkah 6: Sinkronisasi dengan Main
Selalu sinkronisasi kode kamu dengan branch main secara berkala:

```text
git checkout main
git pull origin main
git checkout nama-branch-anda
git merge main
```

---

## 🗂️ Struktur Folder Proyek
```text
Final-Project-2026-Libraria/
├── app/
│   ├── src/main/java/com/libraria/
│   │   ├── App.java                        # Entry point aplikasi
│   │   ├── controllers/                    # Logika UI per halaman
│   │   │   ├── LoginController.java
│   │   │   ├── LoginBaseController.java
│   │   │   ├── DashboardController.java
│   │   │   ├── BukuController.java
│   │   │   ├── BukuBaseController.java
│   │   │   ├── KelolaBukuController.java
│   │   │   ├── DeleteBukuController.java
│   │   │   ├── ViewBukuController.java
│   │   │   ├── PeminjamanController.java
│   │   │   ├── PengembalianController.java
│   │   │   ├── CreateAccountController.java
│   │   │   └── ForgotPasswordController.java
│   │   ├── dao/                            # Akses database
│   │   │   ├── BukuDAO.java
│   │   │   ├── PeminjamanDAO.java
│   │   │   ├── PengembalianDAO.java
│   │   │   └── UserDAO.java
│   │   ├── database/
│   │   │   └── DatabaseConnection.java     # Koneksi & inisialisasi tabel SQLite
│   │   ├── models/                         # Data class
│   │   │   ├── User.java
│   │   │   ├── Admin.java
│   │   │   ├── Member.java
│   │   │   ├── Buku.java
│   │   │   ├── Peminjaman.java
│   │   │   └── Pengembalian.java
│   │   ├── services/                       # Logika bisnis
│   │   │   ├── BukuService.java
│   │   │   ├── LoginService.java
│   │   │   ├── PeminjamanService.java
│   │   │   └── PengembalianService.java
│   │   ├── utils/                          # Helper
│   │   │   ├── AlertHelper.java
│   │   │   ├── DatabaseUtils.java
│   │   │   ├── SceneSwitcher.java
│   │   │   └── Validator.java
│   │   └── views/                          # Komponen tampilan JavaFX
│   │       ├── LoginView.java
│   │       ├── DashboardView.java
│   │       ├── TambahBukuView.java
│   │       ├── KelolaBukuView.java
│   │       ├── DeleteBukuView.java
│   │       ├── ListBookView.java
│   │       ├── PeminjamanView.java
│   │       ├── PengembalianView.java
│   │       ├── CreateAccountView.java
│   │       ├── ForgotPasswordView.java
│   │       ├── SecretQuestionView.java
│   │       └── ChangePasswordView.java
│   ├── src/main/resources/
│   ├── Libraria.db                         # File database SQLite
│   └── build.gradle
├── gradle/
│   └── libs.versions.toml
└── settings.gradle
```

---

## 👥 Tim Pengembang Proyek Akhir
1. Patricius Reinhard Danduru - H071251074
2. Nurhayu Fiantika Gafar - H071251007
3. Keisya Fatimah Azzahrah - H071251008

---
✨Happy Coding and Goodluck!✨

