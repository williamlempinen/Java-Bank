import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Eka printti.");

        Kayttotili test1 = new Kayttotili("William", 989898, "Mustakiekko7");
        System.out.println(test1.getHaltija());

        //test1.setSalasana();
        test1.teeTilitapahtuma(TILITAPAHTUMA.TALLETUS);
        test1.teeTilitapahtuma(TILITAPAHTUMA.TALLETUS);
        test1.teeTilitapahtuma(TILITAPAHTUMA.TALLETUS);
        test1.teeTilitapahtuma(TILITAPAHTUMA.ULOSOTTO);

        test1.tiliHistoria();





    }
}
