package com.pinkyLam.blog.dao;

import com.pinkyLam.blog.entity.Article;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年7月12日 下午5:28:41
 */

@Repository
public interface ArticleDao extends JpaRepository<Article, Long> {

	Page<Article> findArticleById(Long id, Pageable pageable);
}
