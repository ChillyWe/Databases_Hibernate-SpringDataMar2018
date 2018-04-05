package softuni.game_store.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.game_store.models.entity.Game;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {


}