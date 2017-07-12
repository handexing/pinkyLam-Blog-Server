package com.pinkylam.blog.controller;

import com.pinkyLam.blog.dao.CateLabelDao;
import com.pinkyLam.blog.entity.CateLabel;
import com.pinkyLam.blog.vo.ErrorCode;
import com.pinkyLam.blog.vo.ExecuteResult;

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

	@Autowired
	CateLabelDao cateLabelDao;

	@RequestMapping("getCateLabelList/{type}")
	public ExecuteResult<List<CateLabel>> getCateLabelList(@PathVariable Integer type) {
		ExecuteResult<List<CateLabel>> result = new ExecuteResult<>();
		try {
			List<CateLabel> list = cateLabelDao.findCateLabelByType(type);
			result.setData(list);
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ErrorCode.EXCEPTION.getErrorCode());
			result.setErrorMsg(ErrorCode.EXCEPTION.getErrorMsg());
		}
		return result;
	}

	@RequestMapping("save/{type}/{name}")
	public ExecuteResult<List<CateLabel>> login(@PathVariable Integer type, @PathVariable String name) {
		ExecuteResult<List<CateLabel>> result = new ExecuteResult<>();
		try {
			CateLabel cateLabel = new CateLabel();
			cateLabel.setName(name);
			cateLabel.setRemark("");
			cateLabel.setType(type);
			cateLabel = cateLabelDao.save(cateLabel);
			List<CateLabel> list = cateLabelDao.findCateLabelByType(type);
			result.setData(list);
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ErrorCode.EXCEPTION.getErrorCode());
			result.setErrorMsg(ErrorCode.EXCEPTION.getErrorMsg());
		}
		return result;
	}

}
