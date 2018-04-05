package softuni.game_store.services.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.game_store.models.dto.binding.UserLoginBindingModel;
import softuni.game_store.models.dto.binding.UserRegisterBindingModel;
import softuni.game_store.models.dto.view.SuccessLoginUserViewModel;
import softuni.game_store.models.entity.Role;
import softuni.game_store.models.entity.User;
import softuni.game_store.repositories.UserRepository;
import softuni.game_store.services.role.RoleService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;


    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper,
                           RoleService roleService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
    }

    @Override
    public boolean register(UserRegisterBindingModel model) {
        User user = this.modelMapper.map(model, User.class);
        Role role = this.setUserRole(user);
        if (model.isPasswordMatch()) {
            user = this.userRepository.saveAndFlush(user);
            role.getUsers().add(user);
            this.roleService.updateRole(role);
        }
        return user.getId() != null;
    }

    @Override
    public SuccessLoginUserViewModel login(UserLoginBindingModel model) {
        User user = this.userRepository.findOneByEmail(model.getEmail());
        if (user != null) {
            if (user.getPassword().equals(model.getPassword())) {
                return this.modelMapper.map(user, SuccessLoginUserViewModel.class);
            }
        }
        return null;
    }

    private Role setUserRole(User user) {
        Role role = null;
        if (this.userRepository.count() > 0) {
            role = this.roleService.getRoleByName(RoleService.Roles.USER);
            user.getRoles().add(role);
        } else {
            role = this.roleService.getRoleByName(RoleService.Roles.ADMIN);
            user.getRoles().add(role);
        }
        return role;
    }
}