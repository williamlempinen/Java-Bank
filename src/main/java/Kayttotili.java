import java.util.*;

public class Kayttotili extends Tili{
    //Käyttötilille ominaisia asioita

    private String salasana;
    private int summa;
    private Stack<TILITAPAHTUMA>tilitapahtumat;
    private ArrayList<String> tilitapahtumatApu;

    public Kayttotili(String haltija, int tiliId, String salasana) {
        super(haltija, tiliId);
        this.salasana = salasana;
        summa = 0;
        tilitapahtumat = new Stack<>();
        tilitapahtumatApu = new ArrayList<>();
    }

    //RESULT == tilillä summa
    int getSumma() {
        return this.summa;
    }

    void setSalasana() {
        Scanner x = new Scanner(System.in);
        System.out.println("Tilin haltijan nimi: ");
        String inputNimi = x.nextLine();
        if (inputNimi.equals(super.getHaltija())) {
            System.out.println("Tilin id numero: ");
            int inputId = Integer.valueOf(x.nextLine());
            if (inputId == super.getId()) {
                System.out.println("Anna uusi salasana: ");     //try-catchia tänne + salasana ehtoja
                String uusiSalasana = x.nextLine();             // else:jä
                salasana = uusiSalasana;
            }
        }
    }

    void teeTilitapahtuma(TILITAPAHTUMA tapahtuma) {
        Scanner x = new Scanner(System.in);
        if (tapahtuma.equals(TILITAPAHTUMA.ULOSOTTO)) {
            System.out.println("Kirjoita ulosotettava määrä: ");
            int inputMaara = Integer.valueOf(x.nextLine());
            if (inputMaara > summa) {
                throw new RuntimeException("Tilillä ei ole tarpeeksi katetta."); // oma execption
            } else {
                summa -= inputMaara;
                tilitapahtumat.add(tapahtuma);
                tilitapahtumatApu.add("- " + inputMaara);
            }
        } else {
            System.out.println("Kirjoita talletettava määrä: ");
            int inputMaara = Integer.valueOf(x.nextLine());
            summa += inputMaara;
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
        System.out.println("Jäljellä oleva määrä: " + this.getSumma());
    }





}
