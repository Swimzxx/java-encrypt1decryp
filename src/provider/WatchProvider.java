package provider;

import java.security.Provider;
import java.security.Security;
import java.util.Map;

/**
 * @Author: zxx
 * @Date: 2020/3/17 14:43
 * @Description: 查看本地provider
 */
public class WatchProvider {

    public static void main(String[] args) {

        for (Provider p : Security.getProviders()) {
            System.out.println(p);
            for (Map.Entry entry :p.entrySet()) {
                System.out.println("\t"+entry.getKey());
            }
        }
    }

}
