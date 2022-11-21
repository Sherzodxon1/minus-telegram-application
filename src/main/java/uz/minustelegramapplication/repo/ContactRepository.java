package uz.minustelegramapplication.repo;

import org.springframework.stereotype.Repository;
import uz.minustelegramapplication.base.BaseRepository;
import uz.minustelegramapplication.entity.Contact;
import uz.minustelegramapplication.entity.User;

import java.util.Optional;

@Repository
public interface ContactRepository extends BaseRepository<Contact> {

    Optional<Contact> findByPhone(String phone);

}
