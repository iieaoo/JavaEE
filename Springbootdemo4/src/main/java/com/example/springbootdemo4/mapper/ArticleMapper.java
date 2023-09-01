package com.example.springbootdemo4.mapper;

import com.example.springbootdemo4.entity.vo.ArticleinfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: ArticleMapper
 * Package: com.example.springbootdemo4.mapper
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/27 14:49
 * Version 1.0
 */
@Mapper
public interface ArticleMapper {

    ArticleinfoVO getById(@Param("id") Integer id);

}
