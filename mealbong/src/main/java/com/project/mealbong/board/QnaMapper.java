package com.project.mealbong.board;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QnaMapper {
    List<QnaDTO> qnaList() throws Exception;

    int insert (QnaDTO dto);


}
