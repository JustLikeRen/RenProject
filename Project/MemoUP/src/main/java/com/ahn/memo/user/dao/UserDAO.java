package com.ahn.memo.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ahn.memo.user.model.User;

@Repository
public interface UserDAO {
	
	public int insertUser(
			@Param("id") String id
			, @Param("password") String password
			, @Param("name") String name
			, @Param("email") String email);

	public User selectUser(
			@Param("loginId") String loginId);
	
	public int selectId(@Param("loginId") String loginId);
	
}
