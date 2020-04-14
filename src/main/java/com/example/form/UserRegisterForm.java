package com.example.form;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.example.domain.UserMail;




public class UserRegisterForm {

	private Integer userId;
	@NotBlank(message = "名前を入力してください")
	private String userName;
	private Integer mailTypeId;
	private List<UserMail> mailAddressList;
	@NotBlank(message = "パスワードを入力してください")
	private String password;
	private String confirmationPassword;
	private String createdBy;
	private Timestamp createdAt;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getMailTypeId() {
		return mailTypeId;
	}

	public void setMailTypeId(Integer mailTypeId) {
		this.mailTypeId = mailTypeId;
	}

	public List<UserMail> getMailAddressList() {
		return mailAddressList;
	}

	public void setMailAddressList(List<UserMail> mailAddressList) {
		this.mailAddressList = mailAddressList;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmationPassword() {
		return confirmationPassword;
	}

	public void setConfirmationPassword(String confirmationPassword) {
		this.confirmationPassword = confirmationPassword;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

}

