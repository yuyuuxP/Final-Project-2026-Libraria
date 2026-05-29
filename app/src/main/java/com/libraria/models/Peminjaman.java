package com.libraria.models;

public class Peminjaman {
    private String title;
    private String author;
    private String genre;
    private String category;
    private String status;

    public Peminjaman(String title, String author, String genre, String category, String status) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.category = category;
        this.status = status;
    }

    public String getTitle() { 
        return title; 
    }
    public void setTitle(String title) { 
        this.title = title; 
    }

    public String getAuthor() { 
        return author; 
    }
    public void setAuthor(String author) { 
        this.author = author; 
    }

    public String getGenre() { 
        return genre; 
    }
    public void setGenre(String genre) { 
        this.genre = genre; 
    }

    public String getCategory() { 
        return category; 
    }
    public void setCategory(String category) { 
        this.category = category; 
    }

    public String getStatus() { 
        return status; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }
}