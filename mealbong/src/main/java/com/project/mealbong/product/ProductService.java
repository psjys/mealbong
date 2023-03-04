package com.project.mealbong.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductMapper mapper;

    public List<ProductDTO> productList(){
        List<ProductDTO> productList = new ArrayList<ProductDTO>();

    try{
        productList = mapper.productList();
    } catch(Exception e){
        e.printStackTrace();
    }

    return productList;
    }

    public ProductDTO detail(ProductDTO dto){
        return mapper.detail(dto);
    }

    public int insert(ProductDTO dto){
        return mapper.insert(dto);
    }

    public int update(ProductDTO dto) { return mapper.update(dto);}

    public void delete(ProductDTO dto) { mapper.delete(dto);}
}


