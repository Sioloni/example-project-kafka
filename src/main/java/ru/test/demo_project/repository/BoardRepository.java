package ru.test.demo_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.demo_project.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
