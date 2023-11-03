package miu.edu.camsys.camsys614133.onetomany.service.imp;

import miu.edu.camsys.camsys614133.onetomany.model.Comment;
import miu.edu.camsys.camsys614133.onetomany.model.Tutorial;
import miu.edu.camsys.camsys614133.onetomany.model.dto.*;
import miu.edu.camsys.camsys614133.onetomany.repository.CommentRepository;
import miu.edu.camsys.camsys614133.onetomany.repository.TutorialRepository;
import miu.edu.camsys.camsys614133.onetomany.service.TutorialService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TutorialServiceImp implements TutorialService {

    private TutorialRepository tutorialRepository;
    private CommentRepository commentRepository;

    public TutorialServiceImp(TutorialRepository tutorialRepository,
                              CommentRepository commentRepository) {
        this.tutorialRepository = tutorialRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public TutorialResponseWithoutComment addNewTutorial(TutorialRequest tutorialRequest) {

        Tutorial tutorial = new Tutorial(tutorialRequest.title());

        Tutorial tutorialSaved = tutorialRepository.save(tutorial);

        TutorialResponseWithoutComment tutorialResponseWithoutComment = new TutorialResponseWithoutComment(
                tutorialSaved.getTutorialId(),
                tutorialSaved.getTitle()
        );
        return tutorialResponseWithoutComment;
    }

    @Override
    public TutorialResponse addNewTutorialComment(
            Integer tutorialId,
            TutorialRequestAddingComment commentRequest) {

        Comment commentToBeSave = new Comment(commentRequest.commentContent());
        Optional<Tutorial> tutorial = tutorialRepository.findById(tutorialId);
        commentToBeSave.setTutorial(tutorial.get());
        Comment commentSaved= commentRepository.save(commentToBeSave);

        TutorialResponse tutorialResponse = new TutorialResponse(
                commentSaved.getTutorial().getTutorialId(),
                commentSaved.getTutorial().getTitle(),
                commentSaved.getTutorial().getComments().stream().map(
                        c -> new CommentResponse(
                                c.getCommentId(),
                                c.getCommentContent()
                        )
                ).collect(Collectors.toList())
        );

        return tutorialResponse;
    }
}
