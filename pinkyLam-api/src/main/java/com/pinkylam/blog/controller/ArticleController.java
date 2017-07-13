package com.pinkylam.blog.controller;

import com.pinkyLam.blog.entity.Article;
import com.pinkyLam.blog.service.ArticleService;
import com.pinkyLam.blog.vo.ErrorCode;
import com.pinkyLam.blog.vo.ExecuteResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
