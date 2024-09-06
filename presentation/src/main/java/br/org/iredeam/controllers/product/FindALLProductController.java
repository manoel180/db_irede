package br.org.iredeam.controllers.product;

import br.org.iredeam.data.dtos.ProductDto;
import br.org.iredeam.domain.entities.Code;
import br.org.iredeam.domain.usecases.product.IFindAllProduct;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/product")
@Tag(name = "Product", description = "List all products")
public class FindALLProductController {


    private final IFindAllProduct<ProductDto> findAllProduct;

    public FindALLProductController(IFindAllProduct<ProductDto> findAllProduct) {
        this.findAllProduct = findAllProduct;
    }

    @GetMapping
    @Secured({Code.R_PRODUCT})
    public @ResponseBody ResponseEntity<?> listProducts() {
        List<ProductDto> productDtos = findAllProduct.execute();
        return ResponseEntity.ok().body(productDtos);
    }
}
