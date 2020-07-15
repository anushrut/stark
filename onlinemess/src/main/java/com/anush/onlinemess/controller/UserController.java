package com.anush.onlinemess.controller;

import com.anush.onlinemess.common.enums.APIStatus;
import com.anush.onlinemess.dto.APIResponse;
import com.anush.onlinemess.dto.UserDTO;
import com.anush.onlinemess.service.UserService;
import com.anush.onlinemess.common.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/admin/user")
public class UserController {

   private static final Logger logger = LoggerFactory.getLogger(UserController.class);

   @Autowired private ResponseUtil responseUtil;
   @Autowired private UserService userService;

   @RequestMapping(method = RequestMethod.POST)
   public ResponseEntity<APIResponse> create(@Valid @RequestBody UserDTO userDTO) {
      logger.info("received User create request : {}", userDTO);
      userService.createUser(userDTO);
      return responseUtil.successResponse(APIStatus.OK);
   }

   @RequestMapping(method = RequestMethod.GET, path = "/{userName}")
   public ResponseEntity<APIResponse> get(@PathVariable( name = "userName", required = false) String userName) {
      return responseUtil.buildResponse(APIStatus.OK, userService.findByUserName(userName), HttpStatus.OK);
   }

   @RequestMapping(method = RequestMethod.GET)
   public ResponseEntity<APIResponse> get() {
      return responseUtil.buildResponse(APIStatus.OK, userService.findAll(), HttpStatus.OK);
   }
}
