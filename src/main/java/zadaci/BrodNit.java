package zadaci;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Brod;

import java.io.IOException;
import java.util.List;
import java.util.Random;


import static java.lang.Thread.sleep;

import static zadaci.Zadatak2DodavanjeVrednosti.brodDao;

/**
 * Created by androiddevelopment on 20.1.17..
 */



public class BrodNit extends Thread {

    public static Integer brojPristiglihBrodova = 0;

    private Brod bord;

    public void run(){
        synchronized (brojPristiglihBrodova) {

            System.out.println("Brod " + Brod.getoznaka() + " je napustio luku.");

            Random random = new Random();

            try {
                sleep(2500 + random.nextInt(2500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            brojPristiglihBrodova = brojPristiglihBrodova + 1;


            System.out.println("Brod " + Brod.getoznaka() + " je stigao na odrediste");
            //nisam stigao da proverim zasto mi get ne radi
        }

    }


    public static void main(String[] args){
        ConnectionSource connectionSource = null;




        try {

            connectionSource=new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");
            brodDao= DaoManager.createDao(connectionSource, Brod.class);

            List<Brod> sviAvioni = brodDao.queryForAll();

            BrodNit bn1 = new BrodNit(sviBrodovi.get(0));
            BrodNit bn1 = new BrodNit(sviBrodovi.get(2));
            BrodNit bn1 = new BrodNit(sviBrodovi.get(3));
            BrodNit bn1 = new BrodNit(sviBrodovi.get(4));


            bn1.start();
            bn2.start();
            bn3.start();
            bn4.start();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connectionSource != null) {
                try {
                    //Zatvaranje konekcije sa bazom
                    connectionSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
