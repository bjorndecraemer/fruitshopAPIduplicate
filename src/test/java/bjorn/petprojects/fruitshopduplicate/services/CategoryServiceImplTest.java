package bjorn.petprojects.fruitshopduplicate.services;

import bjorn.petprojects.fruitshopduplicate.api.v1.model.CategoryDTO;
import bjorn.petprojects.fruitshopduplicate.domain.Category;
import bjorn.petprojects.fruitshopduplicate.repository.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CategoryServiceImplTest {

    private static final String NAME = "John";
    private static final long ID = 1L;
    @Mock
    CategoryRepository categoryRepository;

    private CategoryService categoryService;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        categoryService = new CategoryServiceImpl(categoryRepository);
    }

    @Test
    public void findAllServices() {
        //Given
        List<Category> categories = Arrays.asList(new Category(), new Category(), new Category());

        when(categoryRepository.findAll()).thenReturn(categories);

        //When
        List<CategoryDTO> foundCategoryDTOS = categoryService.findAllCategories();
        //Then
        assertEquals(3, foundCategoryDTOS.size());

    }

    @Test
    public void getCategoryByName() {
        // Given
        Category category = new Category();
        category.setId(ID);
        category.setName(NAME);

        when(categoryRepository.findByName(anyString())).thenReturn(category);

        //When
        CategoryDTO categoryDTO = categoryService.getCategoryByName(NAME);

        //Then
        assertEquals(Long.valueOf(ID), categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());
    }
}