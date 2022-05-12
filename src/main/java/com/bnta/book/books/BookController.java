package com.bnta.book.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    private BookService bookService;

    public BookController(){}

//    Automate a DI for the constructor
    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;

//        initialise a sample repository with some dummy books
        this.bookService.createBook("The Shining", "Stephen King",
                LocalDate.of(1980,11,7),
                new HashSet<>(Arrays.asList("Horror", "Psychological", "Mystery")),(float)9.99);
        this.bookService.createBook("Battle Royale", "Koushun Takami",
                LocalDate.of(2001, 9, 14),
                new HashSet<>(Arrays.asList("Thriller", "Suspense", "Dystopian Fiction")), (float)13.99);
        this.bookService.createBook("Jane Eyre", "Charlotte Bronte",
                LocalDate.of(1847, 10, 16),
                new HashSet<>(Arrays.asList("Historical", "Romance", "Gothic")), (float)5.99);
        this.bookService.createBook("In the Miso Soup", "Ryu Murakami",
                LocalDate.of(1997, 10, 16),
                new HashSet<>(Arrays.asList("Psychological", "Suspense")),(float)9.99);
    }


    @GetMapping
    public List<BookModel> getBooks(){
        return this.bookService.getBooks();
    }

//    bookService is being passed as a dependency since we will use its methods
    @GetMapping(value = "/{id}")
    public BookModel getBook(@PathVariable("id") int id){
        return this.bookService.getBook(id);
    }


}
