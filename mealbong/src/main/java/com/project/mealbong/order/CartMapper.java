package com.project.mealbong.order;

import com.project.mealbong.product.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    List<CartMapperDTO> cart_list(String user_id);
    int cart_count(String user_id);

    int cart_update(CartMapperDTO cartMapperDTO);

    int cart_delete(int cart_number);

    CartMapperDTO cart_order(int cart_number);

    void wish_insert(ProductDTO productDTO);
    void cart_insert(ProductDTO productDTO);
}
