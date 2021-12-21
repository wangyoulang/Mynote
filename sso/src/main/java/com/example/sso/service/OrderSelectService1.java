package com.example.sso.service;

import com.example.sso.core.DTO.OrderSearchDTO1;
import com.example.sso.core.Example.OrderSearchExample1;

import java.util.List;

public interface OrderSelectService1 {

    List<OrderSearchDTO1> searchOrderInf(OrderSearchExample1 orderSearchExample1);
}
