package com.chandu.onlinemess.api;

import com.chandu.onlinemess.common.enums.APIStatus;
import com.chandu.onlinemess.common.util.Constant;
import com.chandu.onlinemess.common.util.ResponseUtil;
import com.chandu.onlinemess.dto.APIResponse;
import com.chandu.onlinemess.dto.ItemDTO;
import com.chandu.onlinemess.entity.Item;
import com.chandu.onlinemess.service.ItemService;
import com.chandu.onlinemess.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {

   @Autowired private ItemService itemService;
   @Autowired private ResponseUtil responseUtil;

   @RequestMapping(method = RequestMethod.GET, path = "/{id}")
   public ResponseEntity<APIResponse> get(@PathVariable(value = "id", required = false) final Long itemId) {
      final Item item = itemService.getItemById(itemId);
      if (item != null) {
         return responseUtil.buildResponse(APIStatus.OK, item, HttpStatus.OK);
      }  else {
         List<Constant.ParamError> list = new ArrayList<>();
         list.add(Constant.ParamError.WRONG_INPUT_PARAMETER);
         return responseUtil.badRequestResponse(APIStatus.ERR_BAD_REQUEST, list, HttpStatus.BAD_REQUEST);
         }
   }

   @RequestMapping(method = RequestMethod.POST)
   public ResponseEntity<APIResponse> create(@RequestBody ItemDTO itemDTO) {
      itemService.createItem(itemDTO);
      return responseUtil.successResponse(APIStatus.OK);
   }

}
