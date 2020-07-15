package com.anush.onlinemess.service;

import com.anush.onlinemess.dto.ItemDTO;
import java.util.List;

public interface MenuService {
    public List<ItemDTO> getTodaysMenu();
    public List<ItemDTO> getMenu(int dayNo);
}
