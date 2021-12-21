package com.example.sso.core.collection;

import lombok.Data;

@Data
public class CollectItemDO {

    private Integer id;

    private String itemId;

    private Integer rootCategoryId;

    private Integer categoryId;

    private Integer itemStatus;

    private Integer shopType;

    private Integer shopMonitorStatus;

    private Integer shopSelected;

    private Integer priceLevel;

    private String title;

    private String picUrl;

    private String saleTime;

    private Long monthSaleVolume;

    private Long totalSaleVolume;

    private Long collectCount;

    private Long commentCount;

    private Integer price;

    private String shopId;

    private String shopName;

    private String createdAt;

    private String updatedAt;

    private String deletedAt;

    private Integer teamNum;
}