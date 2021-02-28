package top.xuebuyi.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author xuebuyi
 * @date 2021-01-31 16:01
 */
public class BCryptPasswordEncoderUtils {
    public static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args){
        String password = "123";
        String s = encodePassword(password);
        System.out.println(s);
    }
}
