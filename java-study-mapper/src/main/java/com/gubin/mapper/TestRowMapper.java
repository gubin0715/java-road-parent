package com.gubin.mapper;

import com.gubin.common.entity.UserInfo;
import com.spring4all.spring.boot.starter.hbase.api.RowMapper;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * <br>
 * 标题: 用户表ORM<br>
 * 描述: 用户表ORM<br>
 *
 * @author zc
 * @date 2018/06/21
 */
public class TestRowMapper implements RowMapper<String> {

    private static byte[] FAMILY_Y = "test".getBytes();
    private static byte[] FAMILY_Y_YYSDATA = "userData".getBytes();

    @Override
    public String mapRow(Result result, int i) throws Exception {
        String UserInfo =  Bytes.toString(result.getValue(FAMILY_Y, FAMILY_Y_YYSDATA));
        return UserInfo;
    }
}