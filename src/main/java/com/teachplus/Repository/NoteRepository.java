package com.teachplus.Repository;

import com.teachplus.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    public Collection<Note> findByOwnerIdOrderByFinished(Long ownerId);
}
