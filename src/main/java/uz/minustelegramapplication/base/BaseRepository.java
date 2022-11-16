package uz.minustelegramapplication.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @param <E> - Entity
 */
@NoRepositoryBean
public interface BaseRepository<E> extends JpaRepository<E, Integer> {
}

