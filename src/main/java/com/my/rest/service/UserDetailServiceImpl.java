package com.my.rest.service;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.rest.dao.UserDao;
import com.my.rest.model.User;
import com.my.rest.model.UserStatus;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findUserByName(username);
		
		if(user!=null){
		String password = user.getPassword();
		String role = user.getRole();
		//additional information on the security object
		boolean enabled = user.getStatus().equals(UserStatus.ACTIVE);
		boolean accountNonExpired = user.getStatus().equals(UserStatus.ACTIVE);
		boolean credentialsNonExpired = user.getStatus().equals(UserStatus.ACTIVE);
		boolean accountNonLocked = user.getStatus().equals(UserStatus.ACTIVE);
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new GrantedAuthorityImpl(role));
		
		
		org.springframework.security.core.userdetails.User securityUser
		= new org.springframework.security.core.userdetails.User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		return securityUser;
	}else{
		throw new UsernameNotFoundException("Username not found!");
	}

}
}