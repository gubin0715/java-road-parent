package com.gubin.api.config.swagger;

/**
 * 功能描述:
 * 操作方法的类型
 *
 * @author: wuxia
 * @date: 11:43 2018/6/4
 */
public enum OperationType {
    ADD("添加"), UPDATE("修改更新"), DELETE("删除"), QUERY("查询"), ADD_UPDATE("添加或更新");
    public String actionType;

    OperationType(String actionType) {
        this.actionType = actionType;
    }
}
