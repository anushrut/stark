package com.anush.onlinemess.dao;

import com.anush.onlinemess.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByDay(int i);
}
