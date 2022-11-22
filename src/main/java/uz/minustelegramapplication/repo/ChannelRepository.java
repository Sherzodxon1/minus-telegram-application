package uz.minustelegramapplication.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.minustelegramapplication.base.BaseRepository;
import uz.minustelegramapplication.entity.Channel;
import uz.minustelegramapplication.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChannelRepository extends BaseRepository<Channel> {

    Optional<Channel> findByUsername(String name);

    List<Channel> findByOwnerId(Integer userId);

    @Query(value = "select * from users where is_active = ?; "
            , nativeQuery = true)
    List<User> active(Integer active);


    @Query(value = "select count(u.id) from channels c inner join channel_members member  on c.id = member.channel_id" +
            "                   inner join users u on u.id = member.user_id" +
            " where c.id = ?", nativeQuery = true)
    Integer getCount(Integer userId);
}

