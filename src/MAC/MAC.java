package MAC;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: zxx
 * @Date: 2020/3/25 17:05
 * @Description: MAC是带有密钥的消息摘要算法
 * 思路：
 * 1，构建密钥
 * 2，执行消息摘要
 */
public class MAC {

    /**
     * 算法常量： HmacMD5
     */
    private static final String ALGORITHM_HMACMD5 = "HmacMD5";

    public static byte[] initHmacMD5Key() {
        byte[] tbyte = null;
        //初始化KeyGenerator
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator=KeyGenerator.getInstance(ALGORITHM_HMACMD5);
            //产生密钥
            SecretKey secretKey = keyGenerator.generateKey();
            //获取密钥
            tbyte = secretKey.getEncoded();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return tbyte;
    }

    /**
     * HmacMD5
     * @param data
     * @param key
     * @return
     */
    public static byte[] HmacMD5(byte[] data,byte[] key){
        byte[] rbyte = null;
        try {
            //还原密钥
            SecretKey secretKey = new SecretKeySpec(key,ALGORITHM_HMACMD5);
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            rbyte = mac.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rbyte;
    }

    public static void main(String[] args) throws Exception {
        String str = "要加密的数据";
        byte[] key = MAC.initHmacMD5Key();
        String data1 = MAC.HmacMD5(str.getBytes("utf-8"),key).toString();
        String data2 = MAC.HmacMD5(str.getBytes("utf-8"),key).toString();
        System.out.println(data1.equals(data2));
        System.out.println("data1:"+data1+"\ndata2:"+data2);
    }

}
