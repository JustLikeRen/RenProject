package com.ahn.memo.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ahn.memo.post.model.Post;

@Repository
public interface PostDAO {

	// 전체 리스트
	public List<Post> selectList(@Param("userId") int userId);
	
	// 글 쓰기
	public int insertPost(
			@Param("userId") int userId
			, @Param("title") String title
			, @Param("content") String content
			, @Param("imagePath") String imagePath);

	// 글 읽기
	public Post selectPost(@Param("postId") int postId);
	
	// 글 삭제
	public int deletePost(@Param("postId") int postId);
	
	// 글 수정
	public int updatePost(
			@Param("postId") int postId
			, @Param("title") String title
			, @Param("content") String content);
	
}
