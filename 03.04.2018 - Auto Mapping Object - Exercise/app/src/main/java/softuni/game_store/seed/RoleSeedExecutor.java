package softuni.game_store.seed;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import softuni.game_store.models.entity.Role;
import softuni.game_store.repositories.RoleRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class RoleSeedExecutor {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleSeedExecutor(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void insertRoles() {
        if (this.roleRepository.count() == 0L) {
            Role adminRole = new Role();
            adminRole.setName("ADMIN");
            Role userRole = new Role();
            userRole.setName("USER");

            this.roleRepository.save(Arrays.asList(adminRole, userRole));
        }
    }
}
