package uz.minustelegramapplication.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.minustelegramapplication.base.BaseRepository;
import uz.minustelegramapplication.entity.Group;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends BaseRepository<Group> {

    Optional<Group> findByUsername(String name);

    List<Group> findByOwnerId(Integer ownerId);

    @Query(value = "select count(u.id) from group_members t inner join groups g on g.id = t.group_id" +
            "                   inner join users u on u.id = t.user_id" +
            " where group_id = ?", nativeQuery = true)
    Integer getGroup(Integer userId);
}
