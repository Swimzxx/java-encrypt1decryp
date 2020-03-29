package MD5;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Author: zxx
 * @Date: 2020/3/25 10:33
 * @Description: MD5加密,使用apache.commons.codec包提供的算法
 */
public class MD5Util2 {

    public static final String MD5encrypt(String enstr){
        return DigestUtils.md5Hex(enstr);
    }



}
