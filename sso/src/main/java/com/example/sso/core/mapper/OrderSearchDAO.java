package com.example.sso.core.mapper;

import com.example.sso.core.DTO.OrderSearchDTO;
import com.example.sso.core.Example.OrderSearchExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderSearchDAO {
//函数的声明
    List<OrderSearchDTO> selectOrderByExample(@Param("param") OrderSearchExample example);




}
