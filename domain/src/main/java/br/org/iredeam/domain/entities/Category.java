package br.org.iredeam.domain.entities;


import br.org.iredeam.domain.common.BusinessObjectDomain;

import java.io.Serial;
import java.util.Date;


public class Category extends BusinessObjectDomain {

    @Serial
    private static final long serialVersionUID = 7950606353544282141L;

    private String name;

    public Category() {
    }

    public Category(Long entityId, Date creation, Boolean active, String name) {
        super(entityId, creation, active);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
