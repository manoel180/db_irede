package br.org.iredeam.infra.request;

import br.org.iredeam.data.requests.ProductRequest;
import br.org.iredeam.domain.entities.Category;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Date;

public class ProductFormRequest extends ProductRequest {

    @Override
    @NotEmpty(message = "The name is required.")
    @Size(min = 1, max = 50, message = "The length of name must be between 1 and 50 characters.")
    public String getName() {
        return super.getName();
    }

    @Override
    @NotEmpty(message = "The description is required.")
    @Size(min = 1, max = 200, message = "The length of description must be between 1 and 200 characters.")
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    @PositiveOrZero(message = "The price must be positive")
    public BigDecimal getPrice() {
        return super.getPrice();
    }


    @Override
    @FutureOrPresent(message = "The Expiration Date must be in the in the future or today.")
    public Date getExpirationDate() {
        return super.getExpirationDate();
    }

    @Override
    @NotNull(message = "The category is required.")
    public Category getCategory() {
        return super.getCategory();
    }
}
