package com.pinkyLam.blog.dao;

import com.pinkyLam.blog.entity.ArticleCateLabel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年7月14日 上午10:02:47
 */

@Repository
public interface ArticleCateLabelDao extends JpaRepository<ArticleCateLabel, Long> {

	public ArticleCateLabel findArticleCateLabelByCateLabelId(Long cateLabelId);

}
