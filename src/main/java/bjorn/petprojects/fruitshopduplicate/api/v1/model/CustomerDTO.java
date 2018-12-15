package bjorn.petprojects.fruitshopduplicate.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String customerURL;
}
