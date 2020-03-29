package MD5;

import org.apache.commons.codec.binary.Hex;

import java.math.BigInteger;
import java.security.MessageDigest;


/**
 * @Author: zxx
 * @Date: 2020/3/25 10:33
 * @Description: MD5加密
 */
public class MD5Util1 {

    public static String MD5encrypt(String enstr){
        String resultstr = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(enstr.getBytes("utf-8"));
            byte[] digest = md.digest();
            resultstr = new String(Hex.encodeHex(digest));
        } catch (Exception e) {
            System.out.println("加密失败");
        }
        return resultstr;
    }

}
