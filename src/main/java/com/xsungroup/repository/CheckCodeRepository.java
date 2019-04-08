package com.xsungroup.repository;

import com.xsungroup.domain.model.basis.CheckCodeModel;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : Lilei
 * @Description :
 * @Date : 2019/4/6
 */
public interface CheckCodeRepository extends CrudRepository<CheckCodeModel,String> {
}
