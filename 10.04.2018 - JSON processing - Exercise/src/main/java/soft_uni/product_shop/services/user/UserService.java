package soft_uni.product_shop.services.user;

import soft_uni.product_shop.models.dtos.binding.user.UserCreateBindingModel;
import soft_uni.product_shop.models.entity.User;

import java.util.Collection;

public interface UserService {
    void save (UserCreateBindingModel model);

    void saveUsers(Collection<UserCreateBindingModel> models);

    User findUser(Integer userID);
}