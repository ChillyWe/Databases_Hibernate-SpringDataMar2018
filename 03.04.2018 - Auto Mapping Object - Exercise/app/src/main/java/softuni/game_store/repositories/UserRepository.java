package softuni.game_store.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import softuni.game_store.models.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findOneByEmail(String email);
}