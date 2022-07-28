package com.sparta.board.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class BoardRequestDto {

    private String username;
    private String title;
    private String contents;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
