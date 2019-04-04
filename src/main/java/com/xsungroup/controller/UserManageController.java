package com.xsungroup.controller;

import com.xsungroup.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: xsungroup.user.interface
 * @description: 用户管理
 * @author: ChenMan
 * @create: 2019-04-04 19:35
 */
@RestController
@RequestMapping(value = "userManage")
public class UserManageController {

  @Autowired
  private UserService userService;

  @GetMapping
  @RequestMapping(value = "findUserList")
  public Page findUserList (HttpServletRequest request, HttpServletResponse response) {
    return userService.findUserList(new Pageable(){
      @Override
      public int getPageNumber() {
        return 1;
      }

      @Override
      public int getPageSize() {
        return 10;
      }

      @Override
      public long getOffset() {
        return 0;
      }

      @Override
      public Sort getSort() {
        return null;
      }

      @Override
      public Pageable next() {
        return null;
      }

      @Override
      public Pageable previousOrFirst() {
        return null;
      }

      @Override
      public Pageable first() {
        return null;
      }

      @Override
      public boolean hasPrevious() {
        return false;
      }
    });
  }
}
