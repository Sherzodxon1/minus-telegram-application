package uz.minustelegramapplication.repo;

import org.springframework.stereotype.Repository;
import uz.minustelegramapplication.base.BaseRepository;
import uz.minustelegramapplication.entity.Group;

import java.util.Optional;

@Repository
public interface GroupRepository extends BaseRepository<Group> {

    Optional<Group> findByUsername(String name);
}
