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
			art.setAuthorId(article.getAuthorId());
			art.setContent(article.getContent());
			art.setCreateTime(article.getCreateTime());
			art.setHits(article.getHits());
			art.setSubtitle(article.getSubtitle());
			art.setTitle(article.getTitle());
			art.setUpdateTime(new Date());
			art.setStatus(article.getStatus());
			// article = articleDao.save(art);

			String[] tags = article.getTag().split(",");

			List<CateLabel> cateLabels = cateLabelDao.findCateLabelByArticleId(article.getId());
			for (String tag : tags) {
				for (CateLabel cateLabel : cateLabels) {
					if (cateLabel.getType() == CateLabel.LABEL_TYPE) {
						if (cateLabel.getName().equals(tag)) {
							continue;
						}
						// System.out.println(tag);
					}
				}
			}

		} else {
			article.setCreateTime(new Date());
			article.setStatus(Article.ARTICLE_DRAFT);
			article.setHits(0);
			article = articleDao.save(article);

			ArticleCateLabel articleCateLabel = new ArticleCateLabel();
			articleCateLabel.setArticleId(article.getId());
			articleCateLabel.setCateLabelId(article.getCateId());
			articleCateLabelDao.save(articleCateLabel);

			String[] tags = article.getTag().split(",");

			for (int i = 0; i < tags.length; i++) {

				// 验证是否存在
				CateLabel label = cateLabelDao.findCateLabelByNameAndType(tags[i], CateLabel.LABEL_TYPE);
				if (label != null) {
					articleCateLabel = saveArticleCateLabel(article, label);
					continue;
				}

				CateLabel cateLabel = new CateLabel();
				cateLabel.setName(tags[i]);
				cateLabel.setRemark("");
				cateLabel.setType(CateLabel.LABEL_TYPE);
				label = cateLabelDao.save(cateLabel);

				articleCateLabel = saveArticleCateLabel(article, label);
			}
		}

	}

	/**
	 * @Title: saveArticleCateLabel @Description: 保存标签与文章之间的关系 @param @param
	 *         article @param @param label @param @return @return
	 *         ArticleCateLabel @throws
	 */
	private ArticleCateLabel saveArticleCateLabel(Article article, CateLabel label) {
		ArticleCateLabel articleCateLabel;
		articleCateLabel = new ArticleCateLabel();
		articleCateLabel.setArticleId(article.getId());
		articleCateLabel.setCateLabelId(label.getId());
		articleCateLabelDao.save(articleCateLabel);
		return articleCateLabel;
	}

}
