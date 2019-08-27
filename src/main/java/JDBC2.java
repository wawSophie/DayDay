import ConfigProperties.ConfigProperties;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.xa.DruidXADataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Author:Sophie
 * Created: 2019/8/19
 */
public class JDBC2 {
    public static void main(String[] args) {

        ConfigProperties configProperties=new ConfigProperties();
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUsername(configProperties.getDb_username());
        dataSource.setPassword(configProperties.getDb_password());
        dataSource.setUrl(configProperties.getDb_url());
        dataSource.setDriverClassName(configProperties.getDb_driverclass());

        try {
            Connection connection=dataSource.getConnection();
            String sql="insert into customer(customer_id,name) values(20,\"第20号学生\")";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            if (preparedStatement!=null){
                preparedStatement.close();
            }
            if (connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
