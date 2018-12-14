package com.gubin.common;


import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class JdkBase64Util {


    public static String jdkBas64Encode1(String src) {
        return new String(new Base64().encode(src.getBytes()));
    }

    public static String jdkBas64Decode1(String encodeData) {

        return new String(new Base64().decode(encodeData));
    }


    // jdk base64加密 sun.misc
    public static String jdkBas64Encode(String src) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(src.getBytes());
    }


    // jdk base64解秘 sun.misc  
    public static String jdkBas64Decode(String encodeData) {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        try {
            return new String(base64Decoder.decodeBuffer(encodeData));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
