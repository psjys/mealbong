package com.project.mealbong.delivery;

import com.project.mealbong.faq.FaqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryMapper mapper;

    public List<DeliveryDTO> deliveryList() {
        try {
            return mapper.deliveryList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public FaqDTO deliveryDetail(DeliveryDTO dto) {
        try {
            return mapper.deliveryDetail(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deliveryDelete(DeliveryDTO dto) {
        try {
            mapper.deliveryDelete(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deliveryInsert(DeliveryDTO dto) {
        try {
            mapper.deliveryInsert(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deliveryUpdate(DeliveryDTO dto) {
        try {
            mapper.deliveryUpdate(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
