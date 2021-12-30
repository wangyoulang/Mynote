package com.example.sso.service;

import com.example.sso.core.DTO.OrderSearchDTO2;
import com.example.sso.core.Example.OrderSearchExample2;

import java.util.List;

public interface OrderSelectService2 {

    List<OrderSearchDTO2> searchOrderInf1(OrderSearchExample2 orderSearchExample2);
}
