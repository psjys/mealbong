package com.project.mealbong.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper cartMapper;

    @Override
    public List<CartMapperDTO> cart_list(String user_id) {
        return cartMapper.cart_list(user_id);
    }

    @Override
    public int cart_count(String user_id) {
        return cartMapper.cart_count(user_id);
    }

    @Override
    public int cart_update(CartMapperDTO cartMapperDTO) {
        return cartMapper.cart_update(cartMapperDTO);
    }

    @Override
    public int cart_delete(int cart_number) {
        return cartMapper.cart_delete(cart_number);
    }

    @Override
    public CartMapperDTO cart_order(int cart_number) {
        return cartMapper.cart_order(cart_number);
    }
}
