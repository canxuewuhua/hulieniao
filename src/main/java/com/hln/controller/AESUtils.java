package com.hln.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;
import sun.misc.BASE64Encoder;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * import org.apache.commons.codec.binary.Base64;
 * import javax.crypto.Cipher;
 * import javax.crypto.spec.SecretKeySpec;
 * <p>
 * AES 256
 */
@Slf4j
public class AESUtils {

    /**
     * 生成AES加密所需Key的算法
     */
    private static final String KEY_ALGORITHM = "AES";

    /**
     * 加解密算法/工作模式/填充方式,Java6.0支持PKCS5Padding填充方式,BouncyCastle支持PKCS7Padding填充方式
     */
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//默认的加密算法

    /**
     * 加密
     *
     * @param content
     * @param strKey
     * @return
     * @throws Exception
     */
    public static String encrypt(String content, String strKey) throws Exception {
        log.debug("AES加密原文={}", content);
        String csn = Charset.defaultCharset().name();
        log.debug("defaultCharset={}", csn);
        SecretKeySpec skeySpec = getKey(strKey);
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(content.getBytes("utf-8"));
        return Base64.encodeBase64String(encrypted);
    }

    /**
     * 16位字符串秘钥加密
     *
     * @param content
     * @param strKey
     * @return
     * @throws Exception
     */
    public static String encrypt16(String content, String strKey) throws Exception {
        log.debug("AES加密原文={}", content);
        String csn = Charset.defaultCharset().name();
        log.debug("defaultCharset={}", csn);
        SecretKeySpec skeySpec = getKey16(strKey);
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(content.getBytes("utf-8"));
        return Base64.encodeBase64String(encrypted);
    }

    /**
     * 解密
     *
     * @param strKey
     * @param content
     * @return
     * @throws Exception
     */
    public static String decrypt(String content, String strKey) throws Exception {
        SecretKeySpec skeySpec = getKey(strKey);
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] original = cipher.doFinal(Base64.decodeBase64(content));
        return new String(original, "utf-8");//通过Base64转码返回
    }

    /**
     * 16位字符串秘钥
     *
     * @param content
     * @param strKey
     * @return
     * @throws Exception
     */
    public static String decrypt16(String content, String strKey) throws Exception {
        SecretKeySpec skeySpec = getKey16(strKey);
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] original = cipher.doFinal(Base64.decodeBase64(content));
        return new String(original, "utf-8");//通过Base64转码返回
    }

    public static String getKey(int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }

    public static SecretKeySpec getKeySpec(String strKey) throws Exception {
        byte[] arrBTmp = strKey.getBytes("UTF-8");
        byte[] arrB = new byte[16];

        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }
        SecretKeySpec skeySpec = new SecretKeySpec(arrB, "AES");
        return skeySpec;
    }

    public static String encrypt(String message, String key, String vi) {
        try {
            SecretKeySpec keySpec = AESUtils.getKeySpec(key);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(vi.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
            byte[] encrypted = cipher.doFinal(message.getBytes("UTF-8"));
            String encode = new BASE64Encoder().encode(encrypted);
            byte[] bytes = Base64.encodeBase64(encode.getBytes());
            return new String(bytes, "UTF-8");
        } catch (Exception e) {
            log.error("国美AES加密失败，错误信息：{}", e.getMessage(), e);
        }
        return "";
    }

    /**
     * 32位字符串秘钥
     *
     * @param strKey
     * @return
     */
    private static SecretKeySpec getKey(String strKey) {
        byte[] arrBTmp = new byte[0];
        try {
            arrBTmp = strKey.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            log.error("编码异常{}", e.getMessage(), e);
        }
        byte[] arrB = new byte[32]; // 创建一个空的32位字节数组（默认值为0）

        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }

        SecretKeySpec skeySpec = new SecretKeySpec(arrB, KEY_ALGORITHM);

        return skeySpec;
    }

    /**
     * 16位秘钥
     *
     * @param strKey
     * @return
     */
    private static SecretKeySpec getKey16(String strKey) {
        byte[] arrBTmp = new byte[0];
        try {
            arrBTmp = strKey.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            log.error("编码异常{}", e.getMessage(), e);
        }
        byte[] arrB = new byte[16]; // 创建一个空的16位字节数组（默认值为0）

        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }

        SecretKeySpec skeySpec = new SecretKeySpec(arrB, KEY_ALGORITHM);

        return skeySpec;
    }
}
