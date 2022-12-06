package database.daos;

import database.daoInterfaces.IUserDao;
import database.orm.DbConnection;
import domain.Model.User;

import java.util.List;

public class UserDao implements IUserDao {

    DbConnection<User> connection;

    public UserDao(DbConnection<User> connection) {
        this.connection = connection;
    }


    @Override
    public User Create(User user) {
        connection.create(user);
        return user;
    }

    @Override
    public User Read(User user, int id) {
        return connection.read(user, id);
    }

    @Override
    public List<User> ReadAll(User user) {
        return connection.readAll(user);
    }

    @Override
    public User Update(User user) {
        connection.update(user);
        return user;
    }

    @Override
    public User Delete(User user) {
        connection.delete(user);
        return user;
    }
}
