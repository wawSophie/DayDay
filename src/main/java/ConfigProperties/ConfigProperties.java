package ConfigProperties;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Author:Sophie
 * Created: 2019/8/18
 */
@Data
public class ConfigProperties {
    private String db_username;
    private String db_password;
    private String db_url;
    private String db_driverclass;
    InputStream inputStream=ConfigProperties.class.getClassLoader().getResourceAsStream("config.properties");
    Properties p=new Properties();
    public ConfigProperties(){
        try {
            p.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.db_username= String.valueOf(p.get("db.username"));
        this.db_password= String.valueOf(p.get("db.password"));
        this.db_url= String.valueOf(p.get("db.url"));
        this.db_driverclass= String.valueOf(p.get("db.driver_class"));
    }
}
