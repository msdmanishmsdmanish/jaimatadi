package jaimatadi.com.jaimatadi.controller;

import jaimatadi.com.jaimatadi.payload.CommentDto;
import jaimatadi.com.jaimatadi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jaimatadi/comment")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping //http://localhost:8080/jaimatadi/comment?postid=1
    public ResponseEntity<CommentDto>createComment(
            @RequestBody CommentDto commentDto,
            @RequestParam long postid
    ){
       CommentDto dto= commentService.createComment(commentDto,postid);
       return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
