package com.example.sso.service.impl;

import com.example.sso.core.mapper.OrderStatisticsDAO;
import com.example.sso.service.OrderStatisticsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shkstart
 * @create 2021-12-0910:56
 */
@Service
public class OrderStatisticsServiceImpl implements OrderStatisticsService {

    @Resource
    OrderStatisticsDAO orderStatisticsDAO;

    @Override
    public Integer getOrderTotal() {
        Integer orderAmount = orderStatisticsDAO.getOrderTotal();
        return orderAmount;
    }
}
