package com.pinkylam.blog.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pinkylam.blog.entity.MemoRemind;


/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年8月8日 下午1:51:24
 */
@Repository
public interface MemoRemindDao extends JpaRepository<MemoRemind, Long> {

	public List<MemoRemind> findMemoRemindByAuthorIdAndStatus(Long authorId,Integer status);
	
	@Query(nativeQuery = true, value = "SELECT COUNT(1) FROM MEMO_REMIND WHERE AUTHOR_ID=:userId")
	public int getMemoRemindByAuthorIdCnt(@Param("userId") Long userId);

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(nativeQuery = true, value = "UPDATE MEMO_REMIND SET STATUS=:status WHERE ID =:id")
	int updateStatus(@Param("id") Long id, @Param("status") Integer status);

}
