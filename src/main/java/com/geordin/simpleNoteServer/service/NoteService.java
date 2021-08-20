package com.geordin.simpleNoteServer.service;

import com.geordin.simpleNoteServer.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NoteService {

    public Note addNote(Note note) throws Exception;
    public Note getNoteById(int id) throws Exception;
    public Note updateNote( Note note, int id) throws Exception;
    public void deleteNote( int id) throws Exception;

    public List<Note> getAllNotes() throws Exception;

    //no get by author or day at this time



}
