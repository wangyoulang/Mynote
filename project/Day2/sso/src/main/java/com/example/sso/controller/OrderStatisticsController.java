package com.example.sso.controller;

import com.example.sso.service.OrderStatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author shkstart
 * @create 2021-12-0911:24
 */
@RestController
@RequestMapping("order")
public class OrderStatisticsController {
    @Resource
    OrderStatisticsService statisticsService;

    @GetMapping("/get-amount")
    public Integer getOrderAmount(){
        return statisticsService.getOrderTotal();
    }
}
