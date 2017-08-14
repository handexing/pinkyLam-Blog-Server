package com.pinkylam.blog.controller;

import com.pinkylam.blog.dao.ArticleDao;
import com.pinkylam.blog.dao.AttachDao;
import com.pinkylam.blog.vo.ErrorCode;
import com.pinkylam.blog.vo.ExecuteResult;
import com.pinkylam.blog.vo.IndexPanelVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年8月1日 上午11:09:40
 */
@RestController
@RequestMapping("index")
public class IndexController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ArticleDao articleDao;
	@Autowired
	AttachDao attachDao;

	@RequestMapping("getMySelfInfo/{userId}")
	public ExecuteResult<IndexPanelVo> delArticle(@PathVariable Long userId) {
		ExecuteResult<IndexPanelVo> result = new ExecuteResult<>();
		IndexPanelVo panelVo = new IndexPanelVo();
		try {
			int articleCnt = articleDao.getArticleByAuthorIdCnt(userId);
			int writingTime = articleDao.getWritingTimeByAuthorIdCnt(userId);
			int attachCnt = attachDao.getAttachByAuthorIdCnt(userId);
			panelVo.setArticleCnt(articleCnt);
			panelVo.setAttachCnt(attachCnt);
			panelVo.setWritingTime(writingTime);
			// TODO 表还没设计
			panelVo.setCommentCnt(0);
			result.setData(panelVo);
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("", e);
			result.setSuccess(false);
			result.setErrorCode(ErrorCode.EXCEPTION.getErrorCode());
			result.setErrorMsg(ErrorCode.EXCEPTION.getErrorMsg());
		}
		return result;
	}
}
