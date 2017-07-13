package com.pinkyLam.blog.service;

import com.pinkyLam.blog.dao.CateLabelDao;
import com.pinkyLam.blog.entity.CateLabel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年7月13日 下午3:07:19
 */

@Service
public class CateLabelService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CateLabelDao cateLabelDao;

	public Integer save(Integer type, String name) {
		// 验证是否存在
		CateLabel label = cateLabelDao.findCateLabelByNameAndType(name, type);
		if (label != null) {
			return -1;
		}

		CateLabel cateLabel = new CateLabel();
		cateLabel.setName(name);
		cateLabel.setRemark("");
		cateLabel.setType(type);
		cateLabelDao.save(cateLabel);

		return 1;

	}

}
