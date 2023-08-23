package com.works.services;

import com.works.entities.Note;
import com.works.entities.Product;
import com.works.repositories.NoteRepository;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    final NoteRepository noteRepository;

    public ResponseEntity save(Note note) {
        noteRepository.save(note);
        return new ResponseEntity(note, HttpStatus.OK);
    }

    public ResponseEntity list() {
        List<Note> notes = noteRepository.findAll();
        return new ResponseEntity(notes, HttpStatus.OK);
    }

}
