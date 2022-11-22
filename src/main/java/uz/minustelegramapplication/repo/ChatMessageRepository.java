package uz.minustelegramapplication.repo;

import org.springframework.stereotype.Repository;
import uz.minustelegramapplication.base.BaseRepository;
import uz.minustelegramapplication.entity.ChatMessage;

import java.util.List;

@Repository
public interface ChatMessageRepository extends BaseRepository<ChatMessage> {
    List<ChatMessage> findByChatId(Integer chatId);
}
