package com.pinkylam.blog.controller;

import com.pinkyLam.blog.dao.CateLabelDao;
import com.pinkyLam.blog.entity.CateLabel;
import com.pinkyLam.blog.service.CateLabelService;
import com.pinkyLam.blog.vo.ErrorCode;
import com.pinkyLam.blog.vo.ExecuteResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年7月12日 下午2:40:04
 */

@RestController
@RequestMapping("cateLabel")
public class CateLabelController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CateLabelDao cateLabelDao;
	@Autowired
	CateLabelService cateLabelService;

	@RequestMapping("getCateLabelList/{type}")
	public ExecuteResult<List<CateLabel>> getCateLabelList(@PathVariable Integer type) {
		ExecuteResult<List<CateLabel>> result = new ExecuteResult<>();
		try {
			List<CateLabel> list = cateLabelDao.findCateLabelByType(type);
			result.setData(list);
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("", e);
			result.setSuccess(false);
			result.setErrorCode(ErrorCode.EXCEPTION.getErrorCode());
			result.setErrorMsg(ErrorCode.EXCEPTION.getErrorMsg());
		}
		return result;
	}

	@RequestMapping("save/{type}/{name}")
	public ExecuteResult<Integer> save(@PathVariable Integer type, @PathVariable String name) {
		ExecuteResult<Integer> result = new ExecuteResult<>();
		try {
			Integer flag = cateLabelService.save(type, name);
			if (flag == -1) {
				result.setData(-1);
			} else {
				result.setData(1);
			}
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
