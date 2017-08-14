package com.pinkylam.blog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pinkylam.blog.entity.CateLabel;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年7月12日 下午2:46:47
 */

@Repository
public interface CateLabelDao extends JpaRepository<CateLabel, Long> {

	@Query("SELECT C FROM ArticleCateLabel AS L,CateLabel AS C WHERE L.articleId=:id AND C.id=L.cateLabelId")
	public List<CateLabel> findCateLabelByArticleId(@Param("id") Long id);

	@Query("SELECT C FROM ArticleCateLabel AS L,CateLabel AS C WHERE L.articleId=:id AND C.id=L.cateLabelId and C.type=:type and C.name=:name")
	public CateLabel findCateLabelByArticleIdAndTypeAndTypeName(@Param("id") Long id, @Param("type") Integer type,
			@Param("name") String name);

	public CateLabel findCateLabelByNameAndType(String name, Integer type);

	public List<CateLabel> findCateLabelByType(Integer type);

}
