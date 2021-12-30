package com.example.sso.core.DTO;

import lombok.Data;

import java.util.List;

@Data
public class OrderSearchDTO2 {

    ///申请时间
    private String createTime;
    ///用户账号
    private String memberUsername;
    ///退款金额
    private Double returnAmount;
    ///申请状态:'申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝'
    private Integer status;
    ///处理时间
    private String handleTime;
    ///查看详情
    private List<returnApplyDetailDTO> handDetail;



}
