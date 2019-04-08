package com.xsungroup.repository;

import com.xsungroup.domain.model.user.UserModel;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : Lilei
 * @Description :
 * @Date : 2019/4/4
 */
public interface UserRepository extends CrudRepository<UserModel,String> {
}
