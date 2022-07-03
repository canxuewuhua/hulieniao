package com.hln.controller;

import com.hln.controller.dto.Person;
import com.hln.service.retry.HttpThirdService;
import com.hln.service.retry.IHttpThirdService;
import com.hln.service.transaction.UserService;
import com.hln.自定义注解案例.ActionLog;
import com.hln.自定义注解案例.练习注解.ApiAuth;
import com.starter.util.DateUtil;
import com.starter.util.MyJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 引入自定义starter 在另外一个项目中的工具类 而且能实现自动读取本项目中配置文件中的信息
 *
 * 另外一个项目的这个工具类需要经过spring扫描 通过clean install在本地仓库中进行生成后
 * 本项目才能引用！！
 */
@RestController
public class StarterController {

    @Autowired
    private DateUtil dateUtil;
    @Autowired
    UserService userService;

    @Autowired
    private MyJsonService myJsonService;

    @Autowired
    private IHttpThirdService iHttpThirdService;

    @GetMapping("/test")
    @ActionLog(module = "支付模块", action = "支付接口")
    public String getTime(){
        return dateUtil.getLocalTime();
    }

    @GetMapping("/config")
    public String getConfig(){
        Person person = new Person();
        person.setAge(22);
        person.setName("张三丰");
        return myJsonService.objectToJson(person);
    }

    @GetMapping("/update")
    public void updateMoney(){
        userService.transfer();
    }

    @GetMapping("/anno")
    @ApiAuth("XMJR")
    public String testAnnotation(){
        return "testAnnotation方法";
    }

    @GetMapping("/third")
    public String thirdHttp() throws Exception {
        return iHttpThirdService.thirdHttp();
    }
}
