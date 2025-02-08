package com.haiy.haiyapiInterface.controller;

import com.haiy.haiyapiclientsdk.model.User;
import com.haiy.haiyapiclientsdk.utils.SignUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

/**
 * 名称 API
 * @author: haiy
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/get")
    public String getNameByGet(String name, HttpServletRequest request) {
        System.out.println(request.getHeader("haiy-head"));
        return "GET 你的名字是："+name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam  String name) {
        return  "POST 你的名字是："+name;
    }

    @PostMapping("/user")
    public String getUserNameByPost(@RequestBody User user, HttpServletRequest request) {
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = request.getHeader("body");
        // todo 实际应该去数据库查询是否已经分配给用户
        if (!accessKey.equals("haiy")){
            throw new RuntimeException("无权限");
        }
        if (Long.parseLong(nonce) > 10000){
            throw new RuntimeException("无权限");
        }
        // 时间不超过当前时间5分钟
        if (System.currentTimeMillis()  - Long.parseLong(timestamp) > 300000){
            throw new RuntimeException("无权限");
        }
        // todo 实际需要从数据库中拿到secretKey
        String serverSign = SignUtils.genSign(body, "abcd");
        if (!sign.equals(serverSign)){
            throw new RuntimeException("无权限");
        }
        // todo 调用成功后次数+1 invokeCount
        String result =  "POST 用户名字是："+ user.getUsername();


        return result;
    }
}
