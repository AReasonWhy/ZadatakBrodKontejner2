package zadaci;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class Zadatak3IzmenaVrednosti {
    public static void main(String[] args){
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");



        } catch ( Exception e ){
            System.out.println("Greska");
        }

    }
}
