package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Brod;
import model.Kontejner;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class Zadatak1KreiranjeTabela {
    public static void main(String[] args){
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");

            TableUtils.dropTable(connectionSource, Kontejner.class,true);
            TableUtils.dropTable(connectionSource, Brod.class,true);


            TableUtils.createTable(connectionSource, Brod.class);
            TableUtils.createTable(connectionSource,Kontejner.class);



        } catch ( Exception e ){
            System.out.println("Greska");
        }

    }
}
