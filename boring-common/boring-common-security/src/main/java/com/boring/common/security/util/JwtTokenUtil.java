package com.boring.common.security.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: YORKEHAN
 * @Date: 2019-07-07-00:07
 * @Description:
 */
@AllArgsConstructor
public class JwtTokenUtil implements Serializable {

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";

    private final RedisTemplate redisTemplate;


    /**
     * 密钥
     */
//    @Value("${jwt.secret}" )
    public byte[] SECRET = "a74d1ca98ae444d3b83e125cb04".getBytes();

    /**
     * //有效期
     */
    @Value("${jwt.expiration}" )
    private Long expiration;


    /**
     * 从数据声明生成令牌
     *
     * @param payloadMap 数据声明
     * @return 令牌
     */
    public String generateToken(Map<String, Object> payloadMap) {
        Date expirationDate = new Date(System.currentTimeMillis() + expiration * 100000);
        String compact = Jwts.builder().addClaims(payloadMap).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, SECRET).compact();
        return compact;

    }


    /**
     * 保存token
     * @param tokenKey
     * @param val
     * @param time
     */
    public void saveToken(String tokenKey, String val, long time) {
        String tid = tid(tokenKey);
        redisTemplate.opsForValue().set(tid, val, time);
    }

    public String tid(String token){
        Claims claims = getClaimsFromToken(token);
        String tid = (String) claims.get("tid");
        return tid.replace("-","");
    }
    /**
     * 删除token
     * @param key
     */
    public void deleteToken(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    public Boolean validateToken(String token) {
        String tid = tid(token);
        String val = (String) redisTemplate.opsForValue().get(tid);
        if(val!=null){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 生成令牌
     *
     * @param userDetails 用户
     * @return 令牌
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        claims.put("tid", UUID.randomUUID().toString());
        return generateToken(claims);
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 判断令牌是否过期
     *
     * @param token 令牌
     * @return 是否过期
     */
    public Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 刷新令牌
     *
     * @param token 原令牌
     * @return 新令牌
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * 验证令牌
     *
     * @param token       令牌
     * @param userDetails 用户
     * @return 是否有效
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}
