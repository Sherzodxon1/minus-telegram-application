package uz.minustelegramapplication.repo;

import org.springframework.stereotype.Repository;
import uz.minustelegramapplication.base.BaseRepository;
import uz.minustelegramapplication.entity.Chat;

import java.util.List;

@Repository
public interface ChatRepository extends BaseRepository<Chat> {
    List<Chat> findChatById(Integer id);
}
