package uz.minustelegramapplication.repo;

import org.springframework.stereotype.Repository;
import uz.minustelegramapplication.base.BaseRepository;
import uz.minustelegramapplication.entity.Chat;
import uz.minustelegramapplication.entity.Group;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends BaseRepository<Group> {

    Optional<Group> findByUsername(String name);

    List<Group> findByOwnerId(Integer ownerId);
    List<Chat> getByOwnerId(Integer ownerId);
}
