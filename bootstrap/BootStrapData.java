package springframework.udemy.Spring5WebApp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.udemy.Spring5WebApp.domain.Author;
import springframework.udemy.Spring5WebApp.domain.Book;
import springframework.udemy.Spring5WebApp.repositories.AuthorRepository;
import springframework.udemy.Spring5WebApp.repositories.BookRepository;

@Component

public class BootStrapData implements CommandLineRunner {

    @Autowired
    private final AuthorRepository atr;

    @Autowired
    private final BookRepository bkr;

    public BootStrapData(AuthorRepository atr, BookRepository bkr)
    {
        this.atr = atr;
        this.bkr = bkr;
    }


    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        atr.save(eric);
        bkr.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        atr.save(rod);
        bkr.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bkr.count());
    }
}
