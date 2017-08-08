package com.pinkylam.blog.controller;

import com.pinkyLam.blog.dao.MemoRemindDao;
import com.pinkyLam.blog.entity.MemoRemind;
import com.pinkyLam.blog.vo.ErrorCode;
import com.pinkyLam.blog.vo.ExecuteResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年8月8日 下午1:52:49
 */
@RestController
@RequestMapping("remind")
public class MemoRemindController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MemoRemindDao memoRemindDao;

	@RequestMapping("getMemoRemindList/{authorId}")
	public ExecuteResult<List<MemoRemind>> getMemoRemindList(@PathVariable Long authorId) {
		final ExecuteResult<List<MemoRemind>> result = new ExecuteResult<>();
		try {
			List<MemoRemind> list = memoRemindDao.findMemoRemindByAuthorId(authorId);
			result.setData(list);
			result.setSuccess(true);
		} catch (final Exception e) {
			logger.error("", e);
			result.setSuccess(false);
			result.setErrorCode(ErrorCode.EXCEPTION.getErrorCode());
			result.setErrorMsg(ErrorCode.EXCEPTION.getErrorMsg());
		}
		return result;
	}

	@RequestMapping("saveMemoRemind")
	public ExecuteResult<Boolean> saveMemoRemind(@RequestBody MemoRemind memoRemind) {
		final ExecuteResult<Boolean> result = new ExecuteResult<>();
		try {
			memoRemind.setCreateTime(new Date());
			memoRemindDao.save(memoRemind);
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
