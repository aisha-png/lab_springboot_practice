package com.bnta.book.books;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
public class BookModel {
    private int id;
    private String bookName;
    private String author;
    private LocalDate releaseDate;
    private Set<String> genres;
    private float price;

    public BookModel(){}

    public BookModel(int id, String bookName, String author, LocalDate releaseDate, Set<String> genres, float price){

        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.releaseDate = releaseDate;
        this.genres = genres;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public void setGenres(Set<String> genres) {
        this.genres = genres;
    }

    public void addGenres(String genre){
        this.genres.add(genre);
    }

    public boolean removeGenres(String genre){
        if (this.genres.contains(genre)){
            this.genres.remove(genre);
            return true;
        }
        return false;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    //A factory method

    public BookModel createNew(int id, String bookName, String author, LocalDate releaseDate, Set<String> genres, float price){
        return new BookModel(id, bookName, author, releaseDate, genres, price);
    }


}
