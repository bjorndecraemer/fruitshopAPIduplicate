package bjorn.petprojects.fruitshopduplicate.controllers.v1;

import bjorn.petprojects.fruitshopduplicate.api.v1.model.CustomerDTO;
import bjorn.petprojects.fruitshopduplicate.services.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerControllerTest {

    private static final long ID = 1L;
    private static final String FIRSTNAME = "John";
    private static final String LASTNAME = "Doe";
    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void getAllCustomers() throws Exception{
        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setId(ID);
        customerDTO1.setFirstname(FIRSTNAME);
        customerDTO1.setLastname(LASTNAME);
        CustomerDTO customerDTO2 = new CustomerDTO();
        customerDTO2.setId(2L);
        customerDTO2.setFirstname("Jack");
        customerDTO1.setLastname("White");

        List<CustomerDTO> customerDTOList = Arrays.asList(customerDTO1,customerDTO2);

        when(customerService.findAllCustomers()).thenReturn(customerDTOList);

        mockMvc.perform(get("/api/v1/customers/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customers",hasSize(2)));
    }

    @Test
    public void getCustomerById() throws Exception{
        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setId(ID);
        customerDTO1.setFirstname(FIRSTNAME);
        customerDTO1.setLastname(LASTNAME);

        when(customerService.findById(anyLong())).thenReturn(customerDTO1);

        mockMvc.perform(get("/api/v1/customers/1")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname", equalTo(FIRSTNAME)))
                .andExpect(jsonPath("$.lastname", equalTo(LASTNAME)))

        ;
    }

    @Test
    public void getCustomersByFirstName()throws Exception {
        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setId(ID);
        customerDTO1.setFirstname(FIRSTNAME);
        customerDTO1.setLastname(LASTNAME);

        CustomerDTO customerDTO2 = new CustomerDTO();
        customerDTO2.setId(2L);
        customerDTO2.setFirstname("John");
        customerDTO2.setLastname("Mc Clane");

        List<CustomerDTO> customerDTOList = Arrays.asList(customerDTO1,customerDTO2);

        when(customerService.findByFirstName(anyString())).thenReturn(customerDTOList);

        mockMvc.perform(get("/api/v1/customers/firstname/John")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.customers",hasSize(2)));
    }
}