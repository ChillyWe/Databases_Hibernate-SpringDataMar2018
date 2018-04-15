package soft_uni.product_shop.services.user;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft_uni.product_shop.models.dtos.binding.user.UserCreateBindingModel;
import soft_uni.product_shop.models.entity.User;
import soft_uni.product_shop.repositories.UserRepository;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.mapper = modelMapper;
    }

    @Override
    public void save(UserCreateBindingModel model) {
        User user = this.mapper.map(model, User.class);
        this.userRepository.saveAndFlush(user);
    }


    @Override
    public void saveUsers(Collection<UserCreateBindingModel> models) {
        Type listType = new TypeToken<List<User>>() {
        }.getType();
        Collection<User> users = this.mapper.map(models, listType);
        this.userRepository.saveAll(users);
    }

    @Override
    public User findUser(Integer userID) {
        if(this.userRepository.findById(userID.longValue()).isPresent()) {
            return this.userRepository.findById(userID.longValue()).get();
        }
        return null;
    }
}