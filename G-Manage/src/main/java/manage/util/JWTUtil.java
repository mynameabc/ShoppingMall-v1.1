package manage.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

public class JWTUtil {

    // 过期时间 7 天
    private static final long EXPIRE_TIME = 7 * 60 * 24 * 60 * 1000;
    // 密钥
    private static final String SECRET = "CWGJ@CWGJ";

    public static final String ACCOUNT_ID = "accountId";

    private static final String BEARER_TOKEN = "Bearer ";

    public static final String TOKEN = "Authorization";


    /**
     * 生成 token, 5min后过期
     *
     * @param accountId 用户Id
     * @return 加密的token
     */
    public static String createToken(long accountId) {
        return BEARER_TOKEN + JWT.create()
                .withClaim(ACCOUNT_ID, accountId)
                //到期时间
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                //创建一个新的JWT，并使用给定的算法进行标记
                .sign(getAlgorithm());
    }

    /**
     * 校验 token 是否正确
     *
     * @param token     密钥
     * @param accountId 用户Id
     * @return 是否正确
     */
    public static boolean verify(String token, long accountId) {
        try {
            //在token中附带了username信息
            JWTVerifier verifier = JWT.require(getAlgorithm())
                    .withClaim(ACCOUNT_ID, accountId)
                    .build();
            //验证 token
            verifier.verify(token.replace(BEARER_TOKEN, ""));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    private static Algorithm getAlgorithm() {
        return Algorithm.HMAC256(SECRET);
    }

    /**
     * 获得token中的信息，无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static Long getAccountId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token.replace(BEARER_TOKEN, ""));
            return jwt.getClaim(ACCOUNT_ID).asLong();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 解析jwt
     *
     * @param jwt
     * @return
     */
    public static Map<String, Claim> processJwt(String jwt) {
        return JWT.require(getAlgorithm())
                .build()
                .verify(jwt.replace(BEARER_TOKEN, ""))
                .getClaims();
    }

    public static Long processJwt2Id(DecodedJWT decodedJWT) {
        return decodedJWT.getClaim(ACCOUNT_ID).asLong();
    }

    public static Long processJwt2Id(String jwt) {
        Map<String, Claim> maps = processJwt(jwt);
        return maps.get(ACCOUNT_ID).asLong();
    }

    public static DecodedJWT getDecodedJWT(String token) {
        return JWT.require(getAlgorithm()).build().verify(token.replace(BEARER_TOKEN, ""));
    }

    public static void main(String args[]) {

        String token = JWTUtil.createToken(1);
        System.out.println(token);
        boolean isvalue = JWTUtil.verify(token, 1);
        System.out.println(isvalue);

        Long userId = JWTUtil.getAccountId(token);
        System.out.println(userId);

    }
}
