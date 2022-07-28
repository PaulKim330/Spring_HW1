package com.sparta.board.service;

import com.sparta.board.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;


    //업데이트 하기
    public Long update(Long id, BoardRequestDto requestDto){
        Board board = boardRepository.findById(id).orElseThrow(//Db에서 Id로 Board 객체
                () -> new IllegalStateException("id가 존재하지 않습니다."));
        board.update(requestDto);
        boardRepository.save(board); //저장하기
        return board.getId();
    }

    //비밀번호 맞는지 확인하기
    public String passwordck(Long id, String password){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("id가 없습니다"));
        if(password.equals(board.getPassword())){
            return "Okay";
        }else {
            return "Invalid password";
        }

    }

    //게시글 전체조회하기
    public List<ResponseBoardDto> getboard(){
        List<Board> getlist = boardRepository.findAll();
        List<ResponseBoardDto> responseBoardDtoList = new ArrayList<>();
        for(int i = getlist.size()-1; i >= 0; i--){
            Board board = getlist.get(i);
            ResponseBoardDto responseBoardDto = new ResponseBoardDto();
            responseBoardDto.setContents(board.getContents());
            responseBoardDto.setTitle(board.getTitle());
            responseBoardDto.setCreateTime(board.getCreateTime());
            responseBoardDto.setUsername(board.getUsername());
            responseBoardDtoList.add(responseBoardDto);

        }
        return responseBoardDtoList;
    }

    //게시글 하나 조회하기
    public Board boardPost(Long id){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("해당 글이 없습니다")
        );
        return board;
    }
}
