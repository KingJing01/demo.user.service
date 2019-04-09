package com.xsungroup.controller;

/**
 * @Description : restfull url 统一管理
 * @author : Lilei
 * @Date : 2019/3/14
 */
public interface Url {

    /**
     * 验证码
     */
    String VERIFICATION = "verification/{phone}";
    /**
     * 登陆注册
     */
    String USER_LOGIN = "login";
    String USER_REGISTER = "register";

    String USER_MANAGER_ADDUSER = "addUserInfo";
    String USER_MANAGER_MODIFYUSER = "modifyUserInfo";
    String USER_MANAGER_DELETEUSER = "deleteUserInfo/{pks}";
    String USER_MANAGER_PASSWORD_RESET = "passwordReset";

    String ADDCOMPANY = "addcompany";

    String DELECOMPANY = "delecompany";

    String EDITCOMPANY = "editcompany";

    String SELECTCOMPANY = "selectcompany";

    String DETAILCOMPANY = "detailcompany";

}
