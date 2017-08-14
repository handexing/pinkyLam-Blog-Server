package com.pinkylam.blog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pinkylam.blog.entity.MemoRemind;


/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年8月8日 下午1:51:24
 */
@Repository
public interface MemoRemindDao extends JpaRepository<MemoRemind, Long> {

	public List<MemoRemind> findMemoRemindByAuthorId(Long authorId);

}
