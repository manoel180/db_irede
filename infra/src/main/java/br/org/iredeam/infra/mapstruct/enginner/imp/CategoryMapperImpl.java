package br.org.iredeam.infra.mapstruct.enginner.imp;

import br.org.iredeam.data.dtos.CategoryDto;
import br.org.iredeam.data.mappers.ICategoryMapper;
import br.org.iredeam.data.requests.CategoryRequest;
import br.org.iredeam.domain.entities.Category;
import br.org.iredeam.infra.mapstruct.enginner.ICategoryMapStruct;

import java.util.List;


public record CategoryMapperImpl(ICategoryMapStruct categoryMapStruct) implements ICategoryMapper {

    @Override
    public CategoryDto categoryToCategoryDto(Category category) {
        return categoryMapStruct.map(category);
    }

    @Override
    public Category categoryFormToCategory(CategoryRequest categoryRequest) {
        return null;
        //return categoryMapStruct.map(categoryRequest);
    }

    @Override
    public List<CategoryDto> categoryToListCategoryDto(List<Category> categories) {
        return categoryMapStruct.map(categories);
    }
}
