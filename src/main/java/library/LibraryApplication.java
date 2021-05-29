package library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import library.controller.BookController;
import library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.ui.Model;

@SpringBootApplication
public class LibraryApplication {
    
    @Autowired
    BookController controller;
    
    @Autowired
    Book model;

    public static void main(String[] args) {
	SpringApplication.run(LibraryApplication.class, args);
    }
    


}
