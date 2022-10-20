import java.util.Stack;

public class Kayttotili extends Tili{
    //Käyttötilille ominaisia asioita

    private String salasana;
    private int summa;
    private Stack<TILITAPAHTUMA> tilitapahtumat;

    public Kayttotili(String haltija, int tiliId, String salasana) {
        super(haltija, tiliId);
        this.salasana = salasana;
        summa = 0;
        tilitapahtumat = new Stack<>();
    }


}
