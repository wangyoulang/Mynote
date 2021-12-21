package com.example.sso.core.Example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectExample {

    //商品品类
    private Integer rootCategoryId;
    private Integer categoryId;

    //店铺范围
    private Integer shopType;

    //是否被监控
    private Integer shopMonitorStatus;

    //统计时间
    private String startData;
    private String endData;

    //商品状态
    private Integer itemStatus;

    //队伍id列表
    private List<Integer>  teamIdList;

    //上架时间
    private String onSaleStartDate;
    private String onSaleEndDate;

    //采集团队数

    private Integer minTeamNum;
    private Integer maxTeamNum;

    //搜索关键字
    private String keyword;

    //团队范围
    private Integer teamId;

    //排序依据

    private String sortField;

    //排序类型
    private String sortType;

    //1-日，2-周，3-月
    private Integer granularity;
    private Integer limit;


    /**
     * 可选择项分布类型：1-一级品类分布/类型、2--二级品类分布/风格
     */
    private Integer distType;

    /**
     * 1-价格分布,2-店铺监控分布，3-店铺精选分布
     */
    private Integer groupType;

    private Integer offset;

    private String lastStartDate;

    private String lastEndDate;

    private String lastYearStartDate;

    private String lastYearEndDate;



}
