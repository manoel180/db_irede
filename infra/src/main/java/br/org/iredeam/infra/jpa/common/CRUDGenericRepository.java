package br.org.iredeam.infra.jpa.common;

import br.org.iredeam.domain.common.BusinessObjectDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CRUDGenericRepository<E extends BusinessObject<E, O>, O extends BusinessObjectDomain>
	extends JpaRepository<E, Long> {

}
