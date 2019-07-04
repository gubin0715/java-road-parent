package com.gubin.api.controller;

import com.gubin.common.dto.ResponseDto;
import com.gubin.service.TestHbaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "TestHbaseController", description = "hbase相关")
public class TestHbaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestHbaseService testHbaseService;

    private String hbaseTableName = "testHbase";

    @RequestMapping(value = "/testHbase", method = RequestMethod.POST)
    @ApiOperation(value = "测试hbase")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rowKey", value = "hbase行键", dataType = "string", required = true, paramType = "query"),
            @ApiImplicitParam(name = "data", value = "hbase数据", dataType = "string", required = true, paramType = "query")
    })
    public ResponseDto testHbase(@RequestParam(value = "rowKey",required = true)String rowKey,@RequestParam("data") String data) {
        try {
            //存储
            List<Mutation> datas = new ArrayList<>();
            Put put = new Put(Bytes.toBytes(rowKey));
            put.addColumn(Bytes.toBytes("test"), Bytes.toBytes("userData"), Bytes.toBytes(data));
            datas.add(put);
            List<Mutation> results = testHbaseService.saveOrUpdate(hbaseTableName, datas);
            //查询
            String hbaseData = testHbaseService.findByRow(hbaseTableName,rowKey);
            System.out.println("hbase数据================================"+hbaseData);
            return ResponseDto.SUCCESSDATA(hbaseData);
        } catch (Exception e) {
            logger.error("hbase异常",e);
            return ResponseDto.ERRORMSG("hbase异常");
        }
    }
}
