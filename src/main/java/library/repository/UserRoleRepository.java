
package library.repository;

import library.entity.User;
import library.entity.UserRole;
import library.entity.UserRoleKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

}
