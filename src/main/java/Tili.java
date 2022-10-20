
abstract class Tili {
    //Kaikille tileille yhteisiä attribuutteja

    private String haltija;
    private int tiliId;


    public Tili(String haltija, int tiliId) {
        this.haltija = haltija;
        this.tiliId = tiliId;
    }

    String getHaltija() {
        return this.haltija;
    }






}
