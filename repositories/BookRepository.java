package springframework.udemy.Spring5WebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.udemy.Spring5WebApp.domain.Book;

public interface BookRepository extends CrudRepository<Book,Long > {
}
