package DES;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * @Author: zxx
 * @Date: 2020/3/25 17:37
 * @Description: *
 */
public class DESUtil {

    /**
     * 算法常量： DES
     */
    private static final String ALGORITHM_DES = "DES";
    /**
     * 加密/解密算法/工作模式/填充方式
     */
    private static final String ALGORITHM_CIPHER = "DES/ECB/PKCS5Padding";

    /**
     * 转换密钥
     * @param key
     * @return
     */
    private static Key toKey(byte[] key){
        SecretKey secretKey = null;
        try {
            //实例化DES密钥材料
            DESKeySpec dks = new DESKeySpec(key);
            //实例化工厂密钥
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM_DES);
            //生成秘密密钥
            secretKey = keyFactory.generateSecret(dks);
        }catch (Exception e){
            e.printStackTrace();
        }
       return  secretKey;
    }

    /**
     * 加密
     * @param data 加密数据
     * @param key 密钥
     * @return
     */
    public static byte[] encrypt(byte[] data,byte[] key){
        byte[] rbyte = null;
        try {
            Key k=toKey(key);
            //加密类实例化
            Cipher cipher=Cipher.getInstance(ALGORITHM_DES);
            cipher.init(Cipher.ENCRYPT_MODE, k);
            //执行加密操作
            rbyte = cipher.doFinal(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rbyte;
    }


    /**
     * 解密
     * @param data 解密数据
     * @param key 密钥
     * @return
     */
    public static byte[] decrypt(byte[] data,byte[] key){
        byte[] rbyte = null;
        try {
            Key k=toKey(key);
            //加密类实例化
            Cipher cipher=Cipher.getInstance(ALGORITHM_DES);
            cipher.init(Cipher.DECRYPT_MODE, k);
            //执行加密操作
            rbyte = cipher.doFinal(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rbyte;
    }


//    /**
//     * 生成密钥
//     * @return
//     */
//    public static byte[] initKey(){
//        byte[] rbyte = null;
//        KeyGenerator keyGenerator =null;
//        try {
//        keyGenerator=KeyGenerator.getInstance(ALGORITHM_CIPHER);
//        keyGenerator.init(56);
////        如果使用64位密钥需要使用Bouncy Castle提供者
////        keyGenerator = KeyGenerator.getInstance(ALGORITHM_CIPHER,"BC");
////        keyGenerator.init(64);
//
//        SecretKey secretKey = keyGenerator.generateKey();
//        rbyte = secretKey.getEncoded();
//        } catch( Exception e) {
//            e.printStackTrace();
//        }
//        return rbyte;
//    }

}
