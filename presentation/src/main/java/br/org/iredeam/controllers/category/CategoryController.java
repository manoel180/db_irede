package br.org.iredeam.controllers.category;

import br.org.iredeam.data.dtos.CategoryDto;
import br.org.iredeam.domain.entities.Code;
import br.org.iredeam.domain.usecases.category.IFindAllCategory;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/category")
@Tag(name = "Category", description = "Category")
public class CategoryController {


    private final IFindAllCategory<CategoryDto> findAllCategory;

    public CategoryController(IFindAllCategory<CategoryDto> findAllCategory) {
        this.findAllCategory = findAllCategory;
    }

    @GetMapping
    @Secured({Code.R_CATEGORY})
    public @ResponseBody ResponseEntity<?> listCategories() {
        List<CategoryDto> categoryDtos = findAllCategory.execute();
        return ResponseEntity.ok().body(categoryDtos);
    }
}
