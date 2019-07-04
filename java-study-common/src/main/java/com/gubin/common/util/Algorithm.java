package com.gubin.common.util;


import java.security.MessageDigest;

/**
 * 算法封装类库
 */
public class Algorithm {

    /**
     * MD5 加密算法.
     *
     * @param text 加密内容.
     * @return 签名结果.
     */
    public static String md5Encryption(String text) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(text.getBytes("UTF-8"));
            byte[] resultByte = messageDigest.digest();
            int value = 256;
            int size = 16;

            StringBuilder resultBuffer = new StringBuilder();
            for (byte temp : resultByte) {
                int v = (int) temp;
                if (temp < 0) {
                    v += value;
                } else if (temp < size) {
                    resultBuffer.append("0");
                }
                resultBuffer.append(Integer.toHexString(v));
            }
            String result = resultBuffer.toString();
            return result.isEmpty() ? null : result.toUpperCase();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }


}
