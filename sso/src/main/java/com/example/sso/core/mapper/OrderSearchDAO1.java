package com.example.sso.core.mapper;

import com.example.sso.core.DTO.OrderSearchDTO1;
import com.example.sso.core.Example.OrderSearchExample1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderSearchDAO1 {

    //声明一个函数
    List<OrderSearchDTO1> searchOrderByExample(@Param("param") OrderSearchExample1 example1);
}
