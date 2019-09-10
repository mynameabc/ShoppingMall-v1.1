package manage.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDTO {

    @NotBlank(message = "登陆账号不能为空")
    @ApiModelProperty(value="登陆账号", name="loginName", required=true)
    private String loginName;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value="密码", name="password", required=true)
    private String password;
}
