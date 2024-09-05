package br.org.iredeam.infra.jpa.common;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


/**
 * @author Manoel Neto
 *     <p>Classe que implementa o padrao BusinessObject usado para generalizar as classes do modelo
 *     de dados do sistema
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class BusinessObject<E, O> implements Serializable, ConverterEntity<E, O> {

  /**
   * Serial number
   */
  @Serial
  private static final long serialVersionUID = 6312478563208370431L;

  /*
   *********************
   *  ATTRIBUTES       *
   *********************
   */

  /**
   * Chave primaria da entidade
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  protected Long entityId;

  /**
   * Armazena a data e hora em que o registro foi criado
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "creation", nullable = false, updatable = false)
  @JsonFormat(pattern = "dd/MM/YYYY")
  @CreatedDate
  protected Date creation;


  /**
   * Indica se um registro da entidade esta ativo ou inativo. Esta flag eh usada para excluir
   * logicamente um registro da entidade quando o mesmo nao puder ser excluido fisicamente
   */
  @Column(name = "active")
  protected boolean active;

}
