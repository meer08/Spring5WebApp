package springframework.udemy.Spring5WebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.udemy.Spring5WebApp.domain.Author;

public interface AuthorRepository extends CrudRepository <Author, Long>{
}
