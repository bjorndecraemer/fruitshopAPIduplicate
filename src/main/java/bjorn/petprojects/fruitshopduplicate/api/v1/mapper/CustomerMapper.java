package bjorn.petprojects.fruitshopduplicate.api.v1.mapper;

import bjorn.petprojects.fruitshopduplicate.api.v1.model.CustomerDTO;
import bjorn.petprojects.fruitshopduplicate.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mappings({
        @Mapping(source = "firstName", target = "firstname"),
        @Mapping(source = "lastName", target = "lastname")
    })
    CustomerDTO customerToCustomerDTO(Customer customer);
}
