package com.pinkyLam.blog.service;

import com.pinkyLam.blog.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年7月10日 上午11:31:04
 */

@Repository
public interface UserService extends JpaRepository<User, Long> {

	public User findUserByNameAndPsw(String name, String psw);

}
