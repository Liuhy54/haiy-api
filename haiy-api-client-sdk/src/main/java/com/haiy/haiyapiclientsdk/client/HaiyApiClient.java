package com.haiy.haiyapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.haiy.haiyapiclientsdk.model.User;

import java.util.HashMap;
import java.util.Map;

import static com.haiy.haiyapiclientsdk.utils.SignUtils.genSign;

/**
 * 调用第三方接口的客户端
 *
 * @author haiy
 */
public class HaiyApiClient {
    private  String accessKey;

    private  String secretKey;

    public HaiyApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result3 = HttpUtil.get("http://localhost:8123/api/name/", paramMap);
        System.out.println(result3);
        return result3;
    }

    public String getNameByPost(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result3 = HttpUtil.post("http://localhost:8123/api/name/", paramMap);
        System.out.println(result3);
        return result3;
    }


    private Map<String, String> getHeaderMap(String body) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        //不能直接发送
//        hashMap.put("secretKey", secretKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body", body);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() ));
        hashMap.put("sign", genSign(body,secretKey));
        return hashMap;
    }
    public String getUserNameByPost(User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post("http://localhost:8123/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        System.out.println(httpResponse.body());
        return httpResponse.body();
    }
}
