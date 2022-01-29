package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   void addUserWithCar (Car car);
   User searchUserByCar (String model, int series);
   List<User> listUsersWithCar();
   User getUserById(long id);
}
