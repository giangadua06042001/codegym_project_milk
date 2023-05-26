package dao;

import java.sql.SQLException;

public interface Shared <T>{
    public  void insert(T t) throws SQLException;
    public boolean delete(String id)throws SQLException;
    public boolean update(T t)throws SQLException;
}
