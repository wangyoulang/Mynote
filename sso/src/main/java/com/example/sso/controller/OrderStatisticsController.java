package com.example.sso.controller;

import com.example.sso.core.DTO.OrderSearchDTO;
import com.example.sso.core.DTO.OrderSearchDTO1;
import com.example.sso.core.DTO.OrderSearchDTO2;
import com.example.sso.core.Example.OrderSearchExample;
import com.example.sso.core.Example.OrderSearchExample1;
import com.example.sso.core.Example.OrderSearchExample2;
import com.example.sso.service.OrderSelectService;
import com.example.sso.service.OrderSelectService1;
import com.example.sso.service.OrderSelectService2;
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
    @Resource
    OrderSelectService1 orderSelectService1;
    @Resource
    OrderSelectService2 orderSelectService2;

    @GetMapping("/get-amount")
    public Integer getOrderAmount(){
        return statisticsService.getOrderTotal();
    }

    @GetMapping("/select")
    public List<OrderSearchDTO> selectOrderInf(OrderSearchExample example){
        return orderSelectService.selectOrderInf(example);
    }

    @GetMapping("/search")
    public List<OrderSearchDTO1> searchOrderInf(OrderSearchExample1 example1){
        return orderSelectService1.searchOrderInf(example1);
    }

    @GetMapping("/search2")
    public List<OrderSearchDTO2> searchOrderInf2(OrderSearchExample2 example2){
        return orderSelectService2.searchOrderInf1(example2);
    }


}
