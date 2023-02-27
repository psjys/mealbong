package com.project.mealbong.board;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class QnaDTO {
    private int qna_num;
    private String user_id;
    private String qna_title;
    private String qna_content;
    private String qna_date;
    private String qna_file;
    private String ans_content;
    private String ans_date;

//    private MultipartFile uploadfilef;
}
