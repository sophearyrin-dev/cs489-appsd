package miu.edu.camsys.camsys614133.onetomany.service.imp;

import miu.edu.camsys.camsys614133.onetomany.model.Comment;
import miu.edu.camsys.camsys614133.onetomany.model.dto.CommentRequest;
import miu.edu.camsys.camsys614133.onetomany.model.dto.CommentResponse;
import miu.edu.camsys.camsys614133.onetomany.repository.CommentRepository;
import miu.edu.camsys.camsys614133.onetomany.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImp implements CommentService {

    private CommentRepository commentRepository;

    public CommentServiceImp(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentResponse addNewComment(CommentRequest commentRequest) {

        Comment commentTobeSave = new Comment(commentRequest.commentContent());

        Comment commentSaved = commentRepository.save(commentTobeSave);

        CommentResponse commentResponse = new CommentResponse(
                commentSaved.getCommentId(),
                commentSaved.getCommentContent()
        );
        return commentResponse;
    }
}
