package softuni.game_store.services.game;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.game_store.repositories.GameRepository;

@Service
@Transactional
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository,
                           ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void test() {
        String debug = "";
    }
}