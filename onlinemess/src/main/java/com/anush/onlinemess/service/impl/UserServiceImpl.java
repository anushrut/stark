package com.anush.onlinemess.service.impl;

import com.anush.onlinemess.common.enums.APIStatus;
import com.anush.onlinemess.common.enums.Role;
import com.anush.onlinemess.common.exception.ApplicationException;
import com.anush.onlinemess.dao.UserRepository;
import com.anush.onlinemess.dto.UserDTO;
import com.anush.onlinemess.entity.User;
import com.anush.onlinemess.mapper.UserMapper;
import com.anush.onlinemess.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

   private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

   @Autowired private UserRepository userRepository;
   @Autowired private UserMapper userMapper;

   public Optional<User> getByUsername(String username) {
      return userRepository.findByUserName(username);
   }

   @Override
   public User saveUserWithDefaultParams(User user) {
      user.setRole(Role.STUDENT);
      return userRepository.save(user);
   }

   public User createUser(UserDTO userDTO) {
      if (userRepository.findByUserName(userDTO.getUserName()).isPresent()){
         logger.info("user already exist with userName:{}", userDTO.getUserName());
         throw new ApplicationException(APIStatus.USER_ALREADY_EXIST);
      }
      User user = new User();
      userMapper.mapToUser(userDTO,user);
      userRepository.save(user);
      return user;
   }

   @Override
   public User findByUserName(final String userName) {
      return userRepository.findByUserName(userName).orElse(null);
   }

   @Override
   public List<User> findAll() {
      return userRepository.findAll();
   }

}
