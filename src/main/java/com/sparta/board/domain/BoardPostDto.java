package com.sparta.board.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardPostDto {
    private String username;
    private String title;
    private String contents;
    private LocalDateTime createTime;
    private LocalDateTime modifiedDate;

}
