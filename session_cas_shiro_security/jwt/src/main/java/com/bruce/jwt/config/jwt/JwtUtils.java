package com.bruce.jwt.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bruce.jwt.base.entity.TUser;

public class JwtUtils {

    /**
     * withAudience()存入需要保存在token的信息，这里把用户ID存入token中
    * Algorithm.HMAC256():使用HS256生成token,密钥则是用户的密码，唯一密钥的话可以保存在服务端。
    */
    public static String getToken(TUser user) {
        String token="";
        token= JWT.create().withAudience(user.getUserId())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
