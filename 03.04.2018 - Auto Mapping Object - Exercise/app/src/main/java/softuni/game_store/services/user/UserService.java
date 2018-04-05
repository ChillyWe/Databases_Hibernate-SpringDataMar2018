package softuni.game_store.services.user;


import softuni.game_store.models.dto.binding.UserLoginBindingModel;
import softuni.game_store.models.dto.binding.UserRegisterBindingModel;
import softuni.game_store.models.dto.view.SuccessLoginUserViewModel;

public interface UserService {

    boolean register(UserRegisterBindingModel model);

    SuccessLoginUserViewModel login(UserLoginBindingModel model);


}