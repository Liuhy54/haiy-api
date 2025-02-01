package com.haiy.haiyapiInterface;

import com.haiy.haiyapiclientsdk.client.HaiyApiClient;
import com.haiy.haiyapiclientsdk.model.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HaiyApiInterfaceApplicationTests {

    @Resource
    private HaiyApiClient haiyApiClient;

    @Test
    void contextLoads() {
        String result = haiyApiClient.getNameByGet("haiy");
        User user = new User();
        user.setUsername("yhai");
        String userNameByPost = haiyApiClient.getUserNameByPost(user);
        System.out.println(result);
        System.out.println(userNameByPost);
    }

}
