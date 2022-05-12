package com.bnta.book.books;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    @GetMapping
    public List<String> getBooks(){
        return Arrays.asList("The Shining", "Battle Royale", "Out", "In the Miso Soup", "Jane Eyre", "");
    }


}
