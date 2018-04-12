package soft_uni.product_shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soft_uni.product_shop.models.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}