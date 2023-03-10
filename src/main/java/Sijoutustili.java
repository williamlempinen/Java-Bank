import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Sijoutustili extends Tili{
    //Erillinen tili, johon voidaan sijoittaa osakkeita ja niiden omistusosuus

    private String salasana;
    private HashMap<OSAKKEET, Double> omistukset;
    private Kayttotili käyttöTili;
    private Integer saldo;

    public Sijoutustili(String haltija, int tiliId, String salasana) {
        super(haltija, tiliId);
        this.salasana = salasana;
        this.käyttöTili = null;
        this.saldo = 0;
        omistukset = new HashMap<>();
        asiakasTilit.put(this.getHaltija() + "[sijoitustili]", this.getId());
    }

    void yhdistäKäyttötiliin(Kayttotili inputKayttotili) {
        Scanner x = new Scanner(System.in);
        System.out.println("Tilin haltijan nimi: ");
        String inputNimi = x.nextLine();

        for (var i : asiakasTilit.keySet()) {
            if (inputNimi.equals(i)) {
                System.out.println("Tili löytyi.");
                System.out.println("Syötä salasana: ");
                String inputSalasana = x.nextLine();
                if (inputSalasana.equals(inputKayttotili.getSalasana())) {
                    this.käyttöTili = inputKayttotili;
                    System.out.println("Käyttötili yhdistetty sijoitustilin kanssa.");
                    System.out.println("Käyttötilillä oleva summa: " + käyttöTili.getSaldo());
                } else {
                    System.out.println("Salasana väärin.");
                }
            } else {
                System.out.println("Nimellä ei löytynyt olemassa olevia tilejä.");
            }
        }
    }

    int getSaldo() {
        return this.saldo;
    }

    void talletaRahaa(int määrä) {
        this.saldo += määrä;
        System.out.println("Tilillä rahaa: " + this.saldo);
    }

    void ostaOsakkeita(OSAKKEET osake, Double maara) {

    }



    void getOmistukset() {
        for (var i : omistukset.keySet()) {
            System.out.println("Osake: " + i + ", määrä: " + omistukset.get(i));
        }
    }




}
