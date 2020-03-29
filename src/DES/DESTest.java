package DES;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * @Author: zxx
 * @Date: 2020/3/25 17:59
 * @Description: DES加密测试
 */
public class DESTest {
    public static void main(String[] args) throws Exception {

        String deskey = "12345678901234567890123456789012";
        String desstr = "des要加密的数据";
        byte[] desdatastr = desstr.getBytes("utf-8");

        byte[] desenstr = DESUtil.encrypt(desdatastr,deskey.getBytes("utf-8"));
        System.out.println(Base64.encodeBase64String(desenstr));
        byte[] desdestr = DESUtil.decrypt(desenstr,deskey.getBytes("utf-8"));
        String dess = new String(desdestr,"utf-8");
        System.out.println(dess.toString());


        String key = "123456789012345678901234";
        String str = "3des要加密的数据";
        byte[] datastr = str.getBytes("utf-8");

        byte[] enstr = ThreeDESUtil.encrypt(datastr,key.getBytes("utf-8"));
        System.out.println(Base64.encodeBase64String(enstr));
        byte[] destr = ThreeDESUtil.decrypt(enstr,key.getBytes("utf-8"));
        String s = new String(destr,"utf-8");
        System.out.println(s.toString());
    }
}
