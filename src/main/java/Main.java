import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws SaldoVirhe {
        System.out.println("Eka printti.");

        EnumMap<OSAKKEET, Double> pörssi = new EnumMap<OSAKKEET, Double>(OSAKKEET.class);
        pörssi.put(OSAKKEET.FORTUM, 14.84);
        pörssi.put(OSAKKEET.SAMPO, 48.07);
        pörssi.put(OSAKKEET.NOKIA, 4.69);
        pörssi.put(OSAKKEET.KONE, 47.63);
        pörssi.put(OSAKKEET.APPLE, 148.11);
        pörssi.put(OSAKKEET.TESLA, 182.86);
        pörssi.put(OSAKKEET.AMAZON, 93.41);
        pörssi.put(OSAKKEET.MICROSOFT, 247.49);
        pörssi.put(OSAKKEET.VALMET, 24.92);
        pörssi.put(OSAKKEET.WÄRTSILÄ, 8.29);
        pörssi.put(OSAKKEET.YIT, 2.69);
        System.out.println(pörssi);


        Kayttotili test1 = new Kayttotili("William", 989898, "Kissapaistos7");
        Kayttotili test2 = new Kayttotili("Testi", 878787, "Kookospaistos5");
        Kayttotili test3 = new Kayttotili("Santeri", 767676, "Kalapaistos0");

        Sijoutustili stest1 = new Sijoutustili("William", 656565, "Kurpitsalehti2");

        stest1.yhdistäKäyttötiliin(test1);

        Tili.getAsiakkaat();





    }
}
