package manage.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户登陆后信息")
public class UserDetail {

    @ApiModelProperty("账号ID")
    private long accountId;

    @ApiModelProperty("登陆账号")
    private String loginName;

    @ApiModelProperty("呢称")
    private String nickName;

    @ApiModelProperty("Token")
    private String token;

    @ApiModelProperty("账号身份")
    private String identity;

    @ApiModelProperty("权限字符串")
    private List<String> permissionList;
}
