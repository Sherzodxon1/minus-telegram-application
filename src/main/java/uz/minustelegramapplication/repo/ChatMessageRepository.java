package uz.minustelegramapplication.repo;

import org.springframework.stereotype.Repository;
import uz.minustelegramapplication.base.BaseRepository;
import uz.minustelegramapplication.entity.ChatMessage;

import java.util.Optional;

@Repository
public interface ChatMessageRepository extends BaseRepository<ChatMessage> {
    Optional<ChatMessage> findByChatId(Integer chatId);
}
