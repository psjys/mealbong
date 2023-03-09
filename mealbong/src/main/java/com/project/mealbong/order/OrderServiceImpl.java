package com.project.mealbong.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderMapper orderMapper;

    @Override
    public int order_insert(OrderMapperDTO orderMapperDTO) {
        return orderMapper.order_insert(orderMapperDTO);
    }

    @Override
    public int order_number() {
        return orderMapper.order_number();
    }

    @Override
    public int orderDetail_insert(OrderDetailMapperDTO orderDetailMapperDTO) {
        return orderMapper.orderDetail_insert(orderDetailMapperDTO);
    }

    @Override
    public List<OrderDetailMapperDTO> order_submit(int order_number) {
        return orderMapper.order_submit(order_number);
    }
}
