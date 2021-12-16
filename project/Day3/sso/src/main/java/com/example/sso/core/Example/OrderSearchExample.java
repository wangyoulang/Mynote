package com.example.sso.core.Example;

import lombok.Data;

/**
 * @author shkstart
 * @create 2021-12-1620:06
 */
@Data
public class OrderSearchExample {
    //订单编号
    private String orderSn;
    //订单状态
    private Integer status;
    //收货人
    private String receiverName;
    //订单类型
    private Integer orderType;
    //查询开始时间
    private String startTime;
    //查询结束时间
    private String endTime;
    //订单来源
    private Integer sourceType;
}
