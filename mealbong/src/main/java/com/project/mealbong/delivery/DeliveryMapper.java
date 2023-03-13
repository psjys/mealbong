package com.project.mealbong.delivery;
import com.project.mealbong.faq.FaqDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeliveryMapper {

    List<DeliveryDTO> deliveryList() throws Exception;


    FaqDTO deliveryDetail(DeliveryDTO dto) throws Exception;
    void deliveryDelete(DeliveryDTO dto) throws Exception;
    void deliveryInsert(DeliveryDTO dto) throws Exception;
    void deliveryUpdate(DeliveryDTO dto) throws Exception;
}
