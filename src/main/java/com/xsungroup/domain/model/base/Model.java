package com.xsungroup.domain.model.base;

import lombok.Data;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * An model, as explained in the DDD book.
 *  
 */
@Data
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Model<T> implements Serializable {

  @Id
  private String pk;

  private Integer dr;

  private String ts;

  @Column(name = "create_user")
  private String createUser;
  @Column(name = "create_time")
  private Date createTime;
  @Column(name = "modify_user")
  private String modifyUser;
  @Column(name = "modify_time")
  private Date modifyTime;


  /**
   * compare by identity, not by attributes.
   *
   * @param other The other entity.
   * @return true if the identities are the same, regardless of other attributes.
   */
  public abstract boolean sameIdentityAs(T other);

}
