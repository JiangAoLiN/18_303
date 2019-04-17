package utils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DSUtils {
    public static DataSource ds;
    static {
        ds = new ComboPooledDataSource();
    }
    public static DataSource getDataSourse(){
        return ds;
    }
    public static Connection getConnetion(){
        Connection conn;
        try{
            conn = ds.getConnection();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return conn;
    }

    @Test
    public void test() throws Exception {

        System.out.println(DSUtils.getConnetion());

    }

}
