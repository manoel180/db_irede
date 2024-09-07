package br.org.iredeam.controllers.product.image;

import br.org.iredeam.data.dtos.ImageDto;
import br.org.iredeam.data.requests.ProductRequest;
import br.org.iredeam.domain.entities.Code;
import br.org.iredeam.domain.usecases.product.image.IDownloadImage;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;


@RestController
@RequestMapping(path = "/image")
@Tag(name = "Image", description = "Download image")
public class DownloadImageController {


    private final IDownloadImage downloadImage;

    public DownloadImageController(IDownloadImage downloadImage) {
        this.downloadImage = downloadImage;
    }

    @GetMapping("/{id}")
    @Secured({Code.R_PRODUCT})
    public @ResponseBody ResponseEntity<?> downloadImage(@PathVariable Long id) {
        byte[] imageData = downloadImage.execute(id);
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(IMAGE_PNG_VALUE))
                .body(imageData);


    }
}
