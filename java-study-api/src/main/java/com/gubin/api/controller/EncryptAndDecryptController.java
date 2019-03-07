package com.gubin.api.controller;

import com.gubin.common.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "EncryptAndDecryptController", description = "加密解密编码")
public class EncryptAndDecryptController {

    @ApiOperation(value = "Rsa、HMAC-SHA1加密，Base64、url编码", notes = "Rsa、HMAC-SHA1加密，Base64、url编码")
    @RequestMapping(value = "/encryptAndDecrypt", method = RequestMethod.POST)
    public ResultData encryptanddecrypt() {
        ResultData resultData = new ResultData();
        try {
            /**
             * Rsa加密解密
             */
            String data = "nswdwy";
            System.out.println("===========Rsa加密前===========" + data);
            data = RsaUtil.encrypt(data, "test_publickey.keystore");
            System.out.println("===========Rsa加密后===========" + data);
            data = RsaUtil.decrypt(data, "test_privatekey.keystore");
            System.out.println("===========Rsa解密后===========" + data);
            /**
             * HMAC-SHA1加密
             */
            String data1 = "nswdwy";
            System.out.println("============HMAC-SHAI加密前=============" + data1);
            //获取公钥路径
            String pathname = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "test_publickey.keystore";
            //获取公钥key
            String key = RsaUtil.gekeyYuan(pathname);
            //格式化key
            if (key != null) {
                key = key.replaceAll("\r|\n", "");
            }
            data1 = Hmac_Sha1Util.getSignature(data, key);
            System.out.println("============HMAC-SHAI加密后=============" + data1);
            /**
             * url编码
             */
            String data2 = "nswdwy";
            System.out.println("=============url编码前=============" + data2);
            data2 = java.net.URLEncoder.encode(data, "UTF-8");
            System.out.println("=============url编码后=============" + data2);
            /**
             * Base64编码
             */
            String data3 = "nswdwy";
            System.out.println("==============Base64编码前=============" + data3);
            data3 = JdkBase64Util.jdkBas64Encode(data3);
            System.out.println("==============Base64编码后=============" + data3);
            resultData.setMsg("成功！");
            resultData.setCode(ReturnCode.RES_SUCCESS);
        } catch (Exception e) {
            System.out.println(e.toString());
            resultData.setCode(ReturnCode.RES_FAILED);
            resultData.setMsg("失败！");
        }
        return resultData;
    }
}
