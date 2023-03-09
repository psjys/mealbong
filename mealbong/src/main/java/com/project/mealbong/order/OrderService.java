package com.project.mealbong.order;

import java.util.List;

public interface OrderService {
    int order_insert(OrderMapperDTO orderMapperDTO);
    int order_number();

    int orderDetail_insert(OrderDetailMapperDTO orderDetailMapperDTO);

    List<OrderDetailMapperDTO> order_submit(int order_number);
}
