package com.example.sso.core.mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderStatisticsDAO {
    Integer getOrderTotal();
}
