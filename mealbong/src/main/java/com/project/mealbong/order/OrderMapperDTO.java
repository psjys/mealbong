package com.project.mealbong.order;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class OrderMapperDTO {
    private int order_number;
    private String user_id;
    private LocalDate order_date;
    private int order_amount;
    private String order_status;
    private String payment;
}
