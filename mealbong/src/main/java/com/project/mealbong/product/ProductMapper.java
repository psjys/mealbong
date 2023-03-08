package com.project.mealbong.product;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper {
    // 상품 리스트
    List<ProductDTO> productList() throws Exception;
    // 상품 이미지 리스트로 불러오기
    List<ImageDTO> imageList(int product_number) throws Exception;
    // 상품 상세
    ProductDTO productDetail(int product_number);
    ProductDTO detail(ProductDTO dto);

    // 상품 등록
    int insert(ProductDTO dto);

    // 상품 수정
    int update(ProductDTO dto);

    // 상품 삭제
    void delete(ProductDTO dto);

    List<ProductDTO> productAdmin() throws Exception;

}
