package phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phonebook.entity.Phone;

/**
 * Interface provides a set of methods for the operation with entity {@link Phone}
 *
 * @author Slava Makhinich
 * @version 1.0
 */
public interface PhoneRepository extends JpaRepository<Phone, Integer> {

}
