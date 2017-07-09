package phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import phonebook.enums.PhoneType;
import phonebook.service.PhoneBookService;

/**
 * Controller for web pages.
 *
 * @author Slava Malhinich
 * @version 1.0
 */

@Controller
public class PageController {

    /**
     * An instance of {@link PhoneBookService}.
     */
    @Autowired
    private PhoneBookService phoneBookService;

    /**
     * The method returns models and view for the main page.
     *
     * @return an instance of {@link ModelAndView}, models and view for the main page.
     */
    @RequestMapping("/")
    public ModelAndView userList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", phoneBookService.getAll());
        modelAndView.addObject("phoneTypes", PhoneType.values());
        modelAndView.setViewName("userList");
        return modelAndView;
    }
}
