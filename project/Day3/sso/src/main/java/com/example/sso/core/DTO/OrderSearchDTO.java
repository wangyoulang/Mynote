package com.example.sso.core.DTO;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author shkstart
 * @create 2021-12-1620:20
 */
@Data
public class OrderSearchDTO {
    //编号
    private Integer id;
    //订单编号
    private String orderSn;
    //提交时间
    private String createTime;
    //用户账号
    private String memberUsername;
    //订单金额
    private BigDecimal totalAmount;
    //支付方式 支付方式：0->未支付；1->支付宝；2->微信
    private Integer payType;
    //订单来源  订单来源：0->PC订单；1->app订单
    private Integer sourceType;
    //订单状态订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单'
    private Integer status;

}
