package miu.edu.camsys.camsys614133.onetomany.repository;

import miu.edu.camsys.camsys614133.onetomany.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
