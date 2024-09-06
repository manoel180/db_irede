package br.org.iredeam.domain.entities;

/**
 * @author Manoel Neto
 */
public class Code {
    private static final String ROLE = "ROLE_";

    /**
     * Category
     */

    public static final String R_CATEGORY = ROLE + "CATEGORY_READ";
    public static final String W_CATEGORY = ROLE + "CATEGORY_WRITE";

    public static final String R_PRODUCT = ROLE + "PRODUCT_READ";
    public static final String W_PRODUCT = ROLE + "PRODUCT_WRITE";

}
