package com.geordin.simpleNoteServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {
    //HOME PAGE... is jsut a note that this is not that kind of server
    @GetMapping("/")
    public String returnHome(){
        return "This is an API Server, use '/notes' to see all notes, or '/note/{id}' to add, update or delete a specific note";
    } //move this to own controller, if needed
@GetMapping("/author")
    public String showAuthorDetails(){
        return "Author: Geordin Soucie, 2021. https://github.com/GormTheWyrm";
        //might make this into a real view later
}

}
