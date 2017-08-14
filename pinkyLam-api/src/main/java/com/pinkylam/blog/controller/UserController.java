package com.pinkylam.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinkylam.blog.dao.UserDao;
import com.pinkylam.blog.entity.User;
import com.pinkylam.blog.vo.ErrorCode;
import com.pinkylam.blog.vo.ExecuteResult;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年7月10日 上午11:04:04
 */

@RestController
@RequestMapping("user")
public class UserController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserDao userDao;

	@RequestMapping("login/{name}/{psw}")
	public ExecuteResult<User> login(@PathVariable String name, @PathVariable String psw) {
		ExecuteResult<User> result = new ExecuteResult<>();
		User user = userDao.findUserByNameAndPsw(name, psw);
		if (user != null) {
			result.setData(user);
			result.setSuccess(true);
		} else {
			result.setSuccess(false);
			result.setErrorCode(ErrorCode.USER_NOT_EXIST.getErrorCode());
			result.setErrorMsg(ErrorCode.USER_NOT_EXIST.getErrorMsg());
		}
		return result;
	}

}
