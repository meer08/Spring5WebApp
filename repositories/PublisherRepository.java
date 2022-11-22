package springframework.udemy.Spring5WebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.udemy.Spring5WebApp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
