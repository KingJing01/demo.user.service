package com.xsungroup.repository;

import com.xsungroup.domain.model.user.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * @program: xsungroup.user.interface
 * @description: 角色持久层
 * @author: ChenMan
 * @create: 2019-04-08 13:18
 */
public interface RoleRepository extends CrudRepository<Role,String> {

}
