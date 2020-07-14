package com.anush.onlinemess.service.impl;

import com.anush.onlinemess.dao.ItemRepository;
import com.anush.onlinemess.dto.ItemDTO;
import com.anush.onlinemess.entity.Item;
import com.anush.onlinemess.mapper.ItemMapper;
import com.anush.onlinemess.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired ItemRepository itemRepository;
    @Autowired ItemMapper itemMapper;

    @Override
    public List<ItemDTO> getTodaysMenu() {

        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        List<ItemDTO> itemDTOList = new ArrayList<>();
        List<Item> list = itemRepository.findByDay(dayOfWeek);
        for (Item item : list) {
            itemDTOList.add(itemMapper.map(item));
        }
        return itemDTOList;
    }
}
