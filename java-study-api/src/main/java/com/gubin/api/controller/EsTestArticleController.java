package com.gubin.api.controller;

import com.gubin.common.dto.ResponseDto;
import com.gubin.common.entity.Article;
import com.gubin.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@RestController
@Api(value = "EsTestArticleController", description = "测试es搜索引擎")
public class EsTestArticleController {

    @Resource
    private ArticleService articleService;

    @ApiOperation(value = "es获取数据列表")
    @RequestMapping(value = "/articleList", method = RequestMethod.POST)
    public ResponseDto list(@RequestBody(required = false) Article article) {
        try {
            Pageable pageable = new PageRequest(article.getPageIndex(), article.getPageSize());
            Page<Article> page = articleService.findDistinctByTitleContainingOrContentContaining(article.getTitle(), article.getContent(), pageable);
            return ResponseDto.SUCCESSDATA(page.getContent());
        } catch (Exception e) {
            log.error("es数据列表异常", e);
            return ResponseDto.ERRORMSG("es数据列表异常");
        }
    }

    @ApiOperation(value = "es获取所有数据")
    @RequestMapping(value = "/articleAllList", method = RequestMethod.POST)
    public ResponseDto articleAllList() {
        try {
            return ResponseDto.SUCCESSDATA(articleService.findAll());
        } catch (Exception e) {
            log.error("es所有数据列表异常", e);
            return ResponseDto.ERRORMSG("es所有数据列表异常");
        }
    }

    @ApiOperation(value = "es添加数据")
    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public ResponseDto add() {
        try {
            //清除所有数据
            articleService.deleteAll();
            Article article = new Article();
            article.setId((long) 1);
            article.setTitle("《蝶恋花》");
            article.setContent("槛菊愁烟兰泣露，罗幕轻寒，燕子双飞去。明月不谙离恨苦，斜光到晓穿朱户。昨夜西风凋碧树，独上高楼，望尽天涯路。欲寄彩笺兼尺素，山长水阔知何处？");
            article.setCreateTime(new Date());
            article.setUpdateTime(new Date());
            article.setViewCount(678);
            articleService.save(article);
            Article article2 = new Article();
            article2.setId((long) 2);
            article2.setTitle("《蝶恋花》");
            article2.setContent("伫倚危楼风细细，望极春愁，黯黯生天际。草色烟光残照里，无言谁会凭阑意。拟把疏狂图一醉，对酒当歌，强乐还无味。衣带渐宽终不悔，为伊消得人憔悴。");
            article2.setCreateTime(new Date());
            article2.setUpdateTime(new Date());
            article.setViewCount(367);
            articleService.save(article2);
            Article article3 = new Article();
            article3.setId((long) 3);
            article3.setTitle("《青玉案·元夕》");
            article3.setContent("东风夜放花千树，更吹落，星如雨。宝马雕车香满路。凤箫声动，玉壶光转，一夜鱼龙舞。蛾儿雪柳黄金缕，笑语盈盈暗香去。众里寻他千百度，蓦然回首，那人却在，灯火阑珊处。");
            article3.setCreateTime(new Date());
            article3.setUpdateTime(new Date());
            article3.setViewCount(786);
            articleService.save(article3);
            return ResponseDto.SUCCESS();
        } catch (Exception e) {
            log.error("es添加数据异常", e);
            return ResponseDto.ERRORMSG("es添加数据异常");
        }
    }
}
