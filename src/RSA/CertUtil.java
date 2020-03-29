package RSA;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/**
 * @Author: zxx
 * @Date: 2020/3/26 17:03
 * @Description: 证书加载
 */
public class CertUtil {

    /**
     * 获取私钥
     * @param keyStorePath
     * @param password
     * @param alias
     * @return
     * @throws Exception
     */
    private static PrivateKey getPrivateKeyByKeyStore(String keyStorePath, String password, String alias) throws Exception {
        KeyStore ks = getKeyStore(keyStorePath,password);
        return (PrivateKey) ks.getKey(alias,password.toCharArray());
    }
    /**
     * 获取公钥
     * @param keyStorePath
     * @param password
     * @param alias
     * @return
     * @throws Exception
     */
    private static PublicKey getPublicKeyByKeyStore(String keyStorePath, String password, String alias) throws Exception {
        Certificate certificate = getCertificate(keyStorePath);
        return certificate.getPublicKey();
    }

    /**
     * 获取Certificate
     * @param keyStorePath
     * @return
     */
    private static Certificate getCertificate(String keyStorePath) throws Exception {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        FileInputStream inputStream = new FileInputStream(keyStorePath);
        Certificate certificate = certificateFactory.generateCertificate(inputStream);
        inputStream.close();
        return certificate;
    }

    /**
     * 获得KeyStore
     * @param keyStorePath
     * @param password
     * @return
     */
    private static KeyStore getKeyStore(String keyStorePath, String password) throws Exception {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        FileInputStream inputStream = new FileInputStream(keyStorePath);
        keyStore.load(inputStream,password.toCharArray());
        inputStream.close();
        return keyStore;
    }


}
