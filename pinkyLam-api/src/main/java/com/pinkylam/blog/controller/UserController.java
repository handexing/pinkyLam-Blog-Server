package com.pinkylam.blog.controller;

import com.pinkyLam.blog.entity.User;
import com.pinkyLam.blog.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping("test")
	public List<User> test() {
		List<User> list = userService.findAll();
		return list;
	}

}
