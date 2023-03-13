package com.project.mealbong.order;

import com.project.mealbong.critest.SearchCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    int order_insert(OrderMapperDTO orderMapperDTO);
    int order_number();
    int orderDetail_insert(OrderDetailMapperDTO orderDetailMapperDTO);
    List<OrderDetailMapperDTO> order_submit(int order_number);

    // admin page
    List<OrderMapperDTO> searchList(SearchCriteria cri);
    int searchTotalCount(SearchCriteria cri);
    List<OrderDetailMapperDTO> order_detail (OrderDetailMapperDTO dto);
    int delete (OrderMapperDTO dto);
}
