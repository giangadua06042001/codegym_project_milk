package dao.product;

import com.sun.org.apache.xpath.internal.operations.Or;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dao.sheared.Shear.*;

public class ProductDao implements IProduct {
    String SELECT_FROM_MILK_PRODUCT = "SELECT * FROM milk.product;";
    String INSERT_INTO_MILK_PRODUCT = "insert into product(p_name,p_price,p_weight,unit,right_alway) values(?,?,?,?);";
    String DELETE_FROM_MILK_PRODUCT = "delete from product where p_id=?;";
    String UPDATE_FROM_MILK_PRODUCT = "update product set p_name=?, p_price=?, p_weight=?, unit=? ;";
    String SELECT_FROM_MILK_PRODUCT_BY_ID="select * from product where p_name like '%'?'%';";

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
        System.out.println(INSERT_INTO_MILK_PRODUCT);
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_INTO_MILK_PRODUCT)) {
            statement.setString(1, "p_name");
            statement.setString(2, "p_price");
            statement.setString(3, "p_weight");
            statement.setString(4, "unit");
            statement.setString(5, "right_alway");
            System.out.println(statement);
            statement.executeUpdate();
        } catch (SQLException ex) {
            printSQLException(ex);
        }
    }

    @Override
    public boolean delete(String id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = getConnection()
             ; PreparedStatement statement = connection.prepareStatement(DELETE_FROM_MILK_PRODUCT)) {
            statement.setString(1, id);
            rowDelete = statement.executeUpdate() > 0;

        }
        return rowDelete;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        boolean checkUpdate;
        try(Connection connection=getConnection();
        PreparedStatement statement=connection.prepareStatement(UPDATE_FROM_MILK_PRODUCT)) {
            statement.setString(1, product.getName());
            statement.setString(2,product.getPrice());
            statement.setString(3, product.getWeight());
            statement.setString(4,product.getUnit());
            checkUpdate=statement.executeUpdate()>0;

        }
        return checkUpdate;
    }
    public List<Product>findByName(String name){
        List<Product>productList1=new ArrayList<>();
        try(Connection connection=getConnection();
        PreparedStatement statement=connection.prepareStatement(SELECT_FROM_MILK_PRODUCT_BY_ID)) {
            statement.setString(1,name);
            System.out.println(statement);
            ResultSet set=statement.executeQuery();
            while (set.next()){
                String id = set.getString("p_id");
                String name1 = set.getString("p_name");
                String price = set.getString("p_price");
                String weight = set.getString("p_weight");
                String unit = set.getString("unit");

                productList1.add(new Product(id, name1, price, weight, unit));
            }

        }
        catch (SQLException exception){
            printSQLException(exception);
        }
        return productList1;
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
                String weight = set.getString("p_weight");
                String unit = set.getString("unit");

                productList.add(new Product(id, name, price, weight, unit));
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
    public static void main(String[] args) throws SQLException {
        ProductDao productDao=new ProductDao();
        List<Product>list=productDao.findByName("chua");
//      boolean check=  productDao.delete("2");
        System.out.println(list);
    }
}
