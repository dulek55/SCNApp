package com.ITApp.SCN.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ITApp.SCN.models.RoleModel;
import com.ITApp.SCN.models.UserModel;
import com.ITApp.SCN.repository.UserModelRepository;

@Service
public class UserModelDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserModelRepository userModelRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userModelRepository.findByName(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (RoleModel role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(), grantedAuthorities);
	}

}
