package com.codergm.interview.service.impl;

import com.codergm.interview.mapper.TechnologyMapper;
import com.codergm.interview.model.dto.TechnologyDTO;
import com.codergm.interview.repository.TechnologyRepository;
import com.codergm.interview.service.TechnologyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TechnologyServiceImpl implements TechnologyService {
    private final TechnologyRepository technologyRepository;
    private final TechnologyMapper technologyMapper;

    @Override
    public List<TechnologyDTO> getAllTechnologies() {
        return technologyRepository.findAll().stream().map(technologyMapper::toDto).toList();
    }
}
