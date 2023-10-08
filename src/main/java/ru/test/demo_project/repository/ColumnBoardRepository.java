package ru.test.demo_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.demo_project.entity.ColumnBoard;

import java.util.List;

@Repository
public interface ColumnBoardRepository extends JpaRepository<ColumnBoard, Long> {

}
