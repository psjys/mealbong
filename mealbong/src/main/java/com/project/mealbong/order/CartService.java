package com.project.mealbong.order;

import java.util.List;


public interface CartService {
    List<CartMapperDTO> cart_list(String user_id);
    int cart_count(String user_id);
}
