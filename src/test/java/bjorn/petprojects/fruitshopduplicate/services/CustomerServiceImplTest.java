package bjorn.petprojects.fruitshopduplicate.services;

import bjorn.petprojects.fruitshopduplicate.api.v1.model.CustomerDTO;
import bjorn.petprojects.fruitshopduplicate.domain.Customer;
import bjorn.petprojects.fruitshopduplicate.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CustomerServiceImplTest {

    public static final Long ID = 1L;
    public static final String FIRST_NAME = "John";
    public static final String LAST_NAME = "Doe";
    @Mock
    CustomerRepository customerRepository;

    CustomerService customerService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        customerService = new CustomerServiceImpl(customerRepository);
    }

    @Test
    public void findAllCustomers() {
        List<Customer> customers = Arrays.asList(new Customer(),new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        List<CustomerDTO> customerDTOS = customerService.findAllCustomers();

        assertEquals(3, customerDTOS.size());
    }

    @Test
    public void findById() {
        //Given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);

        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));
        //When
        CustomerDTO customerDTO = customerService.findById(ID);

        //Then
        assertEquals(ID,customerDTO.getId());
        assertEquals(FIRST_NAME,customerDTO.getFirstname());
        assertEquals(LAST_NAME,customerDTO.getLastname());
    }

    @Test
    public void findByFirstName() {
        //Given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);

        when(customerRepository.findByFirstName(anyString())).thenReturn(customer);
        //When
        CustomerDTO customerDTO = customerService.findByFirstName(FIRST_NAME);

        //Then
        assertEquals(ID,customerDTO.getId());
        assertEquals(FIRST_NAME,customerDTO.getFirstname());
        assertEquals(LAST_NAME,customerDTO.getLastname());
    }
}