package com.anush.onlinemess.service.impl;

import com.anush.onlinemess.entity.Item;
import com.anush.onlinemess.dao.ItemRepository;
import com.anush.onlinemess.dto.ItemDTO;
import com.anush.onlinemess.mapper.ItemMapper;
import com.anush.onlinemess.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

   @Autowired
   private ItemRepository itemRepository;
   @Autowired private ItemMapper itemMapper;

   @Override
   public ItemDTO createItem(ItemDTO itemDTO) {
      Item item = itemMapper.map(itemDTO);
      itemRepository.save(item);
      itemDTO.setId(item.getId());
      return itemDTO;
   }

   @Override
   public Item getItemById() {
      return null;
   }

   @Override
   public Item getItemById(final Long itemId) {
      final Optional<Item> item = itemRepository.findById(itemId);
      if (!item.isPresent())
         return null;
      final Item item1 = item.get();
      return item1;
   }

   @Override
   public Item deleteItem(Long itemId) {
      Optional<Item> item = itemRepository.findById(itemId);
      Item item1 = item.get();
      itemRepository.deleteById(itemId);
       return item1;
   }
   @Override
   public Item updateItem(ItemDTO itemDTO){
      Optional<Item> item = itemRepository.findById(itemDTO.getId());
      Item item1 = item.get();
      item1.setFullName(itemDTO.getFullName());
      item1.setShortName(itemDTO.getShortName());
      itemRepository.save(item1);
      return item1;
   }

}
