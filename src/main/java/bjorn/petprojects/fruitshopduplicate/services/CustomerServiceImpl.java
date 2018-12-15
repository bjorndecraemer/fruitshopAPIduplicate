package bjorn.petprojects.fruitshopduplicate.services;

import bjorn.petprojects.fruitshopduplicate.api.v1.mapper.CustomerMapper;
import bjorn.petprojects.fruitshopduplicate.api.v1.model.CustomerDTO;
import bjorn.petprojects.fruitshopduplicate.domain.Customer;
import bjorn.petprojects.fruitshopduplicate.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CustomerServiceImpl implements CustomerService {

    public static final String API_V_1_CUSTOMERS = "/api/v1/customers/";
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
                .map(customer -> getCustomerDTOWithUrl(customer)
                )
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(Long id) {
        Optional<Customer> foundCustomerOptional = customerRepository.findById(id);
        return foundCustomerOptional.map(customer -> getCustomerDTOWithUrl(customer)).orElse(null);
    }

    @Override
    public List<CustomerDTO> findByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName)
                .stream()
                .map(customer -> getCustomerDTOWithUrl(customer))
                .collect(Collectors.toList());
    }

    private CustomerDTO getCustomerDTOWithUrl(Customer customer) {
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
        customerDTO.setCustomerURL(API_V_1_CUSTOMERS +customer.getId());
        return customerDTO;
    }
}
