package jaimatadi.com.jaimatadi.controller;

import jaimatadi.com.jaimatadi.payload.PostDto;
import jaimatadi.com.jaimatadi.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jaimatadi")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping  //http://localhost:8080/jaimatadi
    public ResponseEntity<PostDto>createPost(@RequestBody PostDto postDto){
        PostDto dto= postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @GetMapping("/a") //http://localhost:8080/jaimatadi/a?id=12
    public ResponseEntity<PostDto>getPostById(@RequestParam long id){
        PostDto dto=postService.getPostById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping //http://localhost:8080/jaimatadi?pageNo=0&pageSize=3&sortBy=title&sortDir=desc
    public List<PostDto> getAllPost(
            @RequestParam(name="pageNo",required = false,defaultValue = "0")int pageNo,
            @RequestParam(name="pageSize",required = false,defaultValue = "0")int pageSize,
            @RequestParam(name="sortBy",required = false,defaultValue = "id")String sortBy,
            @RequestParam(name="sortDir",required = false,defaultValue = "id")String sortDir
    ){
        List<PostDto>postdtos=postService.getAllPost(pageNo,pageSize,sortBy,sortDir);

        return postdtos;

    }
}
