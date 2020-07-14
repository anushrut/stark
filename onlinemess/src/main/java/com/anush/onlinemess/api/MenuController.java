package com.anush.onlinemess.api;

import com.anush.onlinemess.common.enums.APIStatus;
import com.anush.onlinemess.common.util.ResponseUtil;
import com.anush.onlinemess.dto.APIResponse;
import com.anush.onlinemess.dto.ItemDTO;
import com.anush.onlinemess.dto.MenuDTO;
import com.anush.onlinemess.service.ItemService;
import com.anush.onlinemess.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {

   private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

   @Autowired private ItemService itemService;
   @Autowired private MenuService menuService;
   @Autowired private ResponseUtil responseUtil;

   @RequestMapping(method = RequestMethod.GET, path = "/todaysmenu")
   public ResponseEntity<APIResponse> get() {
      final List<ItemDTO> items = menuService.getTodaysMenu();
      final MenuDTO menuDTO = MenuDTO.builder().itemList(items).build();
      return responseUtil.buildResponse(APIStatus.OK, menuDTO, HttpStatus.OK);

   }
}
