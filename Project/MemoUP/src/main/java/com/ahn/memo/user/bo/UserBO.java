package com.ahn.memo.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ahn.memo.user.dao.UserDAO;
import com.ahn.memo.user.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDao;
	private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public int insertUser(String id, String password, String name, String email) {
//		String encryptPassword = EncryptUtils.md5(password);
		String encodePassword = encoder.encode(password);
		
		return userDao.insertUser(id, encodePassword, name, email);
	}
	
	public User selectUser(String loginId, String password) {
//		String encryptPassword = EncryptUtils.md5(password);
		User user = userDao.selectUser(loginId);
	    if (user != null && encoder.matches(password, user.getPassword())) {
	        return user;
	    }
		return null;

	}
	
	public int selectLoginId(String loginId) {
		return userDao.selectId(loginId);
	}
	
	
}
