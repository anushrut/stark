package com.anush.onlinemess.api;

import com.anush.onlinemess.dto.MenuDTO;
import com.anush.onlinemess.entity.Item;
import com.anush.onlinemess.common.enums.APIStatus;
import com.anush.onlinemess.common.util.Constant;
import com.anush.onlinemess.common.util.ResponseUtil;
import com.anush.onlinemess.dto.APIResponse;
import com.anush.onlinemess.dto.ItemDTO;
import com.anush.onlinemess.service.ItemService;
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
      ItemDTO resItemDTO = itemService.createItem(itemDTO);
      return responseUtil.buildResponse(APIStatus.OK, resItemDTO, HttpStatus.OK);
   }

   @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
   public  ResponseEntity<APIResponse> delete(@PathVariable(value = "id", required = true) Long itemId ){
      Item item = itemService.deleteItem(itemId);
      return responseUtil.buildResponse(APIStatus.OK, item , HttpStatus.OK);
   }

   @RequestMapping(method = RequestMethod.PUT)
   public ResponseEntity<APIResponse> update(@RequestBody ItemDTO itemDTO) {
      itemService.updateItem(itemDTO);
      return responseUtil.successResponse(APIStatus.OK);

   }
}
