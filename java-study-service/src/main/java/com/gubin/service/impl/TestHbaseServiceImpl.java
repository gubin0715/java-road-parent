package com.gubin.service.impl;

import com.gubin.mapper.TestRowMapper;
import com.gubin.service.TestHbaseService;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestHbaseServiceImpl implements TestHbaseService<String> {

    @Autowired
    private HbaseTemplate hbaseTemplate;

    @Override
    public String findByRow(String tableName, String row) {
        return hbaseTemplate.get(tableName, row, new TestRowMapper());
    }

    @Override
    public List<String> findByStartEndRow(String tableName, String startRow, String endRow) {
        Scan scan = new Scan(Bytes.toBytes(startRow), Bytes.toBytes(endRow));
        return hbaseTemplate.find(tableName, scan, new TestRowMapper());
    }

    @Override
    public List<Mutation> saveOrUpdate(String tableName, List<Mutation> datas) {
        hbaseTemplate.saveOrUpdates(tableName, datas);
        return datas;
    }
}
