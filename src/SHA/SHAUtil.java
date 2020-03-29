package SHA;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;


/**
 * @Author: zxx
 * @Date: 2020/3/25 10:33
 * @Description: SHA算法
 *
 */
public class SHAUtil {

    /**
     * 算法常量： SHA1
     */
    private static final String ALGORITHM_SHA1 = "SHA-1";
    /**
     * 算法常量： SHA256
     */
    private static final String ALGORITHM_SHA256 = "SHA-256";

    /**
     * sha1 加密
     * @param enstr
     * @param encoding
     * @return
     */
    public static byte[] sha1(String enstr, String encoding){
        MessageDigest md = null;
        byte[] digest = null;
        try {
            md = MessageDigest.getInstance(ALGORITHM_SHA1);
            md.reset();
            md.update(enstr.getBytes(encoding));
            digest = md.digest();
        } catch (Exception e) {
            System.out.println("sha1加密失败");
        }
        return digest;
    }

    /**
     * sha1计算后进行16进制转换
     * @param data
     * @param encoding
     * @return
     */
    public static byte[] sha1X16(String data, String encoding){
        byte[] bytes = sha1(data, encoding);
        StringBuilder sha1StrBuff = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            if (Integer.toHexString(0xFF & bytes[i]).length() == 1) {
                sha1StrBuff.append("0").append(
                        Integer.toHexString(0xFF & bytes[i]));
            } else {
                sha1StrBuff.append(Integer.toHexString(0xFF & bytes[i]));
            }
        }
        try {
            return sha1StrBuff.toString().getBytes(encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] sha256(String enstr, String encoding){
        MessageDigest md = null;
        byte[] digest = null;
        try {
            md = MessageDigest.getInstance(ALGORITHM_SHA256);
            md.reset();
            md.update(enstr.getBytes(encoding));
            digest = md.digest();
        } catch (Exception e) {
            System.out.println("sha256加密失败");
        }
        return digest;
    }

    /**
     * sha256计算后进行16进制转换
     * @param data
     * @param encoding
     * @return
     */
    public static String sha256X16Str(String data, String encoding) {
        byte[] bytes = sha256(data, encoding);
        StringBuilder sha256StrBuff = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            if (Integer.toHexString(0xFF & bytes[i]).length() == 1) {
                sha256StrBuff.append("0").append(
                        Integer.toHexString(0xFF & bytes[i]));
            } else {
                sha256StrBuff.append(Integer.toHexString(0xFF & bytes[i]));
            }
        }
        return sha256StrBuff.toString();
    }

}
