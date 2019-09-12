package manage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import manage.pojo.dto.LoginDTO;
import manage.sys.UserDetail;
import manage.sys.annotation.UserLoginedInfo;
import manage.util.JWTUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags="登陆")
@Slf4j
@RestController
public class LoginController {

    @ApiOperation(value="登陆")
    @PostMapping(value = "/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        log.debug("loginName:" + loginDTO.getLoginName());
        log.debug("password:" + loginDTO.getPassword());
        return JWTUtil.createToken(1314520L);
    }

    @ApiOperation(value="测试")
    @PostMapping(value = "/test")
    public String test(String test, @UserLoginedInfo @ApiIgnore UserDetail userDetail) {
        System.out.println("test:" + userDetail.getAccountId());
        return test;
    }
}
