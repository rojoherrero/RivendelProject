package org.rojoherrero.rivendel.domain;

import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 7875318339519540066L;
	private User user;

	public CurrentUser(User user) {
		super(user.getEmail(), user.getPasswordHash(),
				AuthorityUtils.createAuthorityList(user.getRole().toString()));
		this.user = user;
	}
	
	public User getUser(){
		return user;
	}
	
	 public Long getId(){
		 return user.getUserId();
	 }
	 
	 public UserRoles getRole(){
		 return user.getRole();
	 }

}
