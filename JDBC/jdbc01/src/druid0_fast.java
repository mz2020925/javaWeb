import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class druid0_fast {
    /*它是一个中间容器，存储和管理数据库连接对象的
    * */
    @Test
    public void testDruid() throws Exception {

        //1.导入jar包--关于Druid的代码文件: 复制到lib目录下，再 Add as Library...

        //2.编写配置文件 -- 就是druid.properties，可以按照给的资料去编写里面的代码

        //3.加载配置文件
        Properties prop = new Properties();
        // System.out.println(System.getProperty("user.dir"));  // 返回整个工程所在目录
        prop.load(new FileInputStream("src/druid.properties"));

        //4.创建连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);  // 可以穿map集合(里面包含配置信息)，也可以传入Properties对象

        //5.从连接池中获取Connection对象
        Connection conn = dataSource.getConnection();

        /* 开始使用这个连接对象 */
        // 接收用户名和密码
        String name = "zmz";
        String passw = "123";  // 真密码
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
        pstmt.setString(2,passw);  // 真密码
        resQuery = pstmt.executeQuery();

        // 6.处理查询结果
        if (resQuery.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

        pstmt.setString(1,name);  // 就是将用户输入的name和passw代替占位符，这里不是从 0 开始的，因为不是索引
        pstmt.setString(2,passw2);  // 假密码
        resQuery = pstmt.executeQuery();

        // 6.处理查询结果
        if (resQuery.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }
}
