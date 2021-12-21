package com.example.sso.core.mapper;

import com.example.sso.core.Example.CollectExample;
import com.example.sso.core.collection.CollectCountDO;
import com.example.sso.core.collection.TrendDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CollectItemDAO {

    CollectCountDO count(@Param("example") CollectExample example);


    /**
     * 需要连表查询
     */
    List<TrendDO> joinTrend(@Param("example")CollectExample example);

    List<TrendDO> trend(@Param("example")CollectExample example);

    List<CollectCountDO> unionCount(@Param("example")CollectExample example);
}

