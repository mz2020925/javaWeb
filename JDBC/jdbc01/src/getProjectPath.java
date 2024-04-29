import org.junit.Test;

public class getProjectPath {
    public static void main(String[] args) {
        getPath();
        // 方法getPath()打印的却是 E:\Coding_Files\IntelliJ_IDEA_Files\javaWeb\JDBC
        // 但是方法getPath2()打印的却是 E:\Coding_Files\IntelliJ_IDEA_Files\javaWeb\JDBC\jdbc01
        // 原因：方法getPath()被static修饰，但是getPath2()没有被static修饰。
    }

    public static void getPath() {
        System.out.println(System.getProperty("user.dir"));
    }

    @Test
    public void getPath2() {
        System.out.println(System.getProperty("user.dir"));
    }
}
