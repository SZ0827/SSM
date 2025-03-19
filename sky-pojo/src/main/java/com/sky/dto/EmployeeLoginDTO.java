package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
//Spring Boot+Swagger项目中，@ApiModel注解用于标注数据传输对象，帮助API生成更清晰的文档，description属性用于描述该数据传输对象的作用
@ApiModel(description = "员工登录时传递的数据模型")
public class EmployeeLoginDTO implements Serializable {
//    @ApiModelProperty标注这段，添加字段说明
    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

}
