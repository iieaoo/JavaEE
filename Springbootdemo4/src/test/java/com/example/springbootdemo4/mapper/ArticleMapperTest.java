package com.example.springbootdemo4.mapper;

import com.example.springbootdemo4.entity.vo.ArticleinfoVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: ArticleMapperTest
 * Package: com.example.springbootdemo4.mapper
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/27 15:06
 * Version 1.0
 */
@SpringBootTest
class ArticleMapperTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void getById() {
        ArticleinfoVO articleinfoVO = articleMapper.getById(1);
        System.out.println(articleinfoVO);
    }
}