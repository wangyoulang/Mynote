package com.example.sso.core.mapper;

import com.example.sso.core.DTO.OrderSearchDTO;
import com.example.sso.core.Example.OrderSearchExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-12-1620:40
 */
@Mapper
public interface OrderSearchDAO {
    List<OrderSearchDTO> selectOrderByExample(@Param("param") OrderSearchExample example);
}
