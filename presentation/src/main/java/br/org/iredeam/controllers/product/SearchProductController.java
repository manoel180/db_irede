package br.org.iredeam.controllers.product;

import br.org.iredeam.data.dtos.ProductDto;
import br.org.iredeam.domain.entities.Code;
import br.org.iredeam.domain.usecases.product.ISearchProduct;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/product")
@Tag(name = "Product", description = "List all products")
public class SearchProductController {


    private final ISearchProduct<ProductDto> searchProduct;

    public SearchProductController(ISearchProduct<ProductDto> searchProduct) {
        this.searchProduct = searchProduct;
    }

    @GetMapping("/search")
    @Secured({Code.R_PRODUCT})
    public @ResponseBody ResponseEntity<?> searchProducts(@RequestParam("searchTerm") String searchTerm,
                                                          @RequestParam(
                                                                  value = "page",
                                                                  required = false,
                                                                  defaultValue = "0") int page,
                                                          @RequestParam(
                                                                  value = "size",
                                                                  required = false,
                                                                  defaultValue = "10") int size) {
        List<ProductDto> productDtos = searchProduct.execute(page, size, searchTerm);
        return ResponseEntity.ok().body(productDtos);
    }
}
