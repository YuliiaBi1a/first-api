package org.yuliia.first_api.books;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository //se puede usar @Component, pero asi es más semántico
public class InMemoryBookRepository implements BookRepository {

    private ArrayList<Book> bookList = new ArrayList<>();

    public InMemoryBookRepository() {
        Book book1 = new Book("A123", "tit1", "aut1");
        Book book2 = new Book("A124", "tit2", "aut2");
        this.bookList.add(book1);
        this.bookList.add(book2);
    }

    @Override
    public List<Book> findAll() {
        return Collections.unmodifiableList(bookList);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn))
                return Optional.of(book);
        }
        return Optional.empty();
    }

    @Override
    public void save(Book book) {
        bookList.add(book);
    }

    @Override
    public void deleteByIsbn(String isbn) {
        bookList.removeIf(book -> book.getIsbn().equals(isbn));
    }

}
