package sign;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

/**
 * @Author: zxx
 * @Date: 2020/3/24 15:20
 * @Description: Signature 类的使用
 */
public class sign {
    public static void main(String[] args) throws Exception {
        byte[] data = "加签数据data".getBytes();
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
        kpg.initialize(1024);
        KeyPair keypair = kpg.genKeyPair();
        //实例化Signature 类
        Signature signature = Signature.getInstance(kpg.getAlgorithm());
        signature.initSign(keypair.getPrivate());
        signature.update(data);
        byte[] sign = signature.sign();
        System.out.println(new String(sign,"utf-8"));

        signature.initVerify(keypair.getPublic());
        signature.update(data);
        boolean s = signature.verify(sign);
        System.out.println(s);
    }
}
