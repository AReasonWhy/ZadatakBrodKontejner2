package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Brod;
import model.Kontejner;

import java.io.IOException;
import java.util.List;

import static zadaci.Zadatak2DodavanjeVrednosti.brodDao;
import static zadaci.Zadatak2DodavanjeVrednosti.kontejnerDao;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class Zadatak4BrisanjeVrednosti {
    public static void main(String[] args){
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");


            brodDao = DaoManager.createDao(connectionSource, Brod.class);
            kontejnerDao = DaoManager.createDao(connectionSource, Kontejner.class);

            List<Kontejner> kontejner = kontejnerDao.queryForAll();

            for (Kontejner r : kontejner){
                System.out.println(r);
            }

            Kontejner izmena = kontejnerDao.queryForEq(Kontejner.POLJE_OZNAKA, "KP2").get(0);

            kontejnerDao.delete(izmena);

            kontejner = kontejnerDao.queryForAll();

            for (Kontejner r : kontejner){
                System.out.println(r);
            }



        } catch (Exception e) {
            e.printStackTrace();
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
