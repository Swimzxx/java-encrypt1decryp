package SHA;

import java.math.BigDecimal;

/**
 * @Author: zxx
 * @Date: 2020/3/25 10:39
 * @Description: SHA算法测试
 */
public class SHATest {

    public static void main(String[] args) {

        String encryptStr = "1234";

        //sha1X16
        String data1 = SHAUtil.sha1X16(encryptStr,"utf-8").toString();
        String data2 = SHAUtil.sha1X16(encryptStr,"utf-8").toString();
        System.out.println(data1.equals(data2));
        System.out.println("data1:"+data1+"\ndata2:"+data2);

        //sha256X16Str
        String data3 = SHAUtil.sha256X16Str(encryptStr,"utf-8").toString();
        String data4 = SHAUtil.sha256X16Str(encryptStr,"utf-8").toString();
        System.out.println(data3.equals(data4));
        System.out.println("data3:"+data3+"\ndata4:"+data4);



    }
}
