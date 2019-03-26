package com.gubin.api.controller;

import com.gubin.common.util.ResultData;
import com.gubin.common.util.ReturnCode;
import com.gubin.common.xml.Body;
import com.gubin.common.xml.Data;
import com.gubin.common.xml.Head;
import com.gubin.common.xml.UserInfos;
import com.thoughtworks.xstream.XStream;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "XmlJxController", description = "xml报文解析")
public class XmlJxController {
    @ApiOperation(value = "xml报文解析", notes = "xml报文解析")
    @RequestMapping(value = "/xmlabout", method = RequestMethod.POST)
    public ResultData xmlabout() {
        ResultData resultData = new ResultData();
        try {
            String responseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<data>\n" +
                    "    <head>\n" +
                    "        <id>3</id>\n" +
                    "        <code>0</code>\n" +
                    "        <msg>成功</msg>\n" +
                    "    </head>\n" +
                    "    <body>\n" +
                    "        <userInfos>\n" +
                    "            <name>张三</name>\n" +
                    "            <phone>15245674567</phone>\n" +
                    "        </userInfos>\n" +
                    "        <userInfos>\n" +
                    "            <name>李四</name>\n" +
                    "            <phone>15878947894</phone>\n" +
                    "        </userInfos>\n" +
                    "    </body>\n" +
                    "</data>";
            XStream xs = new XStream();
            xs.alias("data", Data.class);
            xs.alias("head", Head.class);
            xs.alias("body", Body.class);
            xs.alias("userInfos", UserInfos.class);
            xs.processAnnotations(new Class[]{Data.class, Head.class, Body.class, UserInfos.class});
            Object obj = xs.fromXML(responseXml);
            Data data = (Data) obj;
            xs.processAnnotations(data.getClass());
            System.out.println(xs.toXML(data));
            resultData.setData(data);
            resultData.setCode(ReturnCode.RES_SUCCESS);
            resultData.setMsg("成功！");
        } catch (Exception e) {
            System.out.println(e.toString());
            resultData.setCode(ReturnCode.RES_FAILED);
            resultData.setMsg("失败！");
        }
        return resultData;
    }
}
