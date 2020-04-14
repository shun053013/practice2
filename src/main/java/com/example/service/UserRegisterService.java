package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.domain.UserMail;
import com.example.repository.UserMailRepository;
import com.example.repository.UserRepository;

/**
 * ユーザーを管理するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Service
@Transactional
public class UserRegisterService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMailRepository userMailRepository;
	
	/**
	 * ユーザー登録をする.
	 * 
	 * @param userRegisterForm ユーザー登録フォーム
	 */
	public void insertUser(User user ) {

		userRepository.insert(user);

	}
	
	public void insertMail(UserMail userMail) {

		userMailRepository.insert(userMail);


	}
	
	/**
	 * メールアドレスの重複チェック.
	 * 
	 * @param mailAddress メールアドレス
	 * @return メールアドレス情報
	 */
	public UserMail findByEmail(String mailAddress) {
		return userMailRepository.findByEmail(mailAddress);
	}
}

