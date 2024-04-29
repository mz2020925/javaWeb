import org.junit.Test;

import java.sql.*;

public class jdbc5_Inject {
    @Test
    public void testPreStatement() throws SQLException {
        // 2.创建连接对象 url = jdbc:mysql://ip地址:端口号/数据库名称?参数键值对1&参数键值对2
        // 参数键值对如?useSSL=false，不显示警告，
        String url = "jdbc:mysql://39.101.74.139:3306/db1?useSSL=false";
        String username = "zmz";
        String password = "Root_1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 接收用户名和密码
        String name = "zmz";
        String passw1 = "123";  // 真密码
        // 测试SQL注入
        String passw2 = "' or '1' = '1";  // 假密码

        // 3.定义SQL语句
        String sql = "select * from users where username = '"+name+"' and password = '"+passw2+"'";
        // 4.创建执行sql语句的对象
        Statement stmt = conn.createStatement();
        // 5.执行SQL查询语句并返回 返回值
        ResultSet resOfquery = stmt.executeQuery(sql);

        // 6.处理查询结果
        if (resOfquery.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }

}
