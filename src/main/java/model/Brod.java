package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by androiddevelopment on 20.1.17..
 */
@DatabaseTable
public class Brod {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_OZNAKA,canBeNull = false)
    private String oznaka;
    @DatabaseField(columnName = POLJE_NAZIV,canBeNull = false)
    private String naziv;

    public static final String POLJE_OZNAKA ="oznaka";
    public static final String POLJE_NAZIV ="naziv";

    @ForeignCollectionField(foreignFieldName = "Brod")
    private ForeignCollection<Kontejner> kontejner;

    public Brod(){

    }

    public Brod(String naziv, String oznaka){
        this.naziv = naziv;
        this.oznaka = oznaka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString(){
        return "Brod{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", sa oznakom='" + oznaka + '\'' +
                '}';
    }
}
