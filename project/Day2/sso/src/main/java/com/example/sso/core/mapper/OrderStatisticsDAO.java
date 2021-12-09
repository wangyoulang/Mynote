package com.example.sso.core.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author shkstart
 * @create 2021-12-0820:53
 */
@Mapper
public interface OrderStatisticsDAO {

    Integer getOrderTotal();

}
