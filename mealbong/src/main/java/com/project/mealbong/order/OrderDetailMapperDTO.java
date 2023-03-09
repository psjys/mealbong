package com.project.mealbong.order;

import lombok.Data;

@Data
public class OrderDetailMapperDTO {
    private int order_detail_number;
    private int order_number;
    private int product_number;
    private String product_name;
    private int product_count;
    private int product_price;
    private int price_total;

    private String review_check;
    private String image_file;
    private String payment;
}
