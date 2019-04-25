package com.oe.account.util;

import com.oe.account.vo.UserVo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author wangwj
 * @data 2019/4/15
 */
public class JwtBuilder {

    public static String buildJwtToken(UserVo userVo) {
        Date now = new Date(System.currentTimeMillis());
        Date expiration = new Date(now.getTime() + 86400000);
        return Jwts.builder()
                .claim("user", userVo)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, "0faccb886fe0432eae4869eb22a3c8e09eb22a3c8e0")
                .compact();
    }
}
