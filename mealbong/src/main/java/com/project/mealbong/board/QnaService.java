package com.project.mealbong.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QnaService {
    @Autowired
    private QnaMapper mapper;

    public List<QnaDTO> qnaList(){
        List<QnaDTO> qnaList = new ArrayList<QnaDTO>();

        try {
            qnaList = mapper.qnaList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return qnaList;
    }
}
