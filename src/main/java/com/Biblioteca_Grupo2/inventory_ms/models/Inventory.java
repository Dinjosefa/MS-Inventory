package com.Biblioteca_Grupo2.inventory_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Inventory {
    @Id
    private String id;
    private String title;
    private String author;
    private Integer year;
    private String category;
    private String editorial;
    private Integer status;
    private String ISBN;
    private String poster;
    private String resume;

    public String getId() {
        return id;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Inventory(String id, String title, String author, Integer year, String category, String editorial, Integer status, String ISBN, String poster, String resume) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.category = category;
        this.editorial = editorial;
        this.status = status;
        this.ISBN = ISBN;
        this.poster = poster;
        this.resume = resume;
    }
}
