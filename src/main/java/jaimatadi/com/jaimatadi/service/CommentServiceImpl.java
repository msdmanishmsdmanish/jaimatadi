package jaimatadi.com.jaimatadi.service;

import jaimatadi.com.jaimatadi.entity.Comment;
import jaimatadi.com.jaimatadi.entity.Post;
import jaimatadi.com.jaimatadi.exception.ResourceNotFoundException;
import jaimatadi.com.jaimatadi.payload.CommentDto;
import jaimatadi.com.jaimatadi.repository.CommentRepository;
import jaimatadi.com.jaimatadi.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, long postid) {
       Post post= postRepository.findById(postid).orElseThrow(
                ()-> new ResourceNotFoundException("Post is not Found with id:"+postid)
        );
       Comment comment=new Comment();
       comment.setEmail(commentDto.getEmail());
       comment.setText(commentDto.getText());
       comment.setPost(post);
        Comment saveComment = commentRepository.save(comment);
        CommentDto dto=new CommentDto();
        dto.setId(saveComment.getId());
        dto.setEmail(saveComment.getEmail());
        dto.setText(saveComment.getText());
        return dto;
    }
}
