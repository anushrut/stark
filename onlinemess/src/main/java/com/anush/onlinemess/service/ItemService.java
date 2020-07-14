package com.anush.onlinemess.service;

import com.anush.onlinemess.dto.ItemDTO;
import com.anush.onlinemess.entity.Item;

import java.util.List;

public interface ItemService {
   public ItemDTO createItem(ItemDTO itemDTO);

   public Item getItemById();

   public Item getItemById(Long itemId);

   public Item deleteItem(Long itemId);

   public Item updateItem(ItemDTO itemDTO);


}
