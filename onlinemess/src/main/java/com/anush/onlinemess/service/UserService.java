package com.anush.onlinemess.service;

import com.anush.onlinemess.dto.UserDTO;
import com.anush.onlinemess.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

   Optional<User> getByUsername(String username);

   User saveUserWithDefaultParams(User user);

   User createUser(UserDTO userDTO);

   User findByUserName(String userName);

   List<User> findAll();
}
