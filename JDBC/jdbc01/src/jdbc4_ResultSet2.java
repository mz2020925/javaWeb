import pojo.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbc4_ResultSet2 {
    public static void main(String[] args) throws SQLException {
        // 1.注册驱动，这句代码可以注释掉，不用写
        // Class.forName("com.mysql.jdbc.Driver");

        // 2.创建连接对象 url = jdbc:mysql://ip地址:端口号/数据库名称?参数键值对1&参数键值对2
        // 参数键值对如?useSSL=false，不显示警告，
        String url = "jdbc:mysql://39.101.74.139:3306/db1?useSSL=false";
        String username = "zmz";
        String password = "Root_1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3.定义Sql语句
        String sql = "select * from emp";

        // 4.创建执行SQL语句 的对象
        Statement stmt = conn.createStatement();

        // 5.执行SQL语句并返回 返回值
        ResultSet resOfquery = stmt.executeQuery(sql);

        // 6.结果处理 -- 将获取的数据封装成多个java对象，并把对象存入容器：如java中的 ”集合“来存储对象
        List<Emp> ls = new ArrayList<>();
        resOfquery.first();
        while (resOfquery.next()) {
            int id = resOfquery.getInt("id");
            String name = resOfquery.getString("name");
            int age = resOfquery.getInt("age");
            int dep_id = resOfquery.getInt("dep_id");
            Emp emp = new Emp(id, name, age, dep_id);
            System.out.println(emp);
        }
        System.out.println(ls);

        // 7.释放资源
        resOfquery.close();
        stmt.close();
        conn.close();
    }
}
