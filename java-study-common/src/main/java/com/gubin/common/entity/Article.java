package com.gubin.common.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.util.Date;

@Data
@Document(indexName="chuyun",type="article",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
public class Article {
    //文章ID，这里必须为 id
    @Id
    private Long id;
    //标题
    private String title;
    //内容
    private String content;
    //浏览量
    private Integer viewCount;
    //发布时间
    private Date createTime;
    //更新时间
    private Date updateTime;

    private Integer pageIndex=0;
    private Integer pageSize=10;
}
