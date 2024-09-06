package br.org.iredeam.controllers.product;

import br.org.iredeam.domain.entities.Code;
import br.org.iredeam.domain.usecases.product.IDeleteProduct;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/product")
@Tag(name = "Product", description = "Delete product")
public class DeleteProductController {


    private final IDeleteProduct deleteProduct;

    public DeleteProductController(IDeleteProduct deleteProduct) {
        this.deleteProduct = deleteProduct;
    }

    @DeleteMapping("/{id}")
    @Secured({Code.W_PRODUCT})
    public @ResponseBody ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        if (deleteProduct.execute(id)) {
            return ResponseEntity.ok().body("Product deleted");
        }
        return ResponseEntity.notFound().build();

    }
}
