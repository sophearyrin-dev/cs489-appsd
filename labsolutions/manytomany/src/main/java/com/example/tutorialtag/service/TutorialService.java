package com.example.tutorialtag.service;

import com.example.tutorialtag.dto.TagRequest;
import com.example.tutorialtag.dto.TagResponse;
import com.example.tutorialtag.dto.TutorailResponse;
import com.example.tutorialtag.dto.TutorialRequest;
import com.example.tutorialtag.model.Tag;
import com.example.tutorialtag.model.Tutorial;
import com.example.tutorialtag.repository.TagRepository;
import com.example.tutorialtag.repository.TutorialRepository;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class TutorialService {

    private TutorialRepository tutorialRepository;
    private TagRepository tagRepository;

    public TutorialService(TutorialRepository tutorialRepository,
                           TagRepository tagRepository) {
        this.tutorialRepository = tutorialRepository;
        this.tagRepository = tagRepository;
    }

    public TutorailResponse addNew(TutorialRequest tutorialRequest){

        Tutorial tutorial = new Tutorial(tutorialRequest.title());

        Tutorial tutorialSaved = tutorialRepository.save(tutorial);

        TutorailResponse tutorailResponse = new TutorailResponse(
                tutorialSaved.getTutorialId(),
                tutorialSaved.getTitle(),
                tutorialSaved.getTags().stream().map(
                        tag -> new TagResponse(
                                tag.getTagId(),
                                tag.getTagName()
                        )
                ).collect(Collectors.toList())
        );

        return tutorailResponse;
    }


    public TutorailResponse addTagToTutorial(Integer tutorialId, TagRequest tagRequest){

       var tutorial = tutorialRepository.findById(tutorialId);
       Tag tag = new Tag(tagRequest.tagName());
       tutorial.get().getTags().add(tag);
       tagRepository.save(tag);

       TutorailResponse tutorailResponse = new TutorailResponse(
                tutorial.get().getTutorialId(),
                tutorial.get().getTitle(),
                tutorial.get().getTags().stream().map(
                        t -> new TagResponse(
                                t.getTagId(),
                                t.getTagName()
                        )
                ).collect(Collectors.toList())


        );
        return tutorailResponse;

    }
}
