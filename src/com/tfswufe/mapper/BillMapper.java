package com.tfswufe.mapper;

import com.tfswufe.entity.Bill;

import java.util.List;

public interface BillMapper {
    List<Bill> SelectCheckMapper(Bill bill);//查询账单信息
    int InsertCheckMapper(Bill bill);//添加商品信息
}
