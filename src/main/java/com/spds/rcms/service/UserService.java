package com.spds.rcms.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spds.rcms.entity.RoleOffice;
import com.spds.rcms.entity.User;
import com.spds.rcms.entity.UserAccessMapping;

/***
 * 
 *@author abinjola
 *This class was creaded on 02-Dec-2024.
 */
public interface UserService {
	
	public User getUserDetails(Long userId) throws Exception;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;	
	
	public List<RoleOffice> getAuthorities(Long userId);
	
	public List<UserAccessMapping> assignRoleAndOffice(List<UserAccessMapping> userAccess);
	

}
