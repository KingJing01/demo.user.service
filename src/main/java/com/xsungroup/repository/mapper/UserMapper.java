package com.xsungroup.repository.mapper;

import com.xinya.tools.mybatis.page.Page;
import com.xinya.tools.mybatis.page.Pageable;
import com.xsungroup.controller.dto.UserInfoListDto;
import com.xsungroup.controller.vo.UserInfoListVo;
import com.xsungroup.domain.model.user.UserModel;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String pk);

    int insert(UserModel record);

    int insertSelective(UserModel record);

    UserModel selectByPrimaryKey(String pk);

    int updateByPrimaryKeySelective(UserModel record);

    int updateByPrimaryKey(UserModel record);

    /**
     * @Author Chenman
     * @Description  删除
     * @Date 17:04 2019/4/8
     * @Param [pks, currentUserPk, date, ts]
     * @return void
     **/
    void deleteBatch(List<String> pkStrList, String currentUserPk);

    Page<UserInfoListVo> findUserList(Pageable pageable, UserInfoListDto userInfoListDto);

}