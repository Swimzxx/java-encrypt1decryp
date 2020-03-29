package MD5;

import java.math.BigDecimal;

/**
 * @Author: zxx
 * @Date: 2020/3/25 10:39
 * @Description: *
 */
public class MD5Test {
    public static void main(String[] args) {

        String encryptStr = "这是需要加密的数据";

        //MD5Util1
        String data1 = MD5Util1.MD5encrypt(encryptStr);
        String data2 = MD5Util1.MD5encrypt(encryptStr);
        System.out.println(data1.equals(data2));
        System.out.println("data1:"+data1+"\ndata2:"+data2);

        //MD5Util2
        String data3 = MD5Util2.MD5encrypt(encryptStr);
        String data4 = MD5Util2.MD5encrypt(encryptStr);
        System.out.println(data3.equals(data4));
        System.out.println("data3:"+data3+"\ndata4:"+data4);
    }
}
