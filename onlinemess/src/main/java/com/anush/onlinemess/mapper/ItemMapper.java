package com.anush.onlinemess.mapper;

import com.anush.onlinemess.dto.ItemDTO;
import com.anush.onlinemess.entity.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
   public Item map(ItemDTO itemDTO) {
      Item item = Item.builder()
                      .fullName(itemDTO.getFullName())
                      .shortName(itemDTO.getShortName())
                      .isAvailable(itemDTO.getIsAvailable())
                      .day(itemDTO.getDay())
                      .build();
      return item;

   }

   public ItemDTO map(Item item) {
      ItemDTO itemDTO = ItemDTO.builder()
                               .id(item.getId())
                               .day(item.getDay())
                               .fullName(item.getFullName())
                               .shortName(item.getShortName())
                               .isAvailable(item.getIsAvailable())
                               .build();
      return itemDTO;
   }
}
