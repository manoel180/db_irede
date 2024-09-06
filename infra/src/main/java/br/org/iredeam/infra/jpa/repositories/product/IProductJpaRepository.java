package br.org.iredeam.infra.jpa.repositories.product;


import br.org.iredeam.domain.entities.Product;
import br.org.iredeam.infra.jpa.common.CRUDGenericRepository;
import br.org.iredeam.infra.jpa.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductJpaRepository extends CRUDGenericRepository<ProductEntity, Product> {


    @Query("select p FROM ProductEntity p " +
            "WHERE p.name like %:searchTerm% " +
            "OR p.description like %:searchTerm%")
    Page<ProductEntity> search(
            @Param("searchTerm") String searchTerm,
            Pageable pageable);
}
