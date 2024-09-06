package br.org.iredeam.data.dtos;

import br.org.iredeam.data.commons.GenericDto;

public class CategoryDto extends GenericDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
