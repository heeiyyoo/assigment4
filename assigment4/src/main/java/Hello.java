import java.sql.*;

public class Hello {
    public static void main(String[] args) throws SQLException {
//        String connectionUrl = "jdbc:mysql://localhost:3306/spring_crud_sql";
//        String username = "root";
//        String password = "topsecretpassword";
//        Connection connection = DriverManager.getConnection(connectionUrl, username, password);
//        Statement ps = connection.createStatement();

        // PERFORM QUERY TO READ DATA
//        ResultSet rs = ps.executeQuery("SELECT * FROM project");
//        while (rs.next()) {
//            System.out.println(rs.getString("author_id"));
//        }

        // PERFORM QUERY TO WRITE DATA
//        PreparedStatement psw = connection.prepareStatement("INSERT INTO `project_v2` (`description`, `end_date`) VALUES (?, ?);");
//        psw.setString(1, "alabala");
//        psw.setInt(2, 123);
//        psw.execute();

        //insert(new Customer(3, "Ion_x", "Glanetasu", "Ion", "074444444", "Str Independ",
                //"Bucuresti", "625400", "Romania"));
        Date date1 = Date.valueOf("1980-04-09");
        Date date2 = Date.valueOf("1980-04-10");
        //neworder((new Orders(1,date1,date2,"post","no comment",2)));
        int id = 2;
        String username = "Gigel";
        //update(id,username);
        //getById(1);
        //getaLL();
        //viewOrder(2);
        //updateStatusOrder(1,username);
        //updateCommentsOrder(1,"comment");
        placeorder(1);
    }
    public static void getById(int id) throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/newdb";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);
        PreparedStatement psw = connection.prepareStatement("Select * from `customers` where id = (?);");
        psw.setInt(1, id);
        ResultSet rs = psw.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        while(rs.next()) {
            for(int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                Object object = rs.getObject(columnIndex);
                System.out.printf("%s, ", object == null ? "NULL" : object.toString());
            }
            System.out.println();
        }
    }
    public static void getaLL() throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/newdb";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from `customers`;");
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        while(rs.next()) {
            for(int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                Object object = rs.getObject(columnIndex);
                System.out.printf("%s, ", object == null ? "NULL" : object.toString());
            }
            System.out.println();
        }
    }

    public static void update(int id,String username1) throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/newdb";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        PreparedStatement psw = connection.prepareStatement("UPDATE`customers`  set username = (?) WHERE id = (?);");
        psw.setInt(2, id);
        psw.setString(1, username1);
        psw.execute();
    }

    public static void insert(Customer customer) throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/newdb";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        PreparedStatement psw = connection.prepareStatement("INSERT INTO `customers` (`id`, `username`, `last_name`, `first_name`, `phone`, `address`, `city`, `postalCode`, `country`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
        psw.setInt(1, customer.getID());
        psw.setString(2, customer.getUsername());
        psw.setString(3, customer.getLast_name());
        psw.setString(4, customer.getFirst_name());
        psw.setString(5, customer.getPhone());
        psw.setString(6, customer.getAddress());
        psw.setString(7, customer.getCity());
        psw.setString(8, customer.getPostalCode());
        psw.setString(9, customer.getCountry());
        psw.execute();
    }

    public static void delete(int x) throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/newdb";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        PreparedStatement psw = connection.prepareStatement("DELETE from `customers` where id = (?);");
        psw.setInt(1, x);
        psw.execute();
    }
    public static void neworder(Orders Order) throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/newdb";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        PreparedStatement psw = connection.prepareStatement("INSERT INTO `orders` (`id`, `order_date`, `shipped_date`, `status`, `comments`, `customer_id` ) VALUES ( ?, ?, ?, ?, ?, ?);");
        psw.setInt(1, Order.getId());
        psw.setDate(2, Order.getOrder_date());
        psw.setDate(3, Order.getShipped_date());
        psw.setString(4, Order.getStatus());
        psw.setString(5, Order.getComments());
        psw.setInt(6, Order.getCustomer_id());
        psw.execute();
    }

    public static void viewOrder(int id) throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/newdb";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);
        Statement stmt = connection.createStatement();
        PreparedStatement psw = connection.prepareStatement("Select * from `orders` where customer_id = (?);");
        psw.setInt(1, id);
        ResultSet rs = psw.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        while(rs.next()) {
            for(int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                Object object = rs.getObject(columnIndex);
                System.out.printf("%s, ", object == null ? "NULL" : object.toString());
            }
            System.out.println();
        }

    }


    public static void updateStatusOrder(int id,String status) throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/newdb";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);
        Statement stmt = connection.createStatement();
        PreparedStatement psw = connection.prepareStatement("UPDATE `orders` set status =(?) where id = (?);");
        psw.setInt(2, id);
        psw.setString(1, status);
        psw.executeUpdate();


    }
    public static void updateCommentsOrder(int id,String comment) throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/newdb";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);
        Statement stmt = connection.createStatement();
        PreparedStatement psw = connection.prepareStatement("UPDATE `orders` set comments =(?) where id = (?);");
        psw.setInt(2, id);
        psw.setString(1, comment);
        psw.executeUpdate();


    }

    public static void placeorder(int id) throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/newdb";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);
        Statement stmt = connection.createStatement();
        PreparedStatement psw = connection.prepareStatement("Select product_code, quantity from orderdetails where id=(?);");
        psw.setInt(1,id);
        ResultSet rs = psw.executeQuery();
        rs.next();
        Object object = rs.getObject(1);
        String product_code = object.toString();
        Object object1 = rs.getObject(2);
        String quantity = object1.toString();
        int quantitynumber = Integer.parseInt(quantity);

        PreparedStatement psw1 = connection.prepareStatement("Select stock from products where code = (?);");
        psw1.setString(1,product_code);
        ResultSet rs1 = psw1.executeQuery();
        rs1.next();
        Object object2 = rs1.getObject(1);
        String stock = object2.toString();
         int stocknumber = Integer.parseInt(stock);
        int finalnumber = stocknumber - quantitynumber;

        PreparedStatement psw2 = connection.prepareStatement("UPDATE `products` set stock = (?) where code = (?);");
        psw2.setString(2,product_code);
        psw2.setInt(1,finalnumber);
        psw2.executeUpdate();

    }

}