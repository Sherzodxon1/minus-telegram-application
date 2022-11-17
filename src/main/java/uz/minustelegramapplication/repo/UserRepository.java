package uz.minustelegramapplication.repo;

import org.springframework.stereotype.Repository;
import uz.minustelegramapplication.base.BaseRepository;
import uz.minustelegramapplication.dto.UserDTO;
import uz.minustelegramapplication.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {

    Optional<User> findByPhone(String phone);

    Optional<User> findByUserName(String name);
}
