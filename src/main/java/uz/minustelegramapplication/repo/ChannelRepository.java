package uz.minustelegramapplication.repo;

import org.springframework.stereotype.Repository;
import uz.minustelegramapplication.base.BaseRepository;
import uz.minustelegramapplication.entity.Channel;

import java.util.Optional;

@Repository
public interface ChannelRepository extends BaseRepository<Channel> {

    Optional<Channel> findByUsername(String name);
}
