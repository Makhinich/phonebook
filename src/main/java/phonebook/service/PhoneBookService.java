package phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phonebook.entity.Phone;
import phonebook.entity.User;
import phonebook.repository.PhoneRepository;
import phonebook.repository.UserRepository;

import java.util.Collection;

/**
 * The class provides a set of methods for the operation with entities.
 *
 * @author Slava Makhinich.
 * @version 1.0
 */
@Service
public class PhoneBookService {

    /**
     * An instance of implementation of {@link UserRepository}
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * An instance of implementation of {@link PhoneRepository}
     */
    @Autowired
    private PhoneRepository phoneRepository;

    /**
     * Method to get all users.
     *
     * @return collection of all users.
     */
    public Collection<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * Method to edit phone instance.
     *
     * @param phone an instance of {@link Phone} with new information.
     * @return edited instance of {@link Phone}
     */
    public Phone editPhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    /**
     * Method to edit a collection of phones.
     *
     * @param phones a collection of {@link Phone} with new information.
     */
    public void editAll(Collection<Phone> phones) {
        phones.forEach(this::editPhone);
    }
}
