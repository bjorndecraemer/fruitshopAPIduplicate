package bjorn.petprojects.fruitshopduplicate.repository;

import bjorn.petprojects.fruitshopduplicate.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findByFirstName(String firstName);
}
