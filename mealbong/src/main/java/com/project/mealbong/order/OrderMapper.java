package com.project.mealbong.order;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    int order_insert(OrderMapperDTO orderMapperDTO);
    int order_number();
    int orderDetail_insert(OrderDetailMapperDTO orderDetailMapperDTO);
    List<OrderDetailMapperDTO> order_submit(int order_number);
}
