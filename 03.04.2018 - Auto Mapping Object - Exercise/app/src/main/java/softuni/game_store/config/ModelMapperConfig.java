package softuni.game_store.config;

import org.modelmapper.ModelMapper;
import softuni.game_store.models.dto.binding.UserRegisterBindingModel;
import softuni.game_store.models.entity.User;

public class ModelMapperConfig {

    private final ModelMapper modelMapper;

    public ModelMapperConfig(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.initialize();
    }

    private void initialize() {
        this.userRegisterMapping();
    }

    private void userRegisterMapping() {
        this.modelMapper.createTypeMap(UserRegisterBindingModel.class, User.class)
                .addMappings(mapper -> {
                    mapper.map(UserRegisterBindingModel::getA, User::setEmail);
                    mapper.map(UserRegisterBindingModel::getB, User::setFullName);
                });
    }
}