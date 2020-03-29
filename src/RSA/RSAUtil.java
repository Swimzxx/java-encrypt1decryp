package RSA;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zxx
 * @Date: 2020/3/26 10:30
 * @Description: RSA加密解密
 * 注意：大部分情况下约定的是公钥加密，私钥解密
 */
public class RSAUtil {

    /**
     * 算法常量： RSA
     */
    private static final String ALGORITHM_RSA = "RSA";
    /**
     * 公钥
     */
    private static final String PUBLICKEY = "RSAPublicKey";
    /**
     * 私钥
     */
    private static final String PRIVATEKEY = "RSAPrivateKey";
    /**
     * RSA密钥长度
     */
    private static final int KEY_SIZE = 1024;

    /**
     * 公钥加密
     * @return
     */
    public static byte[] encryptByPublicKey(byte[] data, byte[] key){
        byte[] rbyte = null;
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
            //获取公钥
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            //加密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE,publicKey);
            rbyte = cipher.doFinal(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rbyte;
    }

    /**
     * 公钥解密
     * @return
     */
    public static byte[] decryptByPublicKey(byte[] data, byte[] key){
        byte[] rbyte = null;
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
            //获取公钥
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            //加密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE,publicKey);
            rbyte = cipher.doFinal(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rbyte;
    }

    /**
     * 私钥加密
     * @return
     */
    public static byte[] encryptByPrivateKey(byte[] data, byte[] key){
        byte[] rbyte = null;
        try {
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(key);
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
            //获取公钥
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            //加密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE,privateKey);
            rbyte = cipher.doFinal(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rbyte;
    }

    /**
     * 私钥解密
     * @return
     */
    public static byte[] decryptByPrivateKey(byte[] data, byte[] key){
        byte[] rbyte = null;
        try {
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(key);
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
            //获取公钥
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            //加密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE,privateKey);
            rbyte = cipher.doFinal(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rbyte;
    }

    /**
     * 获取公钥
     * @return
     */
    public static byte[] getPublicKey(Map<String,Object> keyMap){
        Key key =(Key) keyMap.get(PUBLICKEY);
        return key.getEncoded();
    }

    /**
     * 获取私钥
     * @return
     */
    public static byte[] getPrivateKey(Map<String,Object> keyMap){
        Key key =(Key) keyMap.get(PRIVATEKEY);
        return key.getEncoded();
    }

    /**
     * 初始化密钥
     * @return
     */
    public static Map<String,Object> initKey(){
        Map<String,Object> keyMap = null;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM_RSA);
            keyPairGenerator.initialize(KEY_SIZE);
            //生成密钥对
            KeyPair keyPair = keyPairGenerator.genKeyPair();
            //获取公钥和私钥
            RSAPublicKey publicKey =(RSAPublicKey) keyPair.getPublic();
            RSAPrivateKey privateKey =(RSAPrivateKey) keyPair.getPrivate();
            //公钥和私钥放到Map中
            keyMap = new HashMap<>(2);
            keyMap.put(PUBLICKEY,publicKey);
            keyMap.put(PRIVATEKEY,privateKey);
        }catch (Exception e){
            e.printStackTrace();
        }
        return keyMap;
    }


}
