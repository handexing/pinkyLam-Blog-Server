package com.pinkylam.blog.controller;

import com.pinkyLam.blog.entity.User;
import com.pinkyLam.blog.service.UserService;
import com.pinkyLam.blog.vo.ErrorCode;
import com.pinkyLam.blog.vo.ExecuteResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年7月10日 上午11:04:04
 */

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("login/{name}/{psw}")
	public ExecuteResult<User> login(@PathVariable String name, @PathVariable String psw) {
		ExecuteResult<User> result = new ExecuteResult<>();
		User user = userService.findUserByNameAndPsw(name, psw);
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

	@RequestMapping("test")
	public List<User> test() {
		List<User> list = userService.findAll();
		return list;
	}


}
