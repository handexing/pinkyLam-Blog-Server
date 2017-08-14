package com.pinkylam.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年8月14日 下午20:35:04
 */
@Controller
@RequestMapping("server")
public class ServerController {
	
	@RequestMapping("blog")
	public String index() {
		return "index";
	}
	
}
