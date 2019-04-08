package com.xsungroup.domain.model.base;

import com.xinya.tools.utils.DateUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A value object, as described in the DDD book.
 * 
 */
@Data
public abstract class ValueObject<T> implements Serializable {

  private String pk;

  private Integer dr;

  private String ts;

  private String createUser;
  private Date createTime;
  private String modifyUser;
  private Date modifyTime;
  /**
   * Value objects compare by the values of their attributes, they don't have an identity.
   *
   * @param other The other value object.
   * @return <code>true</code> if the given value object's and this value object's attributes are the same.
   */
  public abstract boolean sameValueAs(T other);

  public ValueObject(){

  }

  public ValueObject(String user){
    Date date = new Date();
    this.setModifyUser(user);
    this.setModifyTime(date);
    this.setCreateUser(user);
    this.setCreateTime(date);
    this.setDr(0);
    this.setTs(DateUtils.get4yMdHmsS(date));
  }


}
