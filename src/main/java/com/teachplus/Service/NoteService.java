package com.teachplus.Service;

import com.teachplus.Entity.Note;
import com.teachplus.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    public Collection<Note> findNotesByOwnerId(Long ownerId) {
        return noteRepository.findByOwnerIdOrderByFinished(ownerId);
    }

   public Note addNote(Note note) {
        return noteRepository.save(note);
   }

   public void deleteNote(Long noteId) {
        noteRepository.deleteById(noteId);
   }
}
