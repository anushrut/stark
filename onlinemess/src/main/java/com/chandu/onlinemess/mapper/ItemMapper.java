package com.chandu.onlinemess.mapper;

import com.chandu.onlinemess.dto.ItemDTO;
import com.chandu.onlinemess.entity.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
   public Item map(ItemDTO itemDTO) {
      Item item = Item.builder()
                 .fullName(itemDTO.getFullName())
                 .shortName(itemDTO.getShortName())
                 .build();
      return item;

   }
}
