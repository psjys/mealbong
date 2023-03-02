package com.project.mealbong.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QnaService {
    @Autowired
    private QnaMapper mapper;

    public List<QnaDTO> qnaList() {
        List<QnaDTO> qnaList = new ArrayList<QnaDTO>();

        try {
            qnaList = mapper.qnaList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return qnaList;
    }
    public QnaDTO detail(QnaDTO dto) {
       return mapper.detail(dto);
    }
    public int insert(QnaDTO dto) {
        return mapper.insert(dto);
    }

    public int update(QnaDTO dto) {
        return mapper.update(dto);
    }

    public void delete(QnaDTO dto) {
        mapper.delete(dto);
    }

}
