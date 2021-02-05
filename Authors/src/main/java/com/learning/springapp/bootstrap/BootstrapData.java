package com.learning.springapp.bootstrap;

import com.learning.springapp.domain.Author;
import com.learning.springapp.domain.Book;
import com.learning.springapp.domain.Publisher;
import com.learning.springapp.repositories.AuthorRepository;
import com.learning.springapp.repositories.BookRepository;
import com.learning.springapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher rkashrama = new Publisher("RamaKrishna Ashrama", "Ramakrishna Ashrama", "Yadavagiri, Ontikoppal", "Mysuru", "Karnataka", "570020");
        publisherRepository.save(rkashrama);
        System.out.println(rkashrama.toString());

        Author prabhakar = new Author("T.N.", "Prabhakar");
        Book chanakya = new Book("Chanakya", "123456");
        chanakya.setPublisher(rkashrama);
        rkashrama.getBooks().add(chanakya);

        authorRepository.save(prabhakar);
        bookRepository.save(chanakya);
        publisherRepository.save(rkashrama);


        Author jagadathmananda = new Author("Swami", "Jagadathmananda");
        Book pd = new Book("Personality development", "123457");
        pd.setPublisher(rkashrama);
        rkashrama.getBooks().add(pd);

        authorRepository.save(jagadathmananda);
        bookRepository.save(pd);
        publisherRepository.save(rkashrama);

    }

}
