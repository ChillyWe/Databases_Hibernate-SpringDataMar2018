package softuni.game_store.services.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.game_store.models.entity.Role;
import softuni.game_store.repositories.RoleRepository;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	private final RoleRepository rolerepository;

	@Autowired
	public RoleServiceImpl(RoleRepository rolerepository) { 
		this.rolerepository = rolerepository;
	}

	@Override
	public Role getRoleByName(Roles role) {
		return this.rolerepository.findByName(role.name());
	}

	@Override
	public void updateRole(Role role) {
		this.rolerepository.save(role);
	}


}