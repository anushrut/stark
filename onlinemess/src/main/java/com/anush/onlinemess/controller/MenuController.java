package com.anush.onlinemess.controller;

import com.anush.onlinemess.common.enums.APIStatus;
import com.anush.onlinemess.common.enums.Day;
import com.anush.onlinemess.common.util.ResponseUtil;
import com.anush.onlinemess.dto.APIResponse;
import com.anush.onlinemess.dto.ItemDTO;
import com.anush.onlinemess.dto.MenuDTO;
import com.anush.onlinemess.service.ItemService;
import com.anush.onlinemess.service.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {

   private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

   @Autowired private ItemService itemService;
   @Autowired private MenuService menuService;
   @Autowired private ResponseUtil responseUtil;

   @RequestMapping(method = RequestMethod.GET)
   public ResponseEntity<APIResponse> get(@RequestParam(value = "day", required = false) final String day) {
      List<ItemDTO> items = new ArrayList<>();
      if (StringUtils.isEmpty(day)) {
         items = menuService.getTodaysMenu();
      } else {
         Day d = Day.valueOf(day);
         int dayNo = d.getDay();
         items = menuService.getMenu(dayNo);
      }

      final MenuDTO menuDTO = MenuDTO.builder().itemList(items).build();
      return responseUtil.buildResponse(APIStatus.OK, menuDTO, HttpStatus.OK);
   }
}
