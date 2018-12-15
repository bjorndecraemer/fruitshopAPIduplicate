package bjorn.petprojects.fruitshopduplicate.services;

import bjorn.petprojects.fruitshopduplicate.api.v1.mapper.CategoryMapper;
import bjorn.petprojects.fruitshopduplicate.api.v1.model.CategoryDTO;
import bjorn.petprojects.fruitshopduplicate.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl( CategoryRepository categoryRepository) {
        this.categoryMapper = CategoryMapper.INSTANCE;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> findAllCategories() {
        return  categoryRepository.findAll()
                .stream()
                .map(categoryMapper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        return categoryMapper.categoryToCategoryDTO(categoryRepository.findByName(name));

    }
}
