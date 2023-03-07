package com.project.mealbong.product;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper {
    List<ProductDTO> productList() throws Exception;

    int insert(ProductDTO dto);

    ProductDTO detail(ProductDTO dto);

    int update(ProductDTO dto);

    void delete(ProductDTO dto);

    List<ProductDTO> productAdmin() throws Exception;

}
