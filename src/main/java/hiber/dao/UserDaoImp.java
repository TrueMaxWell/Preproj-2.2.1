package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void addUserWithCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public User searchUserByCar(String model, int series) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Car where model = :model and series = :series");
        query.setParameter("model", model);
        query.setParameter("series", series);
        Car car = (Car) query.uniqueResult();
        return getUserById(car.getId());
    }

   @Override
   public List<User> listUsersWithCar() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where carOwner = true");
      return query.getResultList();
   }

   @Override
   public User getUserById(long id) {
      Query query1 = sessionFactory.getCurrentSession().createQuery("from User where id = :id");
      query1.setParameter("id", id);
      return (User) query1.uniqueResult();
   }

}
