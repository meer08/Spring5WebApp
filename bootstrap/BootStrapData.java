package springframework.udemy.Spring5WebApp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.udemy.Spring5WebApp.domain.Author;
import springframework.udemy.Spring5WebApp.domain.Book;
import springframework.udemy.Spring5WebApp.domain.Publisher;
import springframework.udemy.Spring5WebApp.repositories.AuthorRepository;
import springframework.udemy.Spring5WebApp.repositories.BookRepository;
import springframework.udemy.Spring5WebApp.repositories.PublisherRepository;

@Component

public class BootStrapData implements CommandLineRunner {

    @Autowired
    private final AuthorRepository atr;

    @Autowired
    private final BookRepository bkr;

    @Autowired
    private final PublisherRepository pbr;

    public BootStrapData(AuthorRepository atr, BookRepository bkr, PublisherRepository pbr)
    {
        this.atr = atr;
        this.bkr = bkr;
        this.pbr = pbr;
    }


    @Override
    public void run(String... args) throws Exception
    {

        Publisher pub = new Publisher();
        pub.setName("Bloomsbury Publishing");
        pub.setAddressLine1("Borough of Camden");
        pub.setCity("London");
        pub.setState("UK");
        pub.setZip("902321");
        pbr.save(pub);

        Publisher pub2 = new Publisher();
        pub2.setName("Simon & Schuster");
        pub2.setAddressLine1("6th Avenue");
        pub2.setCity("New York City");
        pub2.setState("NY");
        pub2.setZip("10020");
        pbr.save(pub2);


        System.out.println("Started in Bootstrap");
        System.out.println("Publisher Count: "+pbr.count());

        //BOOK 1 - HP3
        Author JK = new Author("JK", "Rowling");
        Book HP3 = new Book("Harry Potter and the Prisoner of Azkaban", "123123");

        //Map the book with the author
        JK.getBooks().add(HP3);
        HP3.getAuthors().add(JK);

        //Setting the publisher
        HP3.setPbr(pub);
        pub.getBooks().add(HP3);

        //Author repository, book repository and publisher repository.
        atr.save(JK);
        bkr.save(HP3);
        pbr.save(pub);


        //BOOK 2 -  Angles & Demons
        Author Dan = new Author("Dan", "Brown");
        Book AD = new Book("Angles and Demons", "3939459459");

        //Map book with author
        Dan.getBooks().add(AD);
        AD.getAuthors().add(Dan);

        //Set the publisher
        AD.setPbr(pub2);
        pub2.getBooks().add(AD);

        //Author repository, book repository and publisher repository.
        atr.save(Dan);
        bkr.save(AD);
        pbr.save(pub2);


        System.out.println("Number of Books: " + bkr.count());
        System.out.println("Number of books under the publisher 'Bloomsbury' : "+ pub.getBooks().size());
        System.out.println("Number of books under the publisher 'Simon & Schuster' : "+pub2.getBooks().size());

    }
}
