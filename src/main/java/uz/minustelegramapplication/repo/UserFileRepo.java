package uz.minustelegramapplication.repo;

import org.springframework.stereotype.Repository;
import uz.minustelegramapplication.base.BaseRepository;
import uz.minustelegramapplication.entity.UserFile;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserFileRepo extends BaseRepository<UserFile> {

    Optional<UserFile> findByName(String name);

    List<UserFile> findAllByUserId(Integer userId);
}
