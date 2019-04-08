package com.xsungroup.controller;

/**
 * @author : Lilei
 * @Description : url
 * @Date : 2019/3/14
 */
public interface Url {

   String VERIFICATION = "verification/{phone}";
  String USER_MANAGER_ADDUSER = "addUserInfo";
  String USER_MANAGER_MODIFYUSER = "modifyUserInfo";
  String USER_MANAGER_DELETEUSER = "deleteUserInfo/{pks}";
  String USER_MANAGER_PASSWORD_RESET = "passwordReset";

}
