package ru.test.demo_project.mapper;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.test.demo_project.dto.ColumnBoardDto;
import ru.test.demo_project.entity.ColumnBoard;
import ru.test.demo_project.repository.BoardRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ColumnBoardMapper {
    private final BoardRepository repository;


    public ColumnBoard toEntity(ColumnBoardDto dto) {
        return new ColumnBoard
                (
                        dto.getId(),
                        dto.getTitle(),
                        repository.findById(dto.getBoardId()).get()
                );
    }

    public ColumnBoardDto toDto(ColumnBoard entity) {
        return new ColumnBoardDto
                (
                        entity.getId(),
                        entity.getTitle(),
                        entity.getBoard().getId()
                );
    }

    public List<ColumnBoard> toEntity(List<ColumnBoardDto> dto) {
        return dto.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<ColumnBoardDto> toDto(List<ColumnBoard> entity) {
        return entity.stream().map(this::toDto).collect(Collectors.toList());
    }
}
