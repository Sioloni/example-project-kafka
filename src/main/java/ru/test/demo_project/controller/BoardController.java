package ru.test.demo_project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.test.demo_project.dto.BoardDto;
import ru.test.demo_project.mapper.BoardMapper;
import ru.test.demo_project.repository.BoardRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository repository;
    private final BoardMapper mapper;


    @GetMapping
    public List<BoardDto> getAll(){
        return mapper.toDto(repository.findAll());
    }

    @GetMapping("/{id}")
    public BoardDto getById(@PathVariable Long id){
        return mapper.toDto(repository.findById(id).get());
    }

    @PostMapping
    public void create(@RequestBody BoardDto entity){
        repository.save(mapper.toEntity(entity));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}
