package com.pinkyLam.blog.dao;

import com.pinkyLam.blog.entity.CateLabel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年7月12日 下午2:46:47
 */

@Repository
public interface CateLabelDao extends JpaRepository<CateLabel, Long> {

	public List<CateLabel> findCateLabelByType(Integer type);

}
