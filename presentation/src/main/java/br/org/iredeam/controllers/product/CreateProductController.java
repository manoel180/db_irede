package br.org.iredeam.controllers.product;

import br.org.iredeam.data.dtos.ProductDto;
import br.org.iredeam.data.requests.ProductRequest;
import br.org.iredeam.domain.entities.Code;
import br.org.iredeam.domain.usecases.product.ICreateProduct;
import br.org.iredeam.infra.request.ProductFormRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/product")
@Tag(name = "Product", description = "create new product")
public class CreateProductController {


    private final ICreateProduct<ProductDto, ProductRequest> createProduct;


    public CreateProductController(ICreateProduct<ProductDto, ProductRequest> createProduct) {
        this.createProduct = createProduct;
    }

    @PostMapping
    @Secured({Code.R_PRODUCT})
    public @ResponseBody ResponseEntity<?> createProduct(@Validated @RequestBody ProductFormRequest productRequest) {
        ProductDto productDto = createProduct.execute(productRequest);
        return ResponseEntity.ok().body(productDto);
    }
}
