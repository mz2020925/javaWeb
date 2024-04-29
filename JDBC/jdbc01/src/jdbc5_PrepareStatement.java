import org.junit.Test;

import java.sql.*;

public class jdbc5_PrepareStatement {
    @Test
    public void testPreStatement() throws SQLException {
        // 2.创建连接对象 url = jdbc:mysql://ip地址:端口号/数据库名称?参数键值对1&参数键值对2
        // 参数键值对如?useSSL=false，不显示警告，和useServerPrepStmts=true
        String url = "jdbc:mysql://39.101.74.139:3306/db1?useSSL=false&useServerPrepStmts=true";
        // 使用prepareStatement时默认是不开启预编译功能的，必须加入useServerPrepStmts=true
        // 才会开启mySQL的预编译功能，能够避免执行重复代码，提高执行代码(查询代码)效率
        String username = "zmz";
        String password = "Root_1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 接收用户名和密码
        String name = "zmz";
        String passw1 = "123";  // 真密码
        // 测试SQL注入
        String passw2 = "' or '1' = '1";  // 假密码

        // 3.定义SQL语句
        String sql = "select * from users where username = ? and password = ?";
        // 4.创建执行sql语句的对象 -- 这次我们不使用createStatement()来创建，使用prepareStatement()
        PreparedStatement pstmt = conn.prepareStatement(sql);  // 此时MySQL已经进行预编译了，不会等到pstmt.executeQuery()

        // 5.执行SQL语句
        ResultSet resQuery = null;
        // 设置占位符 ? 的值
        pstmt.setString(1,name);  // 就是将用户输入的name和passw代替占位符，这里不是从 0 开始的，因为不是索引
        pstmt.setString(2,passw1);  // 在这里给占位符传递值的时候会把单引号转义成转义字符
        resQuery = pstmt.executeQuery();

        // 6.处理查询结果
        if (resQuery.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

        pstmt.setString(1,name);  // 就是将用户输入的name和passw代替占位符，这里不是从 0 开始的，因为不是索引
        pstmt.setString(2,passw2);
        resQuery = pstmt.executeQuery();
        // 6.处理查询结果
        if (resQuery.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }
}
