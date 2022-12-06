package database.daoInterfaces;

import domain.Model.User;

import java.util.List;

public interface IUserDao {
    User Create(User user);
    User Read(User user, int id);
    List<User> ReadAll(User user);
    User Update(User user);
    User Delete(User user);
}
