package com.example.sso.core.collection;

import lombok.Data;

@Data
public class DistributionDO {
    private String shopId;

    private String shopName;

    private Integer number;

    private Integer shopMonitorStatus;

    private Integer shopSelected;

    private Integer priceLevel;

    private String labelValue;
}
