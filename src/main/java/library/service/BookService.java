package library.service;

import library.entity.Book;
import library.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService implements IBookService {
    
    @Autowired
    BookRepository bookRepo;
      
    @Override
    public List<Book> findAll() {
       var books = (List<Book>) bookRepo.findAll();       
       return books;
    }



    
}
