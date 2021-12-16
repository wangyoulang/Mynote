package com.example.sso.service;

import com.example.sso.core.DTO.OrderSearchDTO;
import com.example.sso.core.Example.OrderSearchExample;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-12-1621:02
 */
public interface OrderSelectService {
    List<OrderSearchDTO> selectOrderInf(OrderSearchExample orderSearchExample);
}
