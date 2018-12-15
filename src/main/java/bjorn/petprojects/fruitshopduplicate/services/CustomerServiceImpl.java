package bjorn.petprojects.fruitshopduplicate.services;

import bjorn.petprojects.fruitshopduplicate.api.v1.model.CustomerDTO;
import bjorn.petprojects.fruitshopduplicate.repository.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {
        return null;
    }

    @Override
    public CustomerDTO findById(Long id) {
        return null;
    }

    @Override
    public CustomerDTO findByFirstName(String firstName) {
        return null;
    }
}
