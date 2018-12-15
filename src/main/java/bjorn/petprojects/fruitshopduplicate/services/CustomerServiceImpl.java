package bjorn.petprojects.fruitshopduplicate.services;

import bjorn.petprojects.fruitshopduplicate.api.v1.mapper.CustomerMapper;
import bjorn.petprojects.fruitshopduplicate.api.v1.model.CustomerDTO;
import bjorn.petprojects.fruitshopduplicate.domain.Customer;
import bjorn.petprojects.fruitshopduplicate.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.customerMapper = CustomerMapper.INSTANCE;
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(Long id) {
        Optional<Customer> foundCustomerOptional = customerRepository.findById(id);
        return foundCustomerOptional.map(customerMapper::customerToCustomerDTO).orElse(null);
    }

    @Override
    public CustomerDTO findByFirstName(String firstName) {
        return customerMapper.customerToCustomerDTO(customerRepository.findByFirstName(firstName));
    }
}
