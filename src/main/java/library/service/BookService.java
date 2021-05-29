package library.service;

import library.entity.Book;
import library.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService implements IBookService {
    
    @Autowired
    BookRepository repository;
    
    @Override
    public List<Book> findAll() {
       var books = (List<Book>) repository.findAll();
       return books;
    }

}
