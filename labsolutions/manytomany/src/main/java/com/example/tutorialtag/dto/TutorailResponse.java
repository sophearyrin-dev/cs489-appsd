package com.example.tutorialtag.dto;


import java.util.List;

public record TutorailResponse(

        Integer tutorialId,

        String title,

        List<TagResponse> tags
){
}
