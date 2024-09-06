package br.org.iredeam.data.mappers;

import br.org.iredeam.data.dtos.CategoryDto;
import br.org.iredeam.data.requests.CategoryRequest;
import br.org.iredeam.domain.entities.Category;

import java.util.List;

public interface ICategoryMapper {
    CategoryDto categoryToCategoryDto(Category category);

    Category categoryFormToCategory(CategoryRequest categoryRequest);

    List<CategoryDto> categoryToListCategoryDto(List<Category> categories);
}
