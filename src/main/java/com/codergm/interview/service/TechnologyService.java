package com.codergm.interview.service;

import com.codergm.interview.model.dto.TechnologyDTO;

import java.util.List;

public interface TechnologyService {
    List<TechnologyDTO> getAllTechnologies(); // <2>
}
