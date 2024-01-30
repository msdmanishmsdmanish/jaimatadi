package jaimatadi.com.jaimatadi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="comments")
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String text;
    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;
}
