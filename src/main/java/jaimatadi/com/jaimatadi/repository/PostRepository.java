package jaimatadi.com.jaimatadi.repository;

import jaimatadi.com.jaimatadi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
