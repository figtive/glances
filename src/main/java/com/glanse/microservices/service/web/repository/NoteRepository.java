package com.glanse.microservices.service.web.repository;

import com.glanse.microservices.service.web.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Optional<Note> findByName(String name);
}
