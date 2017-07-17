package com.pinkylam.blog.controller;

import com.pinkyLam.blog.dao.ArticleDao;
import com.pinkyLam.blog.entity.Article;
import com.pinkyLam.blog.service.ArticleService;
import com.pinkyLam.blog.vo.DateTableJson;
import com.pinkyLam.blog.vo.ErrorCode;
import com.pinkyLam.blog.vo.ExecuteResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年7月13日 上午10:50:17
 */

@RestController
@RequestMapping("article")
public class ArticleController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ArticleService articleService;
	@Autowired
	ArticleDao articleDao;

	@RequestMapping("articleList")
	public DateTableJson articleList(@RequestParam(value = "page") Integer page, Long id, String title) {
		DateTableJson tableJson = new DateTableJson();
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(page, DateTableJson.PAGE_SIZE, sort);
		Page<Article> pageData = null;
		if (StringUtils.isEmpty(title)) {
			pageData = articleDao.findArticleByAuthorId(id, pageable);
		} else {
			pageData = articleDao.findArticleByAuthorIdAndTitleLike(id, title, pageable);
		}

		tableJson.setData(pageData.getContent());
		tableJson.setPageSize(DateTableJson.PAGE_SIZE);
		tableJson.setTotalPageNumber(pageData.getTotalPages());
		return tableJson;
	}

	@RequestMapping("getArticle")
	public ExecuteResult<Article> getArticle(Long id) {
		final ExecuteResult<Article> result = new ExecuteResult<>();
		try {
			Article article = articleDao.findOne(id);
			result.setData(article);
			result.setSuccess(true);
		} catch (final Exception e) {
			logger.error("", e);
			result.setSuccess(false);
			result.setErrorCode(ErrorCode.EXCEPTION.getErrorCode());
			result.setErrorMsg(ErrorCode.EXCEPTION.getErrorMsg());
		}
		return result;
	}

	@RequestMapping("saveArticle")
	public ExecuteResult<Boolean> saveArticle(@RequestBody Article article) {
		final ExecuteResult<Boolean> result = new ExecuteResult<>();
		try {
			articleService.saveArticle(article);
			result.setSuccess(true);
		} catch (final Exception e) {
			logger.error("", e);
			result.setSuccess(false);
			result.setErrorCode(ErrorCode.EXCEPTION.getErrorCode());
			result.setErrorMsg(ErrorCode.EXCEPTION.getErrorMsg());
		}
		return result;
	}

}
