package com.pinkyLam.blog.service;

import com.pinkyLam.blog.dao.ArticleDao;
import com.pinkyLam.blog.entity.Article;
import com.pinkyLam.blog.entity.CateLabel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import javax.transaction.Transactional;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年7月12日 下午5:30:05
 */

@Service
public class ArticleService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ArticleDao articleDao;
	@Autowired
	CateLabelService cateLabelService;

	@Transactional
	public void saveArticle(Article article) {
		article.setCreateTime(new Date());
		article.setStatus(Article.ARTICLE_DRAFT);
		article.setHits(0);
		article = articleDao.save(article);

		String[] tags = article.getTag().split(",");

		for (int i = 0; i < tags.length; i++) {
			cateLabelService.save(CateLabel.LABEL_TYPE, tags[i]);
		}

	}

}
