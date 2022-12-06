import java.util.*;

public class Kayttotili extends Tili{
    //Käyttötilille ominaisia asioita

    private String salasana;
    private Integer saldo;
    private Stack<TILITAPAHTUMA>tilitapahtumat;
    private ArrayList<String> tilitapahtumatApu;

    public Kayttotili(String haltija, int tiliId, String salasana) {
        super(haltija, tiliId);
        this.salasana = salasana;
        saldo = 0;
        tilitapahtumat = new Stack<>();
        tilitapahtumatApu = new ArrayList<>();
        asiakasTilit.put(haltija + "[käyttötili]", tiliId);
    }

    //RESULT == tilillä summa
    int getSaldo() {
        return this.saldo;
    }

    String getSalasana() {
        return this.salasana;
    }

    void setUusiSalasana() {
        Scanner x = new Scanner(System.in);
        System.out.println("Tilin haltijan nimi: ");
        String inputNimi = x.nextLine();

        for (var i : asiakasTilit.keySet()) {
            if (inputNimi.equals(i)) {
                System.out.println("Tili löytyi.");
                System.out.println("Syötä salasana: ");
                String inputSalasana = x.nextLine();
                if (inputSalasana.equals(this.getSalasana())) {
                    System.out.println("Anna uusi salasana: ");     //try-catchia tänne + salasana ehtoja
                    String uusiSalasana = x.nextLine();             // else:jä
                    salasana = uusiSalasana;
                }
            } else {
                System.out.println("Asiakasta ei löytynyt järjestelmästä.");
            }
        }
    }

    void teeTilitapahtuma(TILITAPAHTUMA tapahtuma) throws SaldoVirhe {
        Scanner x = new Scanner(System.in);
        if (tapahtuma.equals(TILITAPAHTUMA.ULOSOTTO)) {
            System.out.println("Kirjoita ulosotettava määrä: ");
            int inputMaara = Integer.parseInt(x.nextLine());
            if (inputMaara > saldo) {
                throw new SaldoVirhe("Tilillä ei ole tarpeeksi katetta.");
            } else {
                saldo -= inputMaara;
                tilitapahtumat.add(tapahtuma);
                tilitapahtumatApu.add("- " + inputMaara);
            }
        } else {
            System.out.println("Kirjoita talletettava määrä: ");
            int inputMaara = Integer.parseInt(x.nextLine());
            saldo += inputMaara;
            tilitapahtumat.add(tapahtuma);
            tilitapahtumatApu.add("+ " + inputMaara);
        }
    }

    void tiliHistoria() {
        int index = 0;
        for (var i : tilitapahtumat) {
            System.out.println(i + " " + tilitapahtumatApu.get(index)); //päivämäärät
            index++;
        }
        System.out.println("Jäljellä oleva määrä: " + this.getSaldo());
    }





}
