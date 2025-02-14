package com.codergm.interview.controller;

import com.codergm.interview.model.dto.TechnologyDTO;
import com.codergm.interview.service.TechnologyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/technologies")
@AllArgsConstructor
public class TechnologyController {

    private final TechnologyService technologyService;

    @GetMapping
    public ResponseEntity<List<TechnologyDTO>> getTechnology() {
        return ok(technologyService.getAllTechnologies());
    }
}
