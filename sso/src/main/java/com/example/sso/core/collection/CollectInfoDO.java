package com.example.sso.core.collection;

import lombok.Data;

@Data
public class CollectInfoDO {

    private Integer id;

    private String itemId;

    private Integer userId;

    private Integer teamId;

    private String collectTime;

    private String createdAt;

    private String updatedAt;

    private String deletedAt;

}