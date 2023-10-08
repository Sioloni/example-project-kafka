package ru.test.demo_project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.test.demo_project.dto.ColumnBoardDto;
import ru.test.demo_project.entity.ColumnBoard;
import ru.test.demo_project.mapper.ColumnBoardMapper;
import ru.test.demo_project.repository.ColumnBoardRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/board/column")
@RequiredArgsConstructor
public class ColumnBoardController {
    private final ColumnBoardRepository repository;
    private final ColumnBoardMapper mapper;


    @GetMapping
    public List<ColumnBoardDto> getAll(){
        return mapper.toDto(repository.findAll());
    }

    @GetMapping("/{id}")
    public ColumnBoardDto getById(@PathVariable Long id){
        return mapper.toDto(repository.findById(id).get());
    }

    @PostMapping
    public void create(@RequestBody ColumnBoardDto entity){
        repository.save(mapper.toEntity(entity));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}
