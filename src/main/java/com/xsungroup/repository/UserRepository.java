package com.xsungroup.repository;

import com.xsungroup.domain.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Lilei
 * @Description :
 * @Date : 2019/4/4
 */
public interface UserRepository extends CrudRepository<User,String> {

}
