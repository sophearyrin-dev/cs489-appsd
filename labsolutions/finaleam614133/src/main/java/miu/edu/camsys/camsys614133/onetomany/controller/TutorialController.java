package miu.edu.camsys.camsys614133.onetomany.controller;

import miu.edu.camsys.camsys614133.onetomany.model.dto.TutorialRequest;
import miu.edu.camsys.camsys614133.onetomany.model.dto.TutorialRequestAddingComment;
import miu.edu.camsys.camsys614133.onetomany.model.dto.TutorialResponse;
import miu.edu.camsys.camsys614133.onetomany.model.dto.TutorialResponseWithoutComment;
import miu.edu.camsys.camsys614133.onetomany.service.TutorialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tutorial")
public class TutorialController {

    private TutorialService tutorialService;

    public TutorialController(TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    @PostMapping("/new")
    public ResponseEntity<TutorialResponseWithoutComment> saveTutorial(@RequestBody TutorialRequest tutorialRequest){
        return new ResponseEntity<>(tutorialService.addNewTutorial(tutorialRequest),
                HttpStatus.CREATED);
    }

    @PostMapping("/{tutorialId}/comment")
    public ResponseEntity<TutorialResponse> saveTutorialComment(@PathVariable Integer tutorialId, @RequestBody TutorialRequestAddingComment tutorialRequest){
        return new ResponseEntity<>(tutorialService.addNewTutorialComment(tutorialId,tutorialRequest),
                HttpStatus.CREATED);
    }

}
