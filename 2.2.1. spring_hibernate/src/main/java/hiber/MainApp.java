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

        User user1 = new User("Олег", "Валенцов", "user1@mail.ru");
        user1.setUserCar(new Car("Lada Kalina", 666));
        userService.add(user1);
        User user2 = new User("Алексей", "Новацкий", "user2@mail.ru");
        user2.setUserCar(new Car("Daewoo Matiz", 19));
        userService.add(user2);
        User user3 = new User("Герман", "Севостьянов", "user3@mail.ru");
        user3.setUserCar(new Car("Chevrolet Impala", 92));
        userService.add(user3);
        User user4 = new User("Виталий", "Сатункин", "user4@mail.ru");
        user4.setUserCar(new Car("Chevrolet Camaro", 99));
        userService.add(user4);

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
