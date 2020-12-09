package ua.lviv.iot.terminal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.terminal.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
