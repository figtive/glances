package com.glanse.microservices.service.web.controller;

import com.glanse.microservices.service.web.model.Note;
import com.glanse.microservices.service.web.repository.NoteRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class NoteRestController {

    private final NoteRepository noteRepository;

    public NoteRestController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping("/note/get")
    public Note getNote(@RequestParam(name = "name") String name) {
        Optional<Note> noteOptional = noteRepository.findByName(name);
        if (noteOptional.isPresent()) {
            return noteOptional.get();
        }
        throw new EntityNotFoundException();
    }

    @GetMapping("/note/getall")
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @PostMapping("/note/post")
    public Note postNote(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    @PostMapping("/note/postall")
    public List<Note> postAllNote(@RequestBody List<Note> notes) {
        return noteRepository.saveAll(notes);
    }

    @GetMapping("/note/delete")
    public Map<String, Boolean> deleteNote(@RequestParam(name = "name") String name) {
        Optional<Note> optionalNote = noteRepository.findByName(name);
        if (optionalNote.isPresent()) {
            noteRepository.delete(optionalNote.get());
            return Collections.singletonMap("success", true);
        } else {
            return Collections.singletonMap("success", false);
        }
    }
}
