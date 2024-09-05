package br.org.iredeam.data.usecases.category;


import br.org.iredeam.data.dtos.CategoryDto;
import br.org.iredeam.data.mappers.ICategoryMapper;
import br.org.iredeam.data.repositories.ICategoryRepository;
import br.org.iredeam.data.requests.CategoryRequest;
import br.org.iredeam.domain.entities.Category;
import br.org.iredeam.domain.usecases.category.ICreateCategory;

public class CreateCategoryImpl implements ICreateCategory<CategoryDto, CategoryRequest> {

    private final ICategoryRepository categoryRepository;
    private final ICategoryMapper categoryMapper;

    public CreateCategoryImpl(ICategoryRepository categoryRepository, ICategoryMapper categoryMapper) {

        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDto execute(CategoryRequest categoryRequest) {
        Category category = categoryMapper.categoryFormToCategory(categoryRequest);
        return categoryMapper.categoryToCategoryDto(this.categoryRepository.save(category));
    }
}
