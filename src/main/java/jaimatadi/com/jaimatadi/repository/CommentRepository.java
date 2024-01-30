package jaimatadi.com.jaimatadi.repository;

import jaimatadi.com.jaimatadi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
