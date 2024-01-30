package jaimatadi.com.jaimatadi.service;

import jaimatadi.com.jaimatadi.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, long postid);
}
