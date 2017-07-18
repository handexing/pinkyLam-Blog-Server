package com.pinkyLam.blog.dao;

import com.pinkyLam.blog.entity.CateLabel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年7月12日 下午2:46:47
 */

@Repository
public interface CateLabelDao extends JpaRepository<CateLabel, Long> {

	@Query("SELECT C FROM ArticleCateLabel AS L,CateLabel AS C WHERE L.articleId=:id AND C.id=L.cateLabelId")
	public List<CateLabel> findCateLabelByArticleId(@Param("id") Long id);

	public CateLabel findCateLabelByNameAndType(String name, Integer type);

	public List<CateLabel> findCateLabelByType(Integer type);

}
