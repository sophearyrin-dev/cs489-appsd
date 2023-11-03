package miu.edu.camsys.camsys614133.onetomany.model.dto;
import java.util.List;

public record TutorialResponse(

        Integer tutorialId,

        String title,

        List<CommentResponse> comments
) {
}
