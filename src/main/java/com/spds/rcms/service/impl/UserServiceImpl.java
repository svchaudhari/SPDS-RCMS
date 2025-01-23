package com.spds.rcms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spds.rcms.dto.UserPrincipal;
import com.spds.rcms.entity.RoleOffice;
import com.spds.rcms.entity.User;
import com.spds.rcms.entity.UserAccessMapping;
import com.spds.rcms.repository.UserAccessRepository;
import com.spds.rcms.repository.UserRepository;
import com.spds.rcms.service.UserService;

import lombok.extern.slf4j.Slf4j;

/***
 * 
 * @author abinjola This class was creaded on 02-Dec-2024.
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	private UserRepository userRepository;

	private UserAccessRepository userAccessRepository;
	
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder, UserAccessRepository userAccessRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder=passwordEncoder;
		this.userAccessRepository = userAccessRepository;
	}

	@Override
	public User getUserDetails(Long userId) throws Exception {
		log.info("Get user details for: {}", userId);
		return userRepository.findById(userId).orElseThrow(() -> new Exception("user not found!"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findById(Long.valueOf(username));
		return user.map(UserPrincipal::new)
				.orElseThrow(() -> new UsernameNotFoundException("UserName not found: " + username));
	}

	@Override
	public List<RoleOffice> getAuthorities(Long userId) {
		return userAccessRepository.getUserPrivilagesByUserId(userId);
	}

	@Override
	public List<UserAccessMapping> assignRoleAndOffice(List<UserAccessMapping> userAccess) {
		return userAccessRepository.saveAll(userAccess);
	}

}
