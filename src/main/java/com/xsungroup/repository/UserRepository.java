package com.xsungroup.repository;

import com.xsungroup.domain.model.user.UserModel;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : Lilei
 * @Description :
 * @Date : 2019/4/4
 */
public interface UserRepository extends CrudRepository<UserModel,String> {

  /**
   * @Author Chenman
   * @Description  删除用户
   * @Date 15:46 2019/4/6
   * @Param [ids, pk, date, ts]
   * @return void
   **/
  void deleteBatch(List<String> ids,String pk,Date date,String ts);

}
