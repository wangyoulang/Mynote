package com.example.sso.core.collection;

import lombok.Data;

@Data
public class CollectCountDO {
    /**
     * 采集商品数
     */
    private Integer collectNum;

    /**
     * 被采集商品数
     */
    private Integer itemNum;
}
