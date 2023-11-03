package miu.edu.camsys.camsys614133.onetomany.service;

import miu.edu.camsys.camsys614133.onetomany.model.dto.CommentRequest;
import miu.edu.camsys.camsys614133.onetomany.model.dto.CommentResponse;

public interface CommentService {

    CommentResponse addNewComment(CommentRequest commentRequest);
}
