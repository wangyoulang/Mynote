package com.example.sso.service.impl;

import com.example.sso.core.DTO.OrderSearchDTO;
import com.example.sso.core.Example.OrderSearchExample;
import com.example.sso.core.mapper.OrderSearchDAO;
import com.example.sso.service.OrderSelectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-12-1621:04
 */
@Service
public class OrderSelectServiceImpl implements OrderSelectService {

    @Resource
    OrderSearchDAO orderSearchDAO;
    @Override
    public List<OrderSearchDTO> selectOrderInf(OrderSearchExample orderSearchExample) {
        List<OrderSearchDTO> result = orderSearchDAO.selectOrderByExample(orderSearchExample);
        return result;
    }
}
