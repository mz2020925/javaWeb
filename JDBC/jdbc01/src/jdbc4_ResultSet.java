import java.sql.*;

public class jdbc4_ResultSet {
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

        // 6.结果处理
        // System.out.println(resOfquery);
        while (resOfquery.next()) {
            // getInt()中可以写列编号（从1开始），也可以写列名称
            int id = resOfquery.getInt(1);
            // int id = resOfquery.getInt("id");
            String name = resOfquery.getString(2);
            int age = resOfquery.getInt(3);
            int dep_id = resOfquery.getInt(4);
            System.out.printf("%d, %s, %d, %d\n", id, name, age, dep_id);
        }

        // 7.释放资源
        resOfquery.close();
        stmt.close();
        conn.close();
    }
}
