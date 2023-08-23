package com.works.restcontrollers;

import com.works.entities.Note;
import com.works.entities.Product;
import com.works.services.NoteService;
import com.works.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteRestController {

    final NoteService noteService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Note note) {
        return noteService.save(note);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return noteService.list();
    }

}
