package com.ahn.memo.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ahn.memo.common.FileManagerService;
import com.ahn.memo.post.dao.PostDAO;
import com.ahn.memo.post.model.Post;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDao;
	
	// 전체 리스트 보기
	public List<Post> searchList(int userId) {
		return postDao.selectList(userId);
	}
	
	// 글 쓰기
	public int addPost(int userId, String title, String content, MultipartFile file) {
		String imagePath = null;
		
		if(file != null) {
			imagePath = FileManagerService.saveFile(userId, file);	
		}
		
		return postDao.insertPost(userId, title, content, imagePath);
	}
	
	// 글 읽기
	public Post getPost(int postId) {
		return postDao.selectPost(postId);
	}
	
	// 글 삭제
	public int deletePost(int postId) {
		return postDao.deletePost(postId);
	}
	
	// 글 수정
	public int updatePost(int postId, String title, String content) {
		return postDao.updatePost(postId, title, content);
	}
	
}
