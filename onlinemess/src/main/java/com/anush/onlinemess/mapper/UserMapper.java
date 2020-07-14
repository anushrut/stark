package com.anush.onlinemess.mapper;

import com.anush.onlinemess.dto.SignUpRequest;
import com.anush.onlinemess.dto.UserDTO;
import com.anush.onlinemess.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

   public void mapToUser(SignUpRequest signUpRequest, User user){
   //   user.setPassword(bCryptPasswordEncoder.encode(signUpRequest.getPassword()));
      user.setUserName(signUpRequest.getUserName());
      user.setEmail(signUpRequest.getEmail());

      user.setFirstName(signUpRequest.getFirstName());
      user.setLastName(signUpRequest.getLastName());
      user.setGender(signUpRequest.getGender());
      user.setPhone(signUpRequest.getPhone());
   }

   public void mapToUser(UserDTO userDTO, User user){
    //  user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
      user.setUserName(userDTO.getUserName());
      user.setEmail(userDTO.getEmail());

      user.setFirstName(userDTO.getFirstName());
      user.setLastName(userDTO.getLastName());
      user.setGender(userDTO.getGender());
      user.setPhone(userDTO.getPhone());
      user.setRole(userDTO.getRole());
   }
}
