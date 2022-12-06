import java.util.Arrays;
import java.util.HashMap;

abstract class Tili {
    //Kaikille tileille yhteisiä attribuutteja

    private String haltija;
    private int tiliId;
    protected static HashMap<String, Integer> asiakasTilit;


    Tili(String haltija, int tiliId) {
        this.haltija = haltija;
        this.tiliId = tiliId;
        asiakasTilit = new HashMap<>();
    }

    String getHaltija() {
        return this.haltija;
    }

    int getId() {
        return this.tiliId;
    }

     static void getAsiakkaat() {
        System.out.println(asiakasTilit);
    }




}
