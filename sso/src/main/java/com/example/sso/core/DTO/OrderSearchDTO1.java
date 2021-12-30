package com.example.sso.core.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderSearchDTO1 {
    //物流
    private String delivery_company;

    //物流单号
    private String delivery_sn;

    //自动确定天数
    private Integer auto_confirm_day;

    //可以获得的积分
    private Integer integration;

    //可以活动的成长值
    private Integer growth;

    //活动信息
    private String promotion_info;

    //商品销售属性
    private String product_attr;

    //销售价格
    private BigDecimal product_price;

    //购买数量
    private Integer product_quantity;



}
