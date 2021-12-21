package com.example.sso.service.impl;

import com.example.sso.core.mapper.OrderStatisticsDAO;
import com.example.sso.service.OrderStatisticsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OderStatisticsServiceImpl implements OrderStatisticsService {

    @Resource
    OrderStatisticsDAO orderStatisticsDAO;

    ///连接接口，重写方法
    @Override
    public Integer getOrderTotal() {
        Integer orderAmount;
        orderAmount = orderStatisticsDAO.getOrderTotal();
        return orderAmount;
    }
}
