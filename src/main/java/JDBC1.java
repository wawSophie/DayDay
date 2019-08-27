import ConfigProperties.ConfigProperties;

import java.sql.*;

/**
 * Author:Sophie
 * Created: 2019/8/18
 */
public class JDBC1 {
    public static void main(String[] args) {
        ConfigProperties configProperties=new ConfigProperties();

        try {
            //加载驱动
//            Class.forName(configProperties.getDb_driverclass());
            //建立连接
            Connection connection=DriverManager.getConnection(configProperties.getDb_url(),configProperties.getDb_username(),configProperties.getDb_password());
//            connection.setAutoCommit(false);

            //准备sql语句，创建操作命令
//            String sql="insert into  customer(customer_id,name) values(?,?)";
            String sql1="delete from customer where ";
//            PreparedStatement statement=connection.prepareStatement(sql);
            Statement statement1=connection.createStatement();
            int re=statement1.executeUpdate(sql1+"1=1");
            System.out.println(re);
            if (statement1!=null){
                statement1.close();
            }
            if (connection!=null){
                connection.close();
            }
//            批量插入
//            for (int i=0;i<10;i++){
//                sql+="";
//                statement.setString(1,String.valueOf(i));
//                statement.setString(2,"第"+i+"名同学");
//                statement.addBatch();
//            }
//
//            statement.executeBatch();
//            connection.commit();
//              ResultSet set=statement1.executeQuery(sql1+"or 1=1");
//              while (set.next()){
//                  System.out.println(set.getString("name"));
//              }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
