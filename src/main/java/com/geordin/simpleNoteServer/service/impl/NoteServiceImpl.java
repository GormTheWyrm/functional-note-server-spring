package com.geordin.simpleNoteServer.service.impl;

import com.geordin.simpleNoteServer.model.Note;
import com.geordin.simpleNoteServer.repository.NoteRepo;
import com.geordin.simpleNoteServer.Exceptions.NoNoteException;
import com.geordin.simpleNoteServer.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepo noteRepo;



    //create
    public Note addNote(Note note) throws Exception {
        try {
            return noteRepo.save(note);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //read
    public Note getNoteById(int id) throws Exception{
        try{
            Optional<Note> optional = noteRepo.findById(id);
            if (optional.isPresent()){
                return optional.get();
            }
            else{
                throw new NoNoteException();
            }
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //update
    public Note updateNote( Note note, int id) throws Exception {

        try{
//            Note note2 = noteRepo.getById(id);
            note.setId(id);
            return noteRepo.save(note); //fixme verify this doesnt duplicate

        }
        //add in NoNoteException for when getByid returns null...
        //...is that changing any note that has null id right now?
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //delete
    public void deleteNote( int id) throws Exception {

        try{
            noteRepo.deleteById(id);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    //get all
    public List<Note> getAllNotes() throws Exception {

        try{
            return noteRepo.findAll();
        }
        //SHould I add in esception for a blank list?
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }



}
//change exceptiontype
//add n some code to intercept exceptions and log them
//I need to look up and learn about optional's methods!