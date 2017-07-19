package com.pinkyLam.blog.service;

import com.pinkyLam.blog.dao.ArticleCateLabelDao;
import com.pinkyLam.blog.dao.ArticleDao;
import com.pinkyLam.blog.dao.CateLabelDao;
import com.pinkyLam.blog.entity.Article;
import com.pinkyLam.blog.entity.ArticleCateLabel;
import com.pinkyLam.blog.entity.CateLabel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	ArticleCateLabelDao articleCateLabelDao;
	@Autowired
	CateLabelDao cateLabelDao;

	@Transactional
	public void saveArticle(Article article) {
		if (article.getId() != null) {
			Article art = articleDao.getOne(article.getId());
			art.setContent(article.getContent());
			art.setSubtitle(article.getSubtitle());
			art.setTitle(article.getTitle());
			art.setUpdateTime(new Date());

			String[] tags = article.getTag().split(",");

			List<CateLabel> cateLabels = cateLabelDao.findCateLabelByArticleId(article.getId());
			List<Long> cateLabelIds = new ArrayList<>();

			for (CateLabel cateLabel : cateLabels) {
				if (cateLabel.getType() == CateLabel.LABEL_TYPE) {
					for (String tag : tags) {
						if (!cateLabel.getName().equals(tag)) {
							// 验证是否存在
							CateLabel label = cateLabelDao.findCateLabelByArticleIdAndTypeAndTypeName(article.getId(),
									CateLabel.LABEL_TYPE, tag);
							if (label == null) {
								label = cateLabelDao.findCateLabelByNameAndType(tag, CateLabel.LABEL_TYPE);
								if (label != null) {
									saveArticleCateLabel(article, label);
								} else {
									label = new CateLabel(tag, CateLabel.LABEL_TYPE);
									label = cateLabelDao.save(label);
									saveArticleCateLabel(article, label);
								}
							}
						} else {
							cateLabelIds.add(cateLabel.getId());
						}
					}
				}
			}

			article = articleDao.save(art);
			articleCateLabelDao.deleteArticleCateLabel(article.getId(), cateLabelIds);
		} else {
			article.setCreateTime(new Date());
			article.setStatus(Article.ARTICLE_DRAFT);
			article.setHits(0);
			article = articleDao.save(article);

			ArticleCateLabel articleCateLabel = new ArticleCateLabel(article.getId(), article.getCateId());
			articleCateLabelDao.save(articleCateLabel);

			String[] tags = article.getTag().split(",");

			for (String tag : tags) {
				// 验证是否存在
				CateLabel label = cateLabelDao.findCateLabelByNameAndType(tag, CateLabel.LABEL_TYPE);
				if (label != null) {
					articleCateLabel = saveArticleCateLabel(article, label);
					continue;
				}

				label = new CateLabel(tag, CateLabel.LABEL_TYPE);
				label = cateLabelDao.save(label);

				articleCateLabel = saveArticleCateLabel(article, label);

			}
		}

	}


	/**
	 * @Title: saveArticleCateLabel
	 * @Description: 保存标签与文章之间的关系
	 * @param article
	 * @param label
	 * @return ArticleCateLabel
	 */
	private ArticleCateLabel saveArticleCateLabel(Article article, CateLabel label) {
		ArticleCateLabel articleCateLabel = new ArticleCateLabel(article.getId(), label.getId());
		articleCateLabelDao.save(articleCateLabel);
		return articleCateLabel;
	}

}
