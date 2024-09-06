package br.org.iredeam.controllers.product;

import br.org.iredeam.data.dtos.ProductDto;
import br.org.iredeam.data.requests.ProductRequest;
import br.org.iredeam.domain.entities.Code;
import br.org.iredeam.domain.usecases.product.IUpdateProduct;
import br.org.iredeam.infra.request.ProductFormRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/product")
@Tag(name = "Product", description = "Update product")
public class UpdateProductController {


    private final IUpdateProduct<ProductDto, ProductRequest> updateProduct;

    public UpdateProductController(IUpdateProduct<ProductDto, ProductRequest> updateProduct) {
        this.updateProduct = updateProduct;
    }

    @PutMapping("/{id}")
    @Secured({Code.W_PRODUCT})
    public @ResponseBody ResponseEntity<?> updateProduct(@PathVariable Long id, @Validated @RequestBody ProductFormRequest productRequest) throws IllegalAccessException, InstantiationException {
        ProductDto productDto = updateProduct.execute(id, productRequest);
        if (productDto != null) {
            return ResponseEntity.ok().body(productDto);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
