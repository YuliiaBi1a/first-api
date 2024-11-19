package org.yuliia.first_api.books;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/books")
public class BookController {
    // Para usar InMemoryBoorRepository podemos poner @Autowired, pero no es buena práctica, mejor usar constructor
    private final BookRepository BOOK_REPOSITORY;

    public BookController(BookRepository BOOKREPOSITORY) {
        this.BOOK_REPOSITORY = BOOKREPOSITORY;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return BOOK_REPOSITORY.findAll();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getByIsbnBooks(@PathVariable String isbn){
        Optional<Book> optionalBook = BOOK_REPOSITORY.findByIsbn(isbn);
        if((optionalBook.isPresent())){
            return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Book> postBook(@RequestBody Book book){
        Optional<Book> optionalBook = BOOK_REPOSITORY.findByIsbn(book.getIsbn());
        if((optionalBook.isPresent())) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BOOK_REPOSITORY.save(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Book> deleteBook(@PathVariable String isbn){
        Optional<Book> optionalBook = BOOK_REPOSITORY.findByIsbn(isbn);
        if((optionalBook.isEmpty())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BOOK_REPOSITORY.deleteByIsbn(isbn);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<Book> updateBook(@PathVariable String isbn, @RequestBody Book updatedBook) {

        Optional<Book> optionalBook = BOOK_REPOSITORY.findByIsbn(isbn);

        if (optionalBook.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Book book = optionalBook.get();
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());

        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}


