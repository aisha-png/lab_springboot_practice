package com.bnta.book.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class BookService {

    private BookModel bookModelFactory;
    private List<BookModel> books = new ArrayList<>();
    private int nextId = 0;

    public BookService(){}

    @Autowired
    public BookService(BookModel bookModelFactory){
        this.bookModelFactory = bookModelFactory;
    }

    public void createBook(String bookName, String author, LocalDate releaseDate, Set<String> genres, float price){
        this.books.add(this.bookModelFactory.createNew(this.nextId, bookName, author, releaseDate, genres, price));
        this.nextId++;
    }


}
