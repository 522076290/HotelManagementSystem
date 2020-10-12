package com.hotel.www.utils;



import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.util.Base64;
import java.util.Base64.Encoder;


/**
 * DES是一种对称加密算法，所谓对称加密算法:加密和解密使用相同的秘钥的算法
 * @author llp
 *
 */
public class DESUtil {
    private static final Logger logger = LoggerFactory.getLogger(DESUtil.class);

    private static Key key;
    //设置秘钥key
    private static String KEY_STR="myKey";
    private static String CHARSETNAME="UTF-8";
    private static String ALGORITHM="DES";

    static{
        try{
            //生成DES算法对象
            KeyGenerator generator=KeyGenerator.getInstance(ALGORITHM);
            //运用SHA1安全策略
            SecureRandom secureRandom=SecureRandom.getInstance("SHA1PRNG");
            //设置上密钥种子
            secureRandom.setSeed(KEY_STR.getBytes());
            //初始化基于SHA1的算法对象
            generator.init(secureRandom);
            //生成密钥对象
            key=generator.generateKey();
            generator=null;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取加密的信息
     * @param str
     * @return
     */
    public static String getEncryptString(String str){
        //基于BASE64编码，接收byte[]并转换成String
        BASE64Encoder base64Encoder=new BASE64Encoder();
        try {
            // 按UTF8编码
            byte[] bytes = str.getBytes(CHARSETNAME);
            // 获取加密对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            // 初始化密码信息
            cipher.init(Cipher.ENCRYPT_MODE, key);
            // 加密
            byte[] doFinal = cipher.doFinal(bytes);
            // byte[]to encode好的String并返回
            return base64Encoder.encode(doFinal);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取解密之后的信息
     *
     * @param str
     * @return
     */
    public static String getDecryptString(String str) {
        // 基于BASE64编码，接收byte[]并转换成String
        BASE64Decoder base64decoder = new BASE64Decoder();
        try {
            // 将字符串decode成byte[]
            byte[] bytes = base64decoder.decodeBuffer(str);
            // 获取解密对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            // 初始化解密信息
            cipher.init(Cipher.DECRYPT_MODE, key);
            // 解密
            byte[] doFinal = cipher.doFinal(bytes);
            // 返回解密之后的信息
            return new String(doFinal, CHARSETNAME);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * BASE64Encoder 加密
     *
     * @param data
     *            要加密的数据
     * @return 加密后的字符串
     */
    public static String encryptBASE64(byte[] data) {
        Encoder encoder = Base64.getEncoder();
        String encode = encoder.encodeToString(data);
        return encode;
    }

    /**
     * BASE64Decoder 解密
     *
     * @param data
     *            要解密的字符串
     * @return 解密后的byte[]
     * @throws Exception
     */
    public static byte[] decryptBASE64(String data) throws Exception {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] buffer = decoder.decode(data);
        return buffer;
    }

}