package phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phonebook.entity.User;

/**
 * Interface provides a set of methods for the operation with entity {@link User}
 *
 * @author Slava Makhinich
 * @version 1.0
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
