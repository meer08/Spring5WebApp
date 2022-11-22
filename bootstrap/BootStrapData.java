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

        System.out.println("Started in Bootstrap");
        System.out.println("Publisher Count: "+pbr.count());

        Author JK = new Author("JK", "Rowling");
        Book HP3 = new Book("Harry Potter and the Prisoner of Azkaban", "123123");
        JK.getBooks().add(HP3);
        HP3.getAuthors().add(JK);

        atr.save(JK);
        bkr.save(HP3);

        Author Dan = new Author("Dan", "Brown");
        Book AD = new Book("Angles and Demons", "3939459459");
        Dan.getBooks().add(AD);
        AD.getAuthors().add(Dan);

        atr.save(Dan);
        bkr.save(AD);


        System.out.println("Number of Books: " + bkr.count());
    }
}