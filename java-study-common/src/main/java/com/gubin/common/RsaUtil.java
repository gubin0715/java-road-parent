package com.gubin.common;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.*;

public class RsaUtil {
    //要加密的数据  
    public static String bobo = "http://blog.csdn.net/bobo0915";
    //加密后的密文数据  
    public static byte[] result;  //需要传输给 接收方 接收方进行解密  

    public static void main(String[] args) throws Exception {
        generateKeyPair();

//    	String path=Thread.currentThread().getContextClassLoader().getResource("").getPath();
//    	System.out.println("path"+path);
//    	String jmq="adcdeg";
//    	String jmh=encrypt(jmq,"jinhua_public1.keystore");
//    	System.out.println("jmh:"+jmh);
////    	String jmh="jmh:MoBXI2Hv0W8kO1p8eXrHSiXO7qnqnnLHb/Muvni4lr/z+2o6BDkxdSD8Mzxz+6wBrIpgeobElxUv+y7bwKSAbXSO3KbeDd81xJ9S5mJgbsGMmRw7TCv352+IVMEDXHPDKHI33QxxYQ578cuQdavYShc6nyrwQTYeN0fw3jEGD/M=";
//    	System.out.println(decrypt(jmh,"jinhua_private1.keystore"));

    }

    private static void generateKeyPair() throws Exception {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        /** RSA算法要求有一个可信任的随机数源 */
        SecureRandom sr = new SecureRandom();
        /** 为RSA算法创建一个KeyPairGenerator对象 */
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        /** 利用上面的随机数据源初始化这个KeyPairGenerator对象 */
        kpg.initialize(2048, sr);
        /** 生成密匙对 */
        KeyPair kp = kpg.generateKeyPair();
        /** 得到公钥 */
        Key publicKey = kp.getPublic();
        System.out.println("publicKey" + publicKey);
        /** 得到私钥 */
        Key privateKey = kp.getPrivate();
        System.out.println("privateKey" + privateKey);

        /** 用对象流将生成的密钥写入文件 */
        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("test_publickey.keystore"));
        ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("test_privatekey.keystore"));
        oos1.writeObject(publicKey);
        oos2.writeObject(privateKey);
        /** 清空缓存，关闭文件输出流 */
        oos1.close();
        oos2.close();
        System.out.println("成功");
    }


    public static String encrypt(String source, String publickey) throws Exception {

        /** 将文件中的公钥对象读出 */
        //source=new String(source.getBytes(),"utf-8");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Thread.currentThread().getContextClassLoader().getResource("").getPath() + publickey));
        //   ObjectInputStream ois = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir")+"\\yd_publickey.keystore"));

        Key key = (Key) ois.readObject();
        ois.close();
        /** 得到Cipher对象来实现对源数据的RSA加密 */
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] b = source.getBytes("utf-8");
        /** 执行加密操作 */
        byte[] b1 = cipher.doFinal(b);
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(b1);
    }

    public static String encrypt2(String source) throws Exception {

        /** 将文件中的公钥对象读出 */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Thread.currentThread().getContextClassLoader().getResource("").getPath() + "yd_publickey.keystore"));
        //  ObjectInputStream ois = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir")+"\\yd_publickey.keystore"));

        Key key = (Key) ois.readObject();
        ois.close();
        /** 得到Cipher对象来实现对源数据的RSA加密 */
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] b = source.getBytes();
        /** 执行加密操作 */
        byte[] b1 = cipher.doFinal(b);
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(b1);

    }

    public static String encrypt3(String source, String publickey) throws Exception {

        /** 将文件中的公钥对象读出 */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Thread.currentThread().getContextClassLoader().getResource("").getPath() + publickey));
        //  ObjectInputStream ois = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir")+"\\yd_publickey.keystore"));

        Key key = (Key) ois.readObject();
        ois.close();
        /** 得到Cipher对象来实现对源数据的RSA加密 */
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] b = source.getBytes();
        /** 执行加密操作 */
        byte[] b1 = cipher.doFinal(b);
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(b1);

    }

    public static String decrypt2(String cryptograph, String privatekey) throws Exception {
        /** 将文件中的私钥对象读出 */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Thread.currentThread().getContextClassLoader().getResource("").getPath() + privatekey));
        Key key = (Key) ois.readObject();
        /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b1 = decoder.decodeBuffer(cryptograph);
        /** 执行解密操作 */
        byte[] b = cipher.doFinal(b1);
        return new String(b);
    }

    /**
     * @param @param  cryptograph
     * @param @param  filename
     * @param @return
     * @param @throws Exception    设定文件
     * @return String    返回类型
     * @throws
     * @Description: TODO(解密)
     * @Title: decrypt
     * @author lanjs
     * @data 2017年9月8日 下午10:32:31
     */
    public static String decrypt3(String cryptograph, String filename) throws Exception {
        /** 将文件中的私钥对象读出 */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                Thread.currentThread().getContextClassLoader().getResource("").getPath() + filename));
        Key key = (Key) ois.readObject();
        /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        Base64 Base64 = new Base64();
        byte[] b1 = Base64.decode(cryptograph);
        /** 执行解密操作 */
        byte[] b = cipher.doFinal(b1);
        return new String(b);
    }

    public static String decrypt(String cryptograph, String privatekey) throws Exception {
        /** 将文件中的私钥对象读出 */
        // cryptograph= new String(cryptograph.getBytes(),"gbk");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Thread.currentThread().getContextClassLoader().getResource("").getPath() + privatekey));
        Key key = (Key) ois.readObject();
        /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b1 = decoder.decodeBuffer(cryptograph);
        /** 执行解密操作 */
        byte[] b = cipher.doFinal(b1);
        //  String b2=new String(b,"gbk");
        return new String(b);
    }


    public static String decrypt3(String cryptograph) throws Exception {
        /** 将文件中的私钥对象读出 */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Thread.currentThread().getContextClassLoader().getResource("").getPath() + "yd_privatekey.keystore"));
        Key key = (Key) ois.readObject();
        /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b1 = decoder.decodeBuffer(cryptograph);
        /** 执行解密操作 */
        byte[] b = cipher.doFinal(b1);
        return new String(b);
    }

    // 分段解密
    public static String decrypt4(String cryptograph, String privatekey) throws Exception {
        /** 将文件中的私钥对象读出 */
        // cryptograph= new String(cryptograph.getBytes(),"gbk");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Thread.currentThread().getContextClassLoader().getResource("").getPath() + privatekey));
        Key key = (Key) ois.readObject();
        /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b1 = decoder.decodeBuffer(new String(cryptograph.getBytes("UTF-8")));
        /** 执行解密操作 */
        //byte[] b = cipher.doFinal(b1);
        byte[] b = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b1.length; i += 256) {
            byte[] doFinal = cipher.doFinal(ArrayUtils.subarray(b1, i, i + 256));
            sb.append(new String(doFinal, "utf-8"));
        }
        return sb.toString();
        //return new String(b);

    }

    // 分段解密
    public static String decrypt5(String cryptograph, String privatekey) throws Exception {
        /** 将文件中的私钥对象读出 */
        // cryptograph= new String(cryptograph.getBytes(),"gbk");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Thread.currentThread().getContextClassLoader().getResource("").getPath() + privatekey));
        Key key = (Key) ois.readObject();
        /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b1 = decoder.decodeBuffer(new String(cryptograph.getBytes("UTF-8")));
        /** 执行解密操作 */
        //byte[] b = cipher.doFinal(b1);
        byte[] b = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b1.length; i += 256) {
            byte[] doFinal = cipher.doFinal(ArrayUtils.subarray(b1, i, i + 256));
            sb.append(new String(doFinal, "utf-8"));
        }
        return sb.toString();
        //return new String(b);

    }
    
/*    public static String gekey(String pathName) throws Exception{
    	
    	  
   	 BufferedReader br = new BufferedReader(new FileReader(pathName));
   	    StringBuffer sb = new StringBuffer();
   	    String line = null;
   	    while((line= br.readLine()) != null) {
   	        sb.append(line);
   	    }
   	    System.out.println(sb.toString());
			return sb.toString();
   }*/
    
/*    public static String gekey2(String pathName) throws Exception{
    	
        FileInputStream fisKey=new FileInputStream(pathName);  
		        ObjectInputStream oisKey =new ObjectInputStream(fisKey);  
		        Key key =(Key)oisKey.readObject();  
		        oisKey.close();  
		        fisKey.close(); 
		        String keyString = Base64.encode(key.getEncoded());  
	      	return keyString;
}*/

    /**
     * @param @param  pathName
     * @param @return
     * @param @throws Exception    设定文件
     * @return String    返回类型
     * @throws
     * @Description: TODO(获取key)
     * @Title: gekey
     * @author lanjs
     * @data 2017年9月8日 下午10:32:48
     */
    public static String gekey(String pathName) throws Exception {
        FileInputStream fisKey = new FileInputStream(pathName);
        ObjectInputStream oisKey = new ObjectInputStream(fisKey);
        Key key = (Key) oisKey.readObject();
        oisKey.close();
        fisKey.close();
        Base64 Base64 = new Base64();
        String keyString = new String(Base64.encode(key.getEncoded()));
        return keyString;
    }

    /**
     * @param @param  pathName
     * @param @return
     * @param @throws Exception    设定文件
     * @return String    返回类型
     * @throws
     * @Description: TODO(获取key)
     * @Title: gekey
     * @author lanjs
     * @data 2017年9月8日 下午10:32:48
     */
    public static String gekeyYuan(String pathName) throws Exception {
        FileInputStream fisKey = new FileInputStream(pathName);
        ObjectInputStream oisKey = new ObjectInputStream(fisKey);
        Key key = (Key) oisKey.readObject();
        oisKey.close();
        fisKey.close();
        BASE64Encoder encoder = new BASE64Encoder();
        String keyString = new String(encoder.encode(key.getEncoded()));
        return keyString;
    }


    /**
     * @param @param  source
     * @param @param  filename
     * @param @return
     * @param @throws Exception    设定文件
     * @return String    返回类型
     * @throws
     * @Description: TODO(加密)
     * @Title: encrypt
     * @author lanjs
     * @data 2017年9月8日 下午10:32:16
     */
    public static String encrypt4(String source, String filename) throws Exception {
        String t = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        /** 将文件中的公钥对象读出 */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                Thread.currentThread().getContextClassLoader().getResource("").getPath() + filename));
        Key key = (Key) ois.readObject();
        ois.close();
        /** 得到Cipher对象来实现对源数据的RSA加密 */
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] b = source.getBytes("UTF-8");
        /** 执行加密操作 */
        byte[] b1 = cipher.doFinal(b);
        Base64 Base64 = new Base64();
        return new String(Base64.encode(b1));
    }

    // 分段加密
    public static String encrypt5(String source, String publickey) throws Exception {

        /** 将文件中的公钥对象读出 */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Thread.currentThread().getContextClassLoader().getResource("").getPath() + publickey));

        Key key = (Key) ois.readObject();
        ois.close();
        /** 得到Cipher对象来实现对源数据的RSA加密 */
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] b = source.getBytes("UTF-8");
        byte[] b1 = null;
        StringBuilder sb = new StringBuilder();
        /** 执行加密操作 */
        for (int i = 0; i < b.length; i += 128) {
            // 注意要使用2的倍数，否则会出现加密后的内容再解密时为乱码
            byte[] doFinal = cipher.doFinal(ArrayUtils.subarray(b, i, i + 128));
            sb.append(new String(doFinal));
            b1 = ArrayUtils.addAll(b1, doFinal);
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(b1);

    }

    // 分段加密
    public static String encrypt6(String source, String publickey) throws Exception {

        /** 将文件中的公钥对象读出 */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Thread.currentThread().getContextClassLoader().getResource("").getPath() + publickey));

        Key key = (Key) ois.readObject();
        ois.close();
        /** 得到Cipher对象来实现对源数据的RSA加密 */
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] b = source.getBytes("UTF-8");
        byte[] b1 = null;
        StringBuilder sb = new StringBuilder();
        /** 执行加密操作 */
        for (int i = 0; i < b.length; i += 128) {
            // 注意要使用2的倍数，否则会出现加密后的内容再解密时为乱码
            byte[] doFinal = cipher.doFinal(ArrayUtils.subarray(b, i, i + 128));
            sb.append(new String(doFinal));
            b1 = ArrayUtils.addAll(b1, doFinal);
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(b1);

    }

}
