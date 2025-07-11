package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.mapper.BookMapper;
import exercise.model.Author;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public List<BookDTO> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::map)
                .toList();
    }

    public BookDTO create(BookCreateDTO bookData) {
        Author author = authorRepository.findById(bookData.getAuthorId())
                .orElseThrow(() -> new ConstraintViolationException("Author not found", null));

        var book = bookMapper.map(bookData);
        book.setAuthor(author);
        bookRepository.save(book);
        return bookMapper.map(book);
    }

    public BookDTO show(Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found: " + id));
        return bookMapper.map(book);
    }

    public BookDTO update(BookUpdateDTO bookData, Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found: " + id));
        if (bookData.getAuthorId() != null && bookData.getAuthorId().isPresent()) {
            Long authorId = bookData.getAuthorId().get();
            Author author = authorRepository.findById(authorId)
                    .orElseThrow(() -> new ResourceNotFoundException("Author not found"));
            book.setAuthor(author);
        }

        bookMapper.update(bookData, book);
        bookRepository.save(book);
        return bookMapper.map(book);
    }

    public void destroy(Long id) {
        bookRepository.deleteById(id);
    }
    // END
}
