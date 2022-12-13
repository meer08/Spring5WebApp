package springframework.udemy.Spring5WebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springframework.udemy.Spring5WebApp.repositories.BookRepository;
import java.util.Set;

//Tell spring to treat it as a spring MVC Controller
@Controller
public class BookController
{
    //We are asking the spring framework to inject a book repository.
    private final BookRepository bkr;
    public BookController(BookRepository bkr)
    {
        //Generate Constructor - Because we have a constructor on that, this is a spring managed component
        //because it is a controller. When spring instantiates this, it will inject the instance of a that
        // book repository in the controller.
        this.bkr = bkr;
    }

    //When we do an action against this URL, this method is invoked.
    @RequestMapping("/books")
    public String getBooks(Model m)
    {
        // Model m
        // We have a controller, and we want to bring in the model.
        //Create the object of Model.
        //This is what is going to be returned to the view.
        //We want to enhance the model with list of books.


        //We are going to add attributes to the model
        //At runtime, when spring gets a request to the URL /books, it is going to execute the get books
        //This model is going to return back to our view layer, adn it's going to have an attribute books.

        //We are using the repository to get a list of books out of the database, assign it to that review of
        // books on that model, and then, we are returing a string, called 'books'
        //That is going to tell spring MVC, we want to apply the view books.
        m.addAttribute("books", bkr.findAll());

        //This is the view name.
        return "books";
    }
}
