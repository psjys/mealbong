package com.project.mealbong.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductMapper mapper;

    // 상품 리스트
    public List<ProductDTO> productList(){
        List<ProductDTO> productList = new ArrayList<ProductDTO>();

    try{
        productList = mapper.productList();
        System.out.println(productList);
    } catch(Exception e){
        e.printStackTrace();
    }
    return productList;
    }

    public ProductDTO productDetail(int product_number){
     //   List<ProductDTO> productDetail = new ArrayList<ProductDTO>();

        return mapper.productDetail(product_number);
    }

    public ProductDTO detail(ProductDTO dto){
        return mapper.detail(dto);
    }

    // 상품 등록
    public int insert(ProductDTO dto){
        return mapper.insert(dto);
    }

    // 상품 수정
    public int update(ProductDTO dto) { return mapper.update(dto);}

    // 상품 삭제
    public void delete(ProductDTO dto) { mapper.delete(dto);}

    // admin page
    public List<ProductDTO> productAdmin () {
        List<ProductDTO> productAdmin = new ArrayList<ProductDTO>();
        try{
            productAdmin = mapper.productAdmin();
        } catch(Exception e){
            e.printStackTrace();
        }
        return productAdmin;
    }
}


