package com.project.mealbong.order;

import com.project.mealbong.critest.SearchCriteria;
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

    // admin page
    @Override
    public List<OrderMapperDTO> searchList(SearchCriteria cri) {
        return orderMapper.searchList(cri);
    }

    @Override
    public int searchTotalCount(SearchCriteria cri) {
        return orderMapper.searchTotalCount(cri);
    }

    @Override
    public List<OrderDetailMapperDTO> order_detail(OrderDetailMapperDTO dto) {
        return orderMapper.order_detail(dto);
    }

    @Override
    public int delete(OrderMapperDTO dto) {
        return orderMapper.delete(dto);
    }
}
