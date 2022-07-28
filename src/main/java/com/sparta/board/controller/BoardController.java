package com.sparta.board.controller;

import com.sparta.board.domain.*;
import com.sparta.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;



    @PostMapping("/api/boards1")//글 저장하기
    public Board createPost(@RequestBody BoardRequestDto requestDto){
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }

    @GetMapping("/api/boards")//전체 게시글 목록조회.제목,작성자,작성날짜
    public List<ResponseBoardDto> readBoard(){
        return boardService.getboard();
    }

    @GetMapping("/api/post/{id}")//게시글 조회
    public Board boardPost(@PathVariable Long id){
        return boardService.boardPost(id);
    }


    @GetMapping("/api/pw/{id}/{password}")//비밀번호 확인하기 맞으면 Ok아니면 invalid
    public String passwordck(@PathVariable Long id,@PathVariable String password){
        String p = boardService.passwordck(id,password);
        return p;
    }



    @PutMapping("/api/boards3/{id}") //게시글 수정
    public Long updatePost(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) { //저장은 Requestbody
        boardService.update(id, requestDto);
        return id;
    }


    @DeleteMapping("/api/boards4/{id}") //게시글 삭제
    public Long deletePost(@PathVariable Long id){
        boardRepository.deleteById(id);
        return id;
    }
}
