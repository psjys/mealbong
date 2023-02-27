package com.project.mealbong.board;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QnaMapper {
    List<QnaDTO> qnaList() throws Exception;

}
