package com.example.controller;



import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.domain.UserMail;
import com.example.form.UserRegisterForm;
import com.example.service.UserRegisterService;

/**
 * ユーザーを登録するコントローラー.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("")
public class UserRegisterController {

	@Autowired
	private UserRegisterService userRegisterService;

	/**
	 * 入力されたものを受け取るフォーム.
	 * 
	 * @return ユーザー情報
	 */
	@ModelAttribute
	private UserRegisterForm setUpForm() {
		return new UserRegisterForm();
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	/**
	 * 新規登録画面へ遷移.
	 * 
	 * @return 新規登録ページ
	 */
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "toRegister";
	}

	/**
	 * ユーザーを登録する.
	 * 
	 * @param userRegisterForm ユーザー登録フォーム
	 * @param result エラーの有無
	 * @return ログイン画面へ遷移.
	 */
	@RequestMapping("/register")
	public String register(@Validated UserRegisterForm userRegisterForm, BindingResult result) {
//		for(UserMail userMail : userRegisterForm.getMailAddressList()) {
//		 userMail = userRegisterService.findByEmail(userMail.getMailAddress());
//		// メールアドレスの重複チェック
//		if (userMail != null) {
//			result.rejectValue("mailAddress", null, "そのメールアドレスはすでに使われています");
//		}
//		}
//		// パスワードと確認用パスワードのチェック
//		if (!(userRegisterForm.getPassword().equals(userRegisterForm.getConfirmationPassword()))) {
//			result.rejectValue("confirmationPassword", null, "パスワードと確認用パスワードが異なります");
//		}
//		// エラーが一つでもあれば入力画面に戻る
//		if (result.hasErrors()) {
//			return toRegister();
//		}
		
		User user = new User();
		user.setUserName(userRegisterForm.getUserName());
		user.setPassword(userRegisterForm.getPassword());
		user.setCreatedBy("東俊輔");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		user.setCreatedAt(timestamp);
		userRegisterService.insertUser(user);


		for(UserMail userMail2 : userRegisterForm.getMailAddressList()) {
			userMail2.setMailAddress(userMail2.getMailAddress());
			userMail2.setMailTypeId(userRegisterForm.getMailTypeId());
			userMail2.setUserId(user.getUserId());
			userRegisterService.insertMail(userMail2);

	}
		return "redirect:/";
}
}

