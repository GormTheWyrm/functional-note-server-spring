package com.geordin.simpleNoteServer.repository;

import com.geordin.simpleNoteServer.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepo  extends JpaRepository<Note, Integer>{
    //should extend CrudRepository? or a bunch of interfaces?
    //https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
    //.. for more info

//    public Note FindNoteByTitle(String title); //only put this here to see if it needed it to run...
//comes with methods such as save...

}
