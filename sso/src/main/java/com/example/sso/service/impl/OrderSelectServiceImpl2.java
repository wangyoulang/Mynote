package com.example.sso.service.impl;

import com.example.sso.core.DTO.OrderSearchDTO2;
import com.example.sso.core.Example.OrderSearchExample2;
import com.example.sso.core.mapper.OrderSearchDAO2;
import com.example.sso.service.OrderSelectService2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderSelectServiceImpl2 implements OrderSelectService2 {

    //先连接上数据库
    @Resource
    OrderSearchDAO2 orderSearchDAO2;

    //连接接口，重写方法
    @Override
    public List<OrderSearchDTO2> searchOrderInf1(OrderSearchExample2 orderSearchExample2) {
        List<OrderSearchDTO2> result2 =orderSearchDAO2.searchOrderByExample2(orderSearchExample2);
        return result2;
    }

}
