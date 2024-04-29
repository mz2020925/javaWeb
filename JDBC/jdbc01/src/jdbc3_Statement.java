import java.sql.*;

public class jdbc3_Statement {
    /* 本节介绍查询和修改数据库的代码 */
    public static void main(String[] args) throws SQLException {
        // 1.注册驱动，这句代码可以注释掉，不用写
        // 2.创建连接对象 url = jdbc:mysql://ip地址:端口号/数据库名称?参数键值对1&参数键值对2
        // 参数键值对如?useSSL=false，不显示警告，
        String url = "jdbc:mysql://39.101.74.139:3306/db1";
        String username = "zmz";
        String password = "Root_1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3.定义Sql语句
        String sql = "select * from dept";
        String sql2 = "update dept set addr='合肥' where id=1";
        String sql3 = "create database db2";
        // String sql4 = "drop database db2";

        // 4.创建执行SQL语句 的对象
        Statement stmt = conn.createStatement();

        // 5.执行SQL语句并返回 返回值
        ResultSet resOfquery = stmt.executeQuery(sql);  // 执行DQL命令
        int resOfUpdate = stmt.executeUpdate(sql2);  // 执行DDL命令或者DML命令
        int resOfUpdate2 = stmt.executeUpdate(sql3);  // 执行DDL命令或者DML命令

        // 6.处理结果，注意删除表、库的返回值是0，所以不能用resOfUpdate > 0判断
        System.out.println(resOfquery);
        if (resOfUpdate > 0){
            System.out.println("修改成功。");
        }else {
            System.out.println("修改失败。");
        }

        // 7.释放资源
        stmt.close();
        conn.close();
    }
}
