package persistence;

import config.DBConnection;

import java.util.List;

public interface GenericRepository<T> {
    DBConnection connection = DBConnection.getInstance();

    public T get(int id);
    public List<T> getAll();
}
