package com.xsungroup.domain.model.base;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * An model, as explained in the DDD book.
 *  
 */
@Data
public abstract class Model<T> implements Serializable {

  private Integer dr;

  private String ts;

  private String createUser;

  private String createTime;

  private String modifyUser;

  private String modifyTime;


  /**
   * compare by identity, not by attributes.
   *
   * @param other The other entity.
   * @return true if the identities are the same, regardless of other attributes.
   */
  public abstract boolean sameIdentityAs(T other);

}
