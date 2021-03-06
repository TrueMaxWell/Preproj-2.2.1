package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public void addUserWithCar(Car car) {
      userDao.addUserWithCar(car);
   }

   @Override
   public User searchUserByCar(String model, int series) {
      return userDao.searchUserByCar(model, series);
   }

   @Override
   public List<User> listUsersWithCar() {
      return userDao.listUsersWithCar();
   }

   @Override
   public User getUserById(long id) {
      return userDao.getUserById(id);
   }

}
