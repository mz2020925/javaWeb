import java.sql.*;

public class jdbc0_fast {
    /* 本节介绍连接数据库 */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.注册驱动，这句代码可以注释掉，不用写。
        // 什么叫注册驱动，就是告诉Java语言现在的jar包是针对MySQL数据库管理系统的
        Class.forName("com.mysql.jdbc.Driver");

        // 2.创建连接对象 url = jdbc:mysql://ip地址:端口号/数据库名称?参数键值对1&参数键值对2
        // 参数键值对如?useSSL=false，不显示警告，
        String url = "jdbc:mysql://39.101.74.139:3306/db1";
        String username = "zmz";
        String password = "Root_1234";
        // ***创建连接数据库的管道***
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3.定义Sql语句
        String sql = "select * from emp";

        // 4.创建执行SQL语句 的对象
        // ***在管道的基础上创建水泵***
        Statement stmt = conn.createStatement();

        // 5.执行SQL语句并返回
        // ***使用水泵将SQL命令送到数据库管理系统执行
        // int count1 = stmt.executeUpdate(sql1);  // 返回受影响的行数
        ResultSet rs = stmt.executeQuery(sql);  // 返回查询结果

        // 6.处理结果
        System.out.println(rs);

        // 7.释放资源
        stmt.close();
        conn.close();

    }
}
