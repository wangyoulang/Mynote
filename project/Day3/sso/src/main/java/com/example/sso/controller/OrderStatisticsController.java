package com.example.sso.controller;

import com.example.sso.core.DTO.OrderSearchDTO;
import com.example.sso.core.Example.OrderSearchExample;
import com.example.sso.service.OrderSelectService;
import com.example.sso.service.OrderStatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-12-0911:24
 */
@RestController
@RequestMapping("order")
public class OrderStatisticsController {
    @Resource
    OrderStatisticsService statisticsService;
    @Resource
    OrderSelectService orderSelectService;

    @GetMapping("/get-amount")
    public Integer getOrderAmount(){
        return statisticsService.getOrderTotal();
    }

    @GetMapping("/select")
    public List<OrderSearchDTO> selectOrderInf(OrderSearchExample example){
        return orderSelectService.selectOrderInf(example);
    }
}
