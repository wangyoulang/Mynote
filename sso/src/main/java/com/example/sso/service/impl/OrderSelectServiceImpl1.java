package com.example.sso.service.impl;

import com.example.sso.core.DTO.OrderSearchDTO1;
import com.example.sso.core.Example.OrderSearchExample1;
import com.example.sso.core.mapper.OrderSearchDAO1;
import com.example.sso.service.OrderSelectService1;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OrderSelectServiceImpl1 implements OrderSelectService1 {
    @Resource
    OrderSearchDAO1 orderSearchDAO1;

    //连接接口，重写方法
    @Override
    public List<OrderSearchDTO1> searchOrderInf(OrderSearchExample1 orderSearchExample1) {
        List< OrderSearchDTO1> result1 =orderSearchDAO1.searchOrderByExample(orderSearchExample1);
        return result1;
    }
}
