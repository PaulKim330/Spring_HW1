package com.sparta.board.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseBoardDto {
    private String title;
    private String username;
    private String contents;
    private LocalDateTime createTime;


}
