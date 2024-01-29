package jaimatadi.com.jaimatadi.service;

import jaimatadi.com.jaimatadi.entity.Post;
import jaimatadi.com.jaimatadi.exception.ResourceNotFoundException;
import jaimatadi.com.jaimatadi.payload.PostDto;
import jaimatadi.com.jaimatadi.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
       Post post=mapToEntity(postDto);
        Post savedPost = postRepository.save(post);



      PostDto dto= mapToDto(savedPost);
        return dto;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post= postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post is not found with id:" + id)
        );
PostDto dto=new PostDto();
dto.setId(post.getId());
dto.setTitle(post.getTitle());
dto.setDescription(post.getDescription());
dto.setContent(post.getContent());
        return dto;
    }

    @Override
    public List<PostDto> getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {
       Sort sort= (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> pagePost= postRepository.findAll(pageable);
        List<Post>posts=pagePost.getContent();
       List<PostDto>dtos=posts.stream().map(p->mapToDto(p)).collect(Collectors.toList());
        return dtos;
    }
    PostDto mapToDto(Post post){
        PostDto dto=new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }
    Post mapToEntity(PostDto postDto){
        Post post=new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }
}
