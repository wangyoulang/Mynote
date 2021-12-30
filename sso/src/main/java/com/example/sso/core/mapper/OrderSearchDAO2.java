package com.example.sso.core.mapper;

import com.example.sso.core.DTO.OrderSearchDTO2;
import com.example.sso.core.Example.OrderSearchExample2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderSearchDAO2 {

    ///声明一个函数
    List<OrderSearchDTO2> searchOrderByExample2(@Param("param") OrderSearchExample2 example2);
}
