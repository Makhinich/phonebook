package phonebook;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import phonebook.entity.Phone;
import phonebook.entity.User;
import phonebook.enums.PhoneType;
import phonebook.repository.UserRepository;
import phonebook.service.PhoneBookService;

/**
 * Class to run Spring Boot application.
 *
 * @author Viacheslav Makhinich.
 * @version 1.0.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Method for filling the database and testing application.
     * (In production it would be deleted, but in the test task I decided to leave it).
     *
     * @param userRepository   an instance of {@link UserRepository}.
     * @param phoneBookService an instance of {@link PhoneBookService}.
     * @return arguments of the application.
     */
    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository, PhoneBookService phoneBookService) {
        return args -> {
            userRepository.save(new User("Ivanov Ivan Ivanovich",
                    new Phone("+38 (050) 111-11-11", PhoneType.MOBILE, "Comment")));
            userRepository.save(new User("Petrov Petr Petrovich",
                    new Phone("+38 (067) 222-22-22", PhoneType.MOBILE, "Some comment")));
            userRepository.save(new User("Sanov San Sanych",
                    new Phone("+38 (063) 333-33-33", PhoneType.MOBILE, "My comment")));
            userRepository.save(new User("Petrova Anna Petrovna",
                    new Phone("+38 (066) 444-44-44", PhoneType.UNKNOWN, "No comment")));
            userRepository.save(new User("Ivanov Lola Ivanovna",
                    new Phone("+38 (044) 555-55-55", PhoneType.HOME, "Another comment")));

//            Collection<User> users = userRepository.findAll();
//            users.forEach(System.out::println);
        };
    }
}
