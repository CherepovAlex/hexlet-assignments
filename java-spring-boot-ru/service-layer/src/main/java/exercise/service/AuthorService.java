package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.dto.BookDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.mapper.BookMapper;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public List<AuthorDTO> findAll() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::map)
                .toList();
    }

    public AuthorDTO show(@PathVariable long id) {
        var author = authorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Author with id " + id + " not found"));
        return authorMapper.map(author);
    }

    public AuthorDTO create(@Valid @RequestBody AuthorCreateDTO categoryData) {
        var author = authorMapper.map(categoryData);
        authorRepository.save(author);
        return authorMapper.map(author);
    }

    public AuthorDTO update(AuthorUpdateDTO authorData, Long id) {
        var author = authorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not Found: " + id));
        authorMapper.update(authorData, author);
        authorRepository.save(author);
        return authorMapper.map(author);
    }

    public void destroy(Long id) {
        authorRepository.deleteById(id);
    }
    // END
}
