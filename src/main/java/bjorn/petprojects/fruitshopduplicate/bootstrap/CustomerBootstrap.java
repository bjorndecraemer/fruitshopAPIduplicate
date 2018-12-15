package bjorn.petprojects.fruitshopduplicate.bootstrap;

import bjorn.petprojects.fruitshopduplicate.domain.Customer;
import bjorn.petprojects.fruitshopduplicate.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerBootstrap implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public CustomerBootstrap(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Customer c1 = new Customer();
        c1.setFirstName("John");
        c1.setLastName("Doe");
        Customer c2 = new Customer();
        c2.setFirstName("Jack");
        c2.setLastName("Skellington");
        Customer c3 = new Customer();
        c3.setFirstName("Jack");
        c3.setLastName("White");
        Customer c4 = new Customer();
        c4.setFirstName("Meg");
        c4.setLastName("White");
        Customer c5 = new Customer();
        c5.setFirstName("Stevie Ray");
        c5.setLastName("Vaughan");

        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);
        customerRepository.save(c4);
        customerRepository.save(c5);

        System.out.println("Customer data loaded : "+customerRepository.count());
    }
}
