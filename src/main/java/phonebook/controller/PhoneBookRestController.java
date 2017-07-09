package phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import phonebook.entity.Phone;
import phonebook.service.PhoneBookService;

import java.util.List;

/**
 * Controller for request processing.
 *
 * @author Slava Malhinich
 * @version 1.0
 */

@RestController
public class PhoneBookRestController {

    /**
     * An instance of {@link PhoneBookService}.
     */
    @Autowired
    private PhoneBookService phoneBookService;

    /**
     * The method gets new information about phones, and saves is in DB.
     *
     * @param phones a list with information about phones.
     */
    @RequestMapping(value = "/phones", method = RequestMethod.POST)
    public void editPhones(@RequestBody List<Phone> phones) {
        phoneBookService.editAll(phones);
    }

}
