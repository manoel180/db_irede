package br.org.iredeam.infra.mapstruct;

import br.org.iredeam.data.dtos.CategoryDto;
import br.org.iredeam.domain.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ICategoryMapStruct {


    @Mapping(target = "createdAt", source = "creation", dateFormat = "dd/MM/yyyy' 'HH:mm:ss")
    @Mapping(target = "name", source = "name")
    CategoryDto map(Category category);

    List<CategoryDto> map(List<Category> categoryList);

//    @Mapping(target = "lastUpdated", ignore = true)
//    @Mapping(target = "entityId", ignore = true)
//    @Mapping(target = "deleted", ignore = true)
//    @Mapping(target = "creation", ignore = true)
//    @Mapping(target = "active", ignore = true)
//    Category map(CategoryRequest categoryRequest);

}
