package com.anush.onlinemess.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

   private Long id;
   private String fullName;
   private String shortName;
   private Integer isAvailable;
   private Integer day;
}
