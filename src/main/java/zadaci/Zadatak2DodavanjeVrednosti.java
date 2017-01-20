package zadaci;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Brod;
import model.Kontejner;

import java.io.IOException;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class Zadatak2DodavanjeVrednosti {

    static Dao<Brod, Integer> brodDao;
    static Dao<Kontejner, Integer> kontejnerDao;

    public static void main(String[] args){
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");

            brodDao = DaoManager.createDao(connectionSource, Brod.class);
            kontejnerDao = DaoManager.createDao(connectionSource, Kontejner.class);

            Brod b1 = new Brod("Transporter1", "Brod1");
            Brod b2 = new Brod("Transporter2", "Brod2");

            brodDao.create(b1);
            brodDao.create(b2);

            //oznaka>opis>tezina
            Kontejner k1 = new Kontejner("KP1", "Namestaj", 100);
            k1.setBrod(b1);
            Kontejner k2 = new Kontejner("KP2", "Banana", 1000.5);
            k1.setBrod(b1);
            Kontejner k3 = new Kontejner("KP3", "Morski proizvodi", 200.7);
            k1.setBrod(b1);
            Kontejner k4 = new Kontejner("KP4", "Mercedes", 500.4);
            k1.setBrod(b1);
            Kontejner k5 = new Kontejner("KP5", "Klavir", 100);
            k1.setBrod(b1);

            kontejnerDao.create(k1);
            kontejnerDao.create(k2);
            kontejnerDao.create(k3);
            kontejnerDao.create(k4);
            kontejnerDao.create(k5);



        } catch ( Exception e ){e.printStackTrace();
        }finally {
            if (connectionSource != null) {
                try {
                    connectionSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
