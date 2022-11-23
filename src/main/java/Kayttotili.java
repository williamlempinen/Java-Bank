import java.util.*;

public class Kayttotili extends Tili{
    //Käyttötilille ominaisia asioita

    private String salasana;
    private int saldo;
    private Stack<TILITAPAHTUMA>tilitapahtumat;
    private ArrayList<String> tilitapahtumatApu;

    public Kayttotili(String haltija, int tiliId, String salasana) {
        super(haltija, tiliId);
        this.salasana = salasana;
        saldo = 0;
        tilitapahtumat = new Stack<>();
        tilitapahtumatApu = new ArrayList<>();
    }

    //RESULT == tilillä summa
    int getSaldo() {
        return this.saldo;
    }

    void setSalasana() {
        Scanner x = new Scanner(System.in);
        System.out.println("Tilin haltijan nimi: ");
        String inputNimi = x.nextLine();
        if (inputNimi.equals(super.getHaltija())) {
            System.out.println("Tilin id numero: ");
            int inputId = Integer.parseInt(x.nextLine());
            if (inputId == super.getId()) {
                System.out.println("Anna uusi salasana: ");     //try-catchia tänne + salasana ehtoja
                String uusiSalasana = x.nextLine();             // else:jä
                salasana = uusiSalasana;
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
