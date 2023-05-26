package dao.product;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dao.sheared.Shear.*;

public class ProductDao implements IProduct{
    String SELECT_FROM_MILK_PRODUCT = "SELECT * FROM milk.product;";
    String INSERT_INTO_MILK_PRODUCT = "insert into product(p_name,p_price,p_weight,unit,right_alway) values(?,?,?,?);";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public void insert(Product product) throws SQLException {

    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        return false;
    }
    public List<Product> SelectAllProduct() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_FROM_MILK_PRODUCT)) {

            System.out.println(statement);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                String id = set.getString("p_id");
                String name = set.getString("p_name");
                String price = set.getString("p_price");
                String weight = set.getString("weight");
                String unit = set.getString("unit");
                Date rightAway = Date.valueOf(set.getString("right_away"));

                productList.add(new Product(id, name, price, weight, unit, rightAway));
            }

        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return productList;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }

    }
}
