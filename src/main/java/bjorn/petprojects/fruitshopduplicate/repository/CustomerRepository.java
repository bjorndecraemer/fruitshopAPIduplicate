package bjorn.petprojects.fruitshopduplicate.repository;

import bjorn.petprojects.fruitshopduplicate.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByFirstName(String firstName);
}
