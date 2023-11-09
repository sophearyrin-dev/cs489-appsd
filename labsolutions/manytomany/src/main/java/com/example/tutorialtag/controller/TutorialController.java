package com.example.tutorialtag.controller;

import com.example.tutorialtag.dto.TagRequest;
import com.example.tutorialtag.dto.TagResponse;
import com.example.tutorialtag.dto.TutorailResponse;
import com.example.tutorialtag.dto.TutorialRequest;
import com.example.tutorialtag.service.TutorialService;
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
    public ResponseEntity<TutorailResponse> addNew(@RequestBody TutorialRequest tutorialRequest){
        return new ResponseEntity<>(tutorialService.addNew(tutorialRequest), HttpStatus.CREATED);
    }


    @PostMapping("/{tutorialId}/tag")
    public ResponseEntity<TutorailResponse> addTagToTutorial(@PathVariable Integer tutorialId,@RequestBody TagRequest tagRequest){
        return new ResponseEntity<>(tutorialService.addTagToTutorial(tutorialId,tagRequest), HttpStatus.CREATED);
    }
}
