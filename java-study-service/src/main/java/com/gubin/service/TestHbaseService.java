package com.gubin.service;


import org.apache.hadoop.hbase.client.Mutation;

import java.util.List;

/**
 * <br>
 * 标题: HBase服务<br>
 * 描述: HBase服务<br>
 *
 * @author zc
 * @date 2018/06/21
 */
public interface TestHbaseService<T> {

    /**
     * 查询指定行键的表数据
     *
     * @param tableName 表名
     * @param row       行键
     * @return 数据
     */
    String findByRow(String tableName, String row);

    /**
     * 查询指定行键之间的表数据
     *
     * @param tableName 表名
     * @param startRow  开始行键
     * @param endRow    结束行键
     * @return 数据集合
     */
    List<T> findByStartEndRow(String tableName, String startRow, String endRow);

    /**
     * 保存或修改数据
     *
     * @param tableName 表名
     * @param datas     数据集合
     * @return 数据集合
     */
    List<Mutation> saveOrUpdate(String tableName, List<Mutation> datas);

}