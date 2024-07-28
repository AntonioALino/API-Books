package br.com.alino.books.domain.service;

import br.com.alino.books.domain.entity.Books;
import br.com.alino.books.domain.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    private BooksRepository repository;

    public Books create(Books books){
        return repository.save(books);
    }

    public List<Books> getAll(){
       return repository.findAll();
    }

    public Optional<Books> getById(Long id){
        return repository.findById(id);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
