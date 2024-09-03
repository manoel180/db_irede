package br.org.iredeam.domain.common;


import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Manoel Neto
 *     <p>Classe que implementa o padrao BusinessObject usado para generalizar as classes do modelo
 *     de dados do sistema
 */

public abstract class BusinessObjectDomain implements Serializable {

  /** Serial number */
  @Serial
  private static final long serialVersionUID = 6312478563208370431L;

  /*
   *********************
   *  ATTRIBUTES       *
   *********************
   */

  /** Chave primaria da entidade */

  private Long entityId;

  /** Armazena a data e hora em que o registro foi criado */
  private Date creation;

  private Date deleted;

  /**
   * Indica se um registro da entidade esta ativo ou inativo. Esta flag eh usada para excluir
   * logicamente um registro da entidade quando o mesmo nao puder ser excluido fisicamente
   */
  private Boolean active;

  public Long getEntityId() {
    return entityId;
  }

  public void setEntityId(Long entityId) {
    this.entityId = entityId;
  }

  public Date getCreation() {
    return creation;
  }

  public void setCreation(Date creation) {
    this.creation = creation;
  }

  public Date getDeleted() {
    return deleted;
  }

  public void setDeleted(Date deleted) {
    this.deleted = deleted;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  protected BusinessObjectDomain() {
  }

  protected BusinessObjectDomain(Long entityId, Date creation, Date lastUpdated, Date deleted, Boolean active) {
    this.entityId = entityId;
    this.creation = creation;
    this.deleted = deleted;
    this.active = active;
  }
}
