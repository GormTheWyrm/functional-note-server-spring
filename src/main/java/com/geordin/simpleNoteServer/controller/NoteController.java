package com.geordin.simpleNoteServer.controller;

import com.geordin.simpleNoteServer.Exceptions.NoNoteException;
import com.geordin.simpleNoteServer.model.Note;
import com.geordin.simpleNoteServer.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@CrossOrigin
@RestController
public class NoteController {
    private NoteService noteService;

    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }
    @Autowired



    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getAllNotes(){
        try{
            return ResponseEntity.ok(noteService.getAllNotes());
        }
        catch (Exception e){ //specify error better
            return new ResponseEntity(INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/note/{id}")
    public ResponseEntity getNoteById(@PathVariable int id){ //<Note> not sure if I should include <Note> ...
        try{
        return ResponseEntity.ok(noteService.getNoteById(id));
        }
        catch (NoNoteException e){ //how to handle searching for a note that doesnt exist?
            return ResponseEntity.ok(e.getMessage());
        }
        catch (Exception e){ //specify error better
            return new ResponseEntity(INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/note") //should this be put or patch... can do either
    public ResponseEntity AddNote(@RequestBody Note note){
        System.out.println(note);
        try{
            return ResponseEntity.ok(noteService.addNote(note));
            //if no exception return a positive response
//            return ResponseEntity.ok("Note Updated");
        }
        catch (Exception e){ //specify error better
            ResponseEntity res = new ResponseEntity(INTERNAL_SERVER_ERROR);
//            res.getBody("Note Failed to Update");
            return res;
//                    ResponseEntity.("Note Failed to Update");
        }

    }

    @PutMapping("/note/{id}") //should this be put or patch... can do either
    public ResponseEntity updateNoteById(@PathVariable int id, @RequestBody Note note){
        try{
            noteService.updateNote(note, id);
            //if no exception return a positive response
            return ResponseEntity.ok("Note Updated");
        }
        catch (Exception e){ //specify error better
            ResponseEntity res = new ResponseEntity(INTERNAL_SERVER_ERROR);
//            res.getBody("Note Failed to Update");
            return res;
//                    ResponseEntity.("Note Failed to Update");
        }

    }// fixme this needs testing! also, figure out way to get msg

    @DeleteMapping("/note/{id}")
    public ResponseEntity deleteNoteById(@PathVariable int id){

        try{
            noteService.deleteNote(id);
            ResponseEntity res = new ResponseEntity(OK);
            return res;
        }
        catch (Exception e){
            return new ResponseEntity(INTERNAL_SERVER_ERROR);
        }
    }


}
//find way to better handle responses- maybe add a custom error message...
// check to make sure error messages involving database info are not sent to user