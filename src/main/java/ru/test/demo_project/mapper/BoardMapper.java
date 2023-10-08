package ru.test.demo_project.mapper;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.test.demo_project.dto.BoardDto;
import ru.test.demo_project.entity.Board;
import ru.test.demo_project.entity.ColumnBoard;
import ru.test.demo_project.repository.ColumnBoardRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BoardMapper {
    private final ColumnBoardRepository repository;

    public Board toEntity(BoardDto dto) {
        return new Board
                (
                        dto.getId(),
                        dto.getTitle(),
                        repository.findAllById(dto.getColumnBoardId())
                );
    }

    public BoardDto toDto(Board entity) {
        return new BoardDto
                (
                        entity.getId(),
                        entity.getTitle(),
                        entity.getColumnBoards()
                                .stream()
                                .map(ColumnBoard::getId)
                                .toList()
                );
    }

    public List<Board> toEntity(List<BoardDto> dto) {
        return dto.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<BoardDto> toDto(List<Board> entity) {
        return entity.stream().map(this::toDto).collect(Collectors.toList());
    }

}
