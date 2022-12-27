package Clicker;


import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Skarbiec {

    BigDecimal pieniadzeZaWcisniecie;

    BigDecimal doswiadczenieZaWcisniecie = BigDecimal.valueOf(0.5);
    BigDecimal pieniadze;
    BigDecimal pieniadzeLacznie;

    BigDecimal mnoznikZaRebirth;
    BigDecimal doswiadczenie;
    BigDecimal pieniadzeNaSekunde;

    int licznikUlepszenPasywnych;

    public Skarbiec() {

        try (Scanner scanner = new Scanner(new File("C:\\Users\\assai\\Desktop\\KlikerZdjecia\\progres.txt"), StandardCharsets.UTF_8)) {
                String[] progress = scanner.nextLine().split("\\s+");
                doswiadczenie = BigDecimal.valueOf(Double.parseDouble(progress[1]));
                pieniadze = BigDecimal.valueOf(Double.parseDouble(progress[3]));
                pieniadzeZaWcisniecie = BigDecimal.valueOf(Double.parseDouble(progress[5]));
                mnoznikZaRebirth = BigDecimal.valueOf(Double.parseDouble(progress[7]));
                pieniadzeLacznie = BigDecimal.valueOf(Double.parseDouble(progress[9]));
                pieniadzeNaSekunde = BigDecimal.valueOf(Double.parseDouble(progress[11]));
                licznikUlepszenPasywnych = Integer.parseInt(progress[13]);
            } catch(FileNotFoundException e){
                e.printStackTrace();
            } catch(IOException e){
                throw new RuntimeException(e);
            }
        }

    public void zapisz() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\assai\\Desktop\\KlikerZdjecia\\progres.txt"));
            writer.write("Doświadczenie: " + doswiadczenie + " Pieniądze: " + pieniadze + " PieniądzeZaWciśnięcie: " + pieniadzeZaWcisniecie + " MnoznikZaRebirth: " + mnoznikZaRebirth + " PieniadzeLacznie: " + pieniadzeLacznie + " PieniadzeNaSekunde: " + pieniadzeNaSekunde + " Licznik_ulepszeń_pasywnych: " + licznikUlepszenPasywnych);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BigDecimal getDoswiadczenie() {
        return doswiadczenie;
    }
    public BigDecimal getPieniadze() {
        return pieniadze;
    }

    public void setPieniadze(BigDecimal pieniadze) {
        this.pieniadze = pieniadze;
    }

    public void setDoswiadczenie(BigDecimal doswiadczenie) {
        this.doswiadczenie = doswiadczenie;
    }

    public BigDecimal getMnoznikZaRebirth() {
        return mnoznikZaRebirth;
    }

    public void setMnoznikZaRebirth(BigDecimal mnoznikZaRebirth) {
        this.mnoznikZaRebirth = mnoznikZaRebirth;
    }


    public BigDecimal getPieniadzeZaWcisniecie() {
        return pieniadzeZaWcisniecie;
    }

    public void setPieniadzeZaWcisniecie(BigDecimal pieniadzeZaWcisniecie) {
        this.pieniadzeZaWcisniecie = pieniadzeZaWcisniecie;
    }

    public BigDecimal getDoswiadczenieZaWcisniecie() {
        return doswiadczenieZaWcisniecie;
    }
    public BigDecimal getPieniadzeLacznie() {
        return pieniadzeLacznie;
    }

    public void setPieniadzeLacznie(BigDecimal pieniadzeLacznie) {
        this.pieniadzeLacznie = pieniadzeLacznie;
    }
    public BigDecimal getPieniadzeNaSekunde() {
        return pieniadzeNaSekunde;
    }

    public void setPieniadzeNaSekunde(BigDecimal pieniadzeNaSekunde) {
        this.pieniadzeNaSekunde = pieniadzeNaSekunde;
    }
    public int getLicznikUlepszenPasywnych() {
        return licznikUlepszenPasywnych;
    }

    public void setLicznikUlepszenPasywnych(int licznikUlepszenPasywnych) {
        this.licznikUlepszenPasywnych = licznikUlepszenPasywnych;
    }
}
