package com.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(value = "首页控制器",tags="首页控制器")
@RestController
public class IndexController {

    @ApiOperation(value = "管理员登录", notes = "参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name="account", required=true, dataType="string", value="账号(手机号码)"),
            @ApiImplicitParam(name="password",required=true, dataType="string", value="密码")
    })
    @GetMapping(value = "aaa")
    public JSONObject index(String account, String password) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("1", "A");
        jsonObject.put("2", "B");
        jsonObject.put("3", "C");
        return jsonObject;
    }
}
