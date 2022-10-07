package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("Олег", "Валенцов", "user1@mail.ru",
                new Car("Lada Kalina", 666)));
        userService.add(new User("Алексей", "Новацкий", "user2@mail.ru",
                new Car("Daewoo Matiz", 19)));
        userService.add(new User("Герман", "Севостьянов", "user3@mail.ru",
                new Car("Chevrolet Impala", 92)));
        userService.add(new User("Виталий", "Сатункин", "user4@mail.ru",
                new Car("Chevrolet Camaro", 99)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }
        System.out.println(userService.getUserByCar("Lada Kalina", 666));
        System.out.println(userService.getUserByCar("Daewoo Matiz", 19));

        context.close();
    }
}
