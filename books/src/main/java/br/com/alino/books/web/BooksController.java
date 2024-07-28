package br.com.alino.books.web;

import br.com.alino.books.domain.entity.Books;
import br.com.alino.books.domain.service.BooksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/books")
public class BooksController {

    private BooksService service;

    public BooksController(BooksService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Books> create(@RequestBody Books books){
        var createBooks = service.create(books);
        return ResponseEntity.status(HttpStatus.CREATED).body(createBooks);
    }

    @GetMapping
    public ResponseEntity<List<Books>> getAllBooks(){
        var allBooks = service.getAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(allBooks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Books>> getBooksById(@PathVariable("id") Long id){
        var booksById = service.getById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(booksById);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Books> deleteBooks(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
