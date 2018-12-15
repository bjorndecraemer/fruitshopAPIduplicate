package bjorn.petprojects.fruitshopduplicate.api.v1.mapper;

import bjorn.petprojects.fruitshopduplicate.api.v1.model.CategoryDTO;
import bjorn.petprojects.fruitshopduplicate.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);


    CategoryDTO categoryToCategoryDTO(Category category);
}
