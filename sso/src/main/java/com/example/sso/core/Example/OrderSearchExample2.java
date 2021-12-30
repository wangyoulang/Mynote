package com.example.sso.core.Example;

import lombok.Data;

@Data
public class OrderSearchExample2 {

    ///申请状态:'申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝'
    private Integer status;
    ///申请时间
    private String createTime;
    ///操作人员
    private String handleMan;
    ///处理时间
    private String handleTime;
}
