package com.example.sso.core.Example;


import lombok.Data;


///这个注解用于生成每个参数的get、set方法
@Data
public class OrderSearchExample {
    //订单编号
    private String orderSn;
    //订单状态
    private Integer status;
    //收获人
    private String receiverName;
    //订单类型
    private  Integer orderType;
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;
    //订单来源
    private Integer sourceType;

}
