package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void addUserWithCar (Car car);
    User searchUserByCar (String model, int series);
}
