package com.pinkyLam.blog.dao;

import com.pinkyLam.blog.entity.Article;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年7月12日 下午5:28:41
 */

@Repository
public interface ArticleDao extends JpaRepository<Article, Long> {

	Page<Article> findArticleByAuthorId(Long authorId, Pageable pageable);

	Page<Article> findArticleByAuthorIdAndTitleLike(Long id, String title, Pageable pageable);

	@Query(nativeQuery = true, value = "SELECT COUNT(1) FROM ARTICLE WHERE AUTHOR_ID=:userId")
	public int getArticleByAuthorIdCnt(@Param("userId") Long userId);

	@Query(nativeQuery = true, value = "SELECT * FROM ARTICLE WHERE AUTHOR_ID=:userId ORDER BY CREATE_TIME DESC LIMIT 0,3")
	List<Article> getLatelyArticleList(@Param("userId") Long userId);

	@Query(nativeQuery = true, value = "SELECT SUM(WRITING_TIME) FROM ARTICLE WHERE AUTHOR_ID=:userId")
	public int getWritingTimeByAuthorIdCnt(@Param("userId") Long userId);
}
