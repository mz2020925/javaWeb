import com.alibaba.druid.pool.DruidDataSourceFactory;
import pojo.Brand;
import org.junit.Test;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class jdbc_Demo {
    /*
     * 一.实现查询所有功能 -- QueryBrand()
     *   1.SQL语句：select * from tb_brand;
     *   2.参数：不需要
     *   3.结果：List：List<Brand>
     * */
    @Test
    public void QueryBrand() throws Exception {
        //1.导入jar包--关于Druid的代码文件: 复制到lib目录下，再 Add as Library...
        //2.编写配置文件 -- 就是druid.properties，可以按照给的资料去编写里面的代码
        //3.加载配置文件
        Properties prop = new Properties();
        System.out.println(System.getProperty("user.dir"));  // 返回整个工程所在目录
        prop.load(new FileInputStream("src/druid.properties"));
        //4.创建连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);  // 可以穿map集合(里面包含配置信息)，也可以传入Properties对象
        //5.从连接池中获取Connection对象
        Connection conn = dataSource.getConnection();

        /*
         * 实现查询所有功能:
         *   前面已经将数据连上了，现在开始编写SQL语句并执行，需要创建执行SQL语句的对象，这是通过线程池的方式获取连接对象，
         *   再通过连接对象创建执行SQL语句的对象 -- conn.prepareStatement(sql)，调用这个对象的方法executeQuery()就执行了SQL语句。
         *   之前直接创建连接对象时，创建执行SQL语句的对象是这样 -- conn.createStatement()。
         * */
        // 6.创建执行SQL语句的对象并执行SQL语句
        String sql = "select * from tb_brand";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet resQuery = pstmt.executeQuery();

        // 7.处理SQL语句执行的结果
        Brand brand = null;
        List<Brand> listBrand = new ArrayList<>();
        while (resQuery.next()) {
            // 获取表中一行数据
            int id = resQuery.getInt("id");// 主键
            String brand_name = resQuery.getString("brand_name");// 品牌名称
            String company_name = resQuery.getString("company_name");// 企业名称
            String description = resQuery.getString("description");// 描述信息
            int ordered = resQuery.getInt("ordered");// 排序字段
            int status = resQuery.getInt("status");
            // 将这一行数据封装成对象
            brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brand_name);
            brand.setCompanyName(company_name);
            brand.setDescription(description);
            brand.setOrdered(ordered);
            brand.setStatus(status);
            // 将这个一行对象装入集合
            listBrand.add(brand);
        }
        // 查看数据获取情况 -- 打印对象集合
        System.out.println(brand);  // 查看这个类引用是否为null，若是，则while结束时会释放掉brand中的内容，若不是，则while结束时不会释放，但是每次给brand赋值会覆盖掉之前的内容
        System.out.println("----------");
        System.out.println(listBrand);
        // 8.释放资源
        resQuery.close();  // 执行SQL语句对象执行完SQL语句后，的返回对象，这个对象也占用了资源，需要手动释放
        pstmt.close();  //
        conn.close();
    }


    /*
     * 二.实现向添加一行数据 -- addBrand()
     *   1.SQL语句：insert into tb_brand (brand_name,company_name,description,ordered,status) values (?,?,?,?,?);
     *   2.参数: 需要提供除id之外的参数值
     *   3.结果：返回boolean类型的值，添加成功或失败
     * */
    @Test
    public void insertBrand() throws Exception {
        //1.导入jar包--关于Druid的代码文件: 复制到lib目录下，再 Add as Library...
        //2.编写配置文件 -- 就是druid.properties，可以按照给的资料去编写里面的代码
        //3.加载配置文件
        Properties prop = new Properties();
        System.out.println(System.getProperty("user.dir"));  // 返回整个工程所在目录
        prop.load(new FileInputStream("src/druid.properties"));
        //4.创建连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);  // 可以穿map集合(里面包含配置信息)，也可以传入Properties对象
        //5.从连接池中获取Connection对象
        Connection conn = dataSource.getConnection();

        /*
         * 实现向添加一行数据：
         * */
        // 模拟前端发送来一行数据
        String brand_name = "苹果";
        String company_name = "Apple有限公司";
        String description = "灵动岛";
        int ordered = 4;
        int status = 1;

        // 6.创建执行SQL语句的对象并执行SQL语句
        // 创建执行SQL语句的对象
        String sql = "insert into tb_brand (brand_name,company_name,description,ordered,status) values (?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        // 执行SQL语句
        pstmt.setString(1, brand_name);
        pstmt.setString(2, company_name);
        pstmt.setString(3, description);
        pstmt.setInt(4, ordered);
        pstmt.setInt(5, status);
        int count = pstmt.executeUpdate();
        // 7.处理SQL语句执行的结果
        if (count > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }

        // 8.释放资源
        pstmt.close();
        conn.close();
    }


    /*
     * 三.修改一行数据 -- setBrand()
     *   1.SQL语句：update tb_brand set brand_name=?,company_name=?,description=?,ordered=?,STATUS=? where id=?;
     *   2.参数: 需要提供除所有的参数值 -- Brand类的所有成员变量
     *   3.结果：返回boolean类型的值，修改成功或失败
     * */
    @Test
    public void setBrand() throws Exception {
        //1.导入jar包--关于Druid的代码文件: 复制到lib目录下，再 Add as Library...
        //2.编写配置文件 -- 就是druid.properties，可以按照给的资料去编写里面的代码
        //3.加载配置文件
        Properties prop = new Properties();
        System.out.println(System.getProperty("user.dir"));  // 返回整个工程所在目录
        prop.load(new FileInputStream("src/druid.properties"));
        //4.创建连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);  // 可以穿map集合(里面包含配置信息)，也可以传入Properties对象
        //5.从连接池中获取Connection对象
        Connection conn = dataSource.getConnection();

        /*
         * 修改一行数据：
         * */
        // 模拟前端发送来一行数据
        int id = 1;
        String brand_name = "三只松鼠";
        String company_name = "三只松鼠股份有限公司";
        String description = "好吃又上火哈哈哈哈哈";
        int ordered = 300;
        int status = 1;

        // 6.创建执行SQL语句的对象并执行SQL语句
        // 创建执行SQL语句的对象
        String sql = "update tb_brand set brand_name=?,company_name=?,description=?,ordered=?,STATUS=? where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        // 执行SQL语句
        pstmt.setString(1, brand_name);
        pstmt.setString(2, company_name);
        pstmt.setString(3, description);
        pstmt.setInt(4, ordered);
        pstmt.setInt(5, status);
        pstmt.setInt(6, id);
        int count = pstmt.executeUpdate();
        // 7.处理SQL语句执行的结果
        if (count > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }

        // 8.释放资源
        pstmt.close();
        conn.close();
    }


    /*
     * 四.删除一行数据 -- setBrand()
     *   1.SQL语句：delete from tb_brand where id=?;
     *   2.参数: 需要提供id,我需要知道删除哪行数据
     *   3.结果：返回boolean类型的值，删除成功或失败
     * */
    @Test
    public void deleteBrand() throws Exception {
        //1.导入jar包--关于Druid的代码文件: 复制到lib目录下，再 Add as Library...
        //2.编写配置文件 -- 就是druid.properties，可以按照给的资料去编写里面的代码
        //3.加载配置文件
        Properties prop = new Properties();
        System.out.println(System.getProperty("user.dir"));  // 返回整个工程所在目录
        prop.load(new FileInputStream("src/druid.properties"));
        //4.创建连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);  // 可以穿map集合(里面包含配置信息)，也可以传入Properties对象
        //5.从连接池中获取Connection对象
        Connection conn = dataSource.getConnection();

        /*
         * 删除一行数据：
         * */
        // 模拟前端发送来一行数据
        int id = 1;

        // 6.创建执行SQL语句的对象并执行SQL语句
        // 创建执行SQL语句的对象
        String sql;
        sql = "delete from tb_brand where id=?";
        PreparedStatement pstmt;
        pstmt = conn.prepareStatement(sql);
        // 执行SQL语句
        pstmt.setInt(1, id);
        int count = pstmt.executeUpdate();

        sql = "alter table tb_brand auto_increment=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, 1);
        // 7.处理SQL语句执行的结果
        if (count > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }

        // 8.释放资源
        pstmt.close();
        conn.close();
    }

}
