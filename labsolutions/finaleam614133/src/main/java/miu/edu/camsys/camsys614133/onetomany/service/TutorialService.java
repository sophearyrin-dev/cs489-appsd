package miu.edu.camsys.camsys614133.onetomany.service;

import miu.edu.camsys.camsys614133.onetomany.model.dto.*;

public interface TutorialService {

    TutorialResponseWithoutComment addNewTutorial(TutorialRequest tutorialRequest);

    TutorialResponse addNewTutorialComment(Integer tutorialId,
                                           TutorialRequestAddingComment commentRequest);


}
