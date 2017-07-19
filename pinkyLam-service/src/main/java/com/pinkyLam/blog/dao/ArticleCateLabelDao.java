package com.pinkyLam.blog.dao;

import com.pinkyLam.blog.entity.ArticleCateLabel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年7月14日 上午10:02:47
 */

@Repository
public interface ArticleCateLabelDao extends JpaRepository<ArticleCateLabel, Long> {


	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(nativeQuery = true, value = "DELETE FROM ARTICLE_CATE_LABEL WHERE ARTICLE_ID=:articleId AND CATE_LABEL_ID NOT IN:cateLabelId")
	int deleteArticleCateLabel(@Param("articleId") Long articleId, @Param("cateLabelId") List<Long> cateLabelIds);

	public ArticleCateLabel findArticleCateLabelByCateLabelId(Long cateLabelId);

}
