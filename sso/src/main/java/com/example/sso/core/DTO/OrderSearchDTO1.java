package com.example.sso.core.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderSearchDTO1 {
    ////响应用驼峰命名法
    //订单编号
    private String orderSn;
    //物流
    private String deliveryCompany;

    //物流单号
    private String deliverySn;

    //自动确定天数
    private Integer autoConfirmDay;

    //可以获得的积分
    private Integer integration;

    //可以活动的成长值
    private Integer growth;

    //活动信息
    private String promotionInfo;

    //商品销售属性
    private String productAttr;

    //销售价格
<<<<<<< HEAD
    private Double productPrice;
=======
    private BigDecimal product_price;
>>>>>>> 12e09d6a61c513b47605d9ebe5cc33ca60bf2c95

    //购买数量
    private Integer productQuantity;



}
