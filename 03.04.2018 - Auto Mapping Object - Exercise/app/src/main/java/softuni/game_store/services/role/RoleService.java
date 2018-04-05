package softuni.game_store.services.role;


import softuni.game_store.models.entity.Role;

public interface RoleService {

    Role getRoleByName(Roles role);
    void updateRole(Role role);
    enum Roles {
        ADMIN,USER
    }
}