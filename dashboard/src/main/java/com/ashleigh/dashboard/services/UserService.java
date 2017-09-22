package com.ashleigh.dashboard.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ashleigh.dashboard.models.User;
import com.ashleigh.dashboard.models.Role;
import com.ashleigh.dashboard.repositories.RoleRepository;
import com.ashleigh.dashboard.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    
    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        userRepository.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
    	ArrayList<Role> userRoles= new ArrayList<Role>();
    	userRoles.add(roleRepository.findByName("ROLE_ADMIN"));
    	userRoles.add(roleRepository.findByName("ROLE_USER"));
    	
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        userRepository.save(user);
    }    
    
    // 3
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public ArrayList<User> findAll(){
    	return (ArrayList<User>) userRepository.findAll();
    }
}
