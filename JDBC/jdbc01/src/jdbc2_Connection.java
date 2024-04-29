import java.sql.*;

public class jdbc2_Connection {
    /* 本节介绍事务处理的代码 */
    public static void main(String[] args) throws SQLException {
        // 1.注册驱动，这句代码可以注释掉，不用写
        // 2.创建连接对象 url = jdbc:mysql://ip地址:端口号/数据库名称?参数键值对1&参数键值对2
        // 参数键值对如?useSSL=false，不显示警告，
        String url = "jdbc:mysql://39.101.74.139:3306/db1";
        String username = "zmz";
        String password = "Root_1234";
        // ***创建连接数据库的管道***
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3.定义Sql语句
        String sql = "select * from dept";

        // 4.创建执行SQL语句 的对象
        Statement stmt = conn.createStatement();

        try{
            //// 开启事务 -- true表示自动提交事务，false表示手动提交事务并开启事务
            conn.setAutoCommit(false);

            // 5.执行SQL语句并返回 返回值
            ResultSet rs = stmt.executeQuery(sql);

            // 6.处理结果
            System.out.println("返回值" + rs);

            //// 提交事务
            conn.commit();
        } catch (Exception throwables){
            //// 出现异常回滚事务，并抛出异常
            conn.rollback();
            throwables.printStackTrace();
        }


        // 7.释放资源
        stmt.close();
        conn.close();
    }
}
