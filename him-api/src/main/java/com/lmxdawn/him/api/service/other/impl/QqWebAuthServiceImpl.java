package com.lmxdawn.him.api.service.other.impl;

import com.alibaba.fastjson.JSON;
import com.lmxdawn.him.api.service.other.QqWebAuthService;
import com.lmxdawn.him.api.utils.OkHttpUtil;
import com.lmxdawn.him.api.vo.res.QqOpenIdResVO;
import com.lmxdawn.him.api.vo.res.QqUserInfoResVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QqWebAuthServiceImpl implements QqWebAuthService {
    
    
    @Value("${qq.auth.appid}")
    private String appid;
    
    @Value("${qq.auth.appkey}")
    private String appkey;
    
    @Override
    public String getAccessToken(String code, String redirect_uri) {
        Map<String, String> map = new HashMap<>();
        map.put("grant_type", "authorization_code");
        map.put("client_id", appid);
        map.put("client_secret", appkey);
        map.put("code", code);
        map.put("redirect_uri", redirect_uri);
        String url = "https://graph.qq.com/oauth2.0/token";
        String res = OkHttpUtil.get(url, map);
        String[] split = res.split("&");
        return split[0].toString().split("=")[1];
    }
    
    @Override
    public QqOpenIdResVO getOpenID(String accessToken) {
        Map<String, String> map = new HashMap<>();
        map.put("access_token", accessToken);
        String url = "https://graph.qq.com/oauth2.0/me";
        String res = OkHttpUtil.get(url, map);
    
        if (!res.contains("callback")) {
            return null;
        }
    
        int indexOf1 = res.indexOf("(");
        int indexOf2 = res.indexOf(")");
        String json = res.substring(indexOf1, indexOf2);
    
        return JSON.parseObject(json, QqOpenIdResVO.class);
    }
    
    @Override
    public QqUserInfoResVO getUserInfo(String accessToken, String openID) {
        
        Map<String, String> map = new HashMap<>();
        map.put("access_token", accessToken);
        map.put("oauth_consumer_key", appkey);
        map.put("openid", openID);
        String url = "https://graph.qq.com/user/get_user_info";
        String json = OkHttpUtil.get(url, map);
    
        QqUserInfoResVO qqUserInfoResVO = JSON.parseObject(json, QqUserInfoResVO.class);
        
        if (null == qqUserInfoResVO.getRet() || qqUserInfoResVO.getRet() != 0) {
            return null;
        }
        return qqUserInfoResVO;
    }
}
