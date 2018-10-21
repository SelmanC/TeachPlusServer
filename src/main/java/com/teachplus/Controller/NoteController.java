package com.teachplus.Controller;

import com.teachplus.Entity.Note;
import com.teachplus.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    NoteService noteService;

    @GetMapping(produces = { "application/json" })
    public ResponseEntity getNotesByOwnerId(@RequestParam("ownerId") Long ownerId) {
        Collection<Note> notes = noteService.findNotesByOwnerId(ownerId);
        if (notes == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(notes);

    }

    @PostMapping(consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity addNote(@RequestBody Note note) {
        Note newNote = noteService.addNote(note);
        return ResponseEntity.ok().body(newNote);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable("id") long id) {
        noteService.deleteNote(id);
    }

}
