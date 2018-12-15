package bjorn.petprojects.fruitshopduplicate.services;

import bjorn.petprojects.fruitshopduplicate.api.v1.model.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> findAllCustomers();
    CustomerDTO findById(Long id);
    CustomerDTO findByFirstName(String firstName);
}
