import java.sql.*;

public class jdbc1_DriverManager {
    /* 本节介绍连接数据库 */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.注册驱动，这句代码可以注释掉，不用写
        Class.forName("com.mysql.jdbc.Driver");

        // 2.创建连接对象 url = jdbc:mysql://ip地址:端口号/数据库名称?参数键值对1&参数键值对2
        // 参数键值对如?useSSL=false，不显示警告，
        String url = "jdbc:mysql://39.101.74.139:3306/db1";
        String username = "zmz";
        String password = "Root_1234";
        // ***创建连接数据库的管道***
        Connection conn = DriverManager.getConnection(url, username, password);

        // ......

        // 7.释放资源
        conn.close();

    }
}
