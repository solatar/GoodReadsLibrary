
package library.service;

import library.entity.Book;
import java.util.List;

public interface IBookService {
    List<Book> findAll();
}
