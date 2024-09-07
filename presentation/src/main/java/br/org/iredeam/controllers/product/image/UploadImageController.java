package br.org.iredeam.controllers.product.image;

import br.org.iredeam.data.dtos.ImageDto;
import br.org.iredeam.data.dtos.ProductDto;
import br.org.iredeam.data.requests.ImageRequest;
import br.org.iredeam.data.requests.ProductRequest;
import br.org.iredeam.domain.entities.Code;
import br.org.iredeam.domain.usecases.product.ICreateProduct;
import br.org.iredeam.domain.usecases.product.image.ICreateImage;
import br.org.iredeam.infra.request.ProductFormRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;


@RestController
@RequestMapping(path = "/image")
@Tag(name = "Image", description = "Upload image")
public class UploadImageController {


    private final ICreateImage<ImageDto, ImageRequest> createImage;


    public UploadImageController(ICreateImage<ImageDto, ImageRequest> createImage) {
        this.createImage = createImage;
    }

    @PostMapping
    @Secured({Code.R_PRODUCT})
    public @ResponseBody ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file, @RequestParam("idProduct") Long idProduct) throws IOException {
        ImageRequest imageRequest = new ImageRequest();
        imageRequest.setName(file.getName());
        imageRequest.setImage(file.getBytes());
        imageRequest.setProduct(idProduct);
        try {
            ImageDto imageDto = createImage.execute(imageRequest);
            if (imageDto == null) {
                return ResponseEntity.badRequest().body("Image not uploaded");
            }
            return ResponseEntity.ok().body(imageDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Image not uploaded");
        }
    }

}
