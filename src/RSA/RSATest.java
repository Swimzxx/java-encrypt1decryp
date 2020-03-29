package RSA;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @Author: zxx
 * @Date: 2020/3/26 11:15
 * @Description: RSA算法测试类
 */
public class RSATest {

    private static byte[] publickey;
    private static byte[] privatekey;


    public static void main(String[] args) throws Exception {

        //初始化公钥
        Map<String,Object> keyMap = RSAUtil.initKey();
        publickey = RSAUtil.getPublicKey(keyMap);
        privatekey = RSAUtil.getPrivateKey(keyMap);


        System.out.println("公钥："+Base64.encodeBase64String(publickey)+"\n");
        System.out.println("私钥："+Base64.encodeBase64String(privatekey));

        byte[] data = "这是要加密的数据".getBytes("utf-8");

        //加密
        byte[] endata = RSAUtil.encryptByPublicKey(data,publickey);
        System.out.println(Base64.encodeBase64String(endata));

        //解密
        byte[] dedata = RSAUtil.encryptByPublicKey(data,privatekey);
        System.out.println(Base64.encodeBase64String(dedata));

    }
}
