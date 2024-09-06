package br.org.iredeam.data.usecases.category;

import br.org.iredeam.data.dtos.CategoryDto;
import br.org.iredeam.data.mappers.ICategoryMapper;
import br.org.iredeam.data.repositories.ICategoryRepository;
import br.org.iredeam.domain.entities.Category;
import br.org.iredeam.domain.usecases.category.IFindAllCategory;

import java.util.List;


public class FindAllCategoryImp implements IFindAllCategory<CategoryDto> {
    private final ICategoryRepository categoryRepository;
    private final ICategoryMapper categoryMapper;

    public FindAllCategoryImp(ICategoryRepository categoryRepository, ICategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public List<CategoryDto> execute() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.categoryToListCategoryDto(categories);
    }
}