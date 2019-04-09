package com.xsungroup.controller.dto;

import com.xinya.tools.req.BaseRequest;
import com.xinya.tools.req.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : Lilei
 * @Description : code验证dto
 * @Date : 2019/4/8
 */
@Data
public class CheckCodeDto extends BaseRequest {

    private String type;

    private String code;

}
