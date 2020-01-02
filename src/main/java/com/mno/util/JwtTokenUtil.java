/**
 * FileName: JwtTokenUtil
 * Author:   10418
 * Date:     2019-07-30 21:00
 * Description: 生成令牌，验证等等一些操作
 * History:
 * <author>          <time>          <version>          <desc>
 * 牛楠楠
 */
package com.mno.util;

import com.mno.config.TokenConfig;
import com.mno.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈生成令牌，验证等等一些操作〉
 *
 * @author 10418
 * @create 2019-07-30
 * @since 1.0.0
 */
//读取配置文件以 "jwt" 前缀的配置信息。


public class JwtTokenUtil {
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    private static final String CLAIM_KEY_ROLE = "role";
    private static final String CLAIM_KEY_USERID = "userId";

    public static String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public static long getUserIdFromToken(String token) {
        long userId;
        try {
            final Claims claims = getClaimsFromToken(token);
            userId = Long.parseLong(claims.get(CLAIM_KEY_USERID).toString());
        } catch (Exception e) {
            e.printStackTrace();
            userId = 0;
        }
        return userId;
    }

    public static Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

    public static Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    private static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(TokenConfig.SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            claims = null;
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private static Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + TokenConfig.EXPIRATION_TIME * 1000);
    }

    private static Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private static Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    public static String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, user.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        claims.put(CLAIM_KEY_ROLE, user.getRole());
        claims.put(CLAIM_KEY_USERID, (user.getId()));
        return generateToken(claims);
    }

    static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, TokenConfig.SECRET)
                .compact();
    }

    public static Boolean canTokenBeRefreshed(String token) {
        return !isTokenExpired(token);
    }

    public static String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
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
    public static Boolean validateToken(String token, User user) {
        final String username = getUsernameFromToken(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }
}
