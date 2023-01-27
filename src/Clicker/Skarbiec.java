package Clicker;


import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Klasa odpowiedzialna za przechowywanie kluczowych wartości
 */
public class Skarbiec {
    /**
     * Pieniądze otrzymywane za każde wciśnięcie skrzyni na ekranie
     */

    BigDecimal pieniadzeZaWcisniecie;
    /**
     * (Do dodania)
     *
     * Doświadczenie otrzymywane za każde wciśnięcie skrzyni na ekranie
     */
    BigDecimal doswiadczenieZaWcisniecie = BigDecimal.valueOf(0.5);
    /**
     * Pieniądze za które można kupować kolejne ulepszenia
     */
    BigDecimal pieniadze;
    /**
     * Łaczna ilość pieniędzy odpowiedzialna za rebirth
     */
    BigDecimal pieniadzeLacznie;
    /**
     * Mnożnik który zwiększa ilość pieniędzy z wszystkich interakcji dostępnych w grze
     */

    BigDecimal mnoznikZaRebirth;
    /**
     * Łączna ilość doświadczenia
     */
    BigDecimal doswiadczenie;
    /**
     * Pieniądze otrzymywane na sekunde
     */
    BigDecimal pieniadzeNaSekunde;

    /**
     * Licznik ulepszeń pasywnych
     */
    int licznikUlepszenPasywnych;
    /**
     * Ścieżka do pliku tekstowego (Powinieneś ją zmienić u siebie!)
     */
    String sciezka = "C:\\Users\\assai\\Desktop\\KlikerZdjecia\\progres.txt";

    /**
     * Konstruktor odpowiedzialny za wczytanie wszystkich wartości z notatnika
     */

    public Skarbiec() {

        try (Scanner scanner = new Scanner(new File(sciezka), StandardCharsets.UTF_8)) {
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

    /**
     * Metoda odpowiedzialna za zapisywanie wszystkich wartości do notatnika
     */
    public void zapisz() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(sciezka));
            writer.write("Doświadczenie: " + doswiadczenie + " Pieniądze: " + pieniadze + " PieniądzeZaWciśnięcie: " + pieniadzeZaWcisniecie + " MnoznikZaRebirth: " + mnoznikZaRebirth + " PieniadzeLacznie: " + pieniadzeLacznie + " PieniadzeNaSekunde: " + pieniadzeNaSekunde + " Licznik_ulepszeń_pasywnych: " + licznikUlepszenPasywnych);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda odpowiedzialna za pobranie wartości doświadczenia
     *
     * @return Zwraca wartość doświadczenia przekazywana jako BigDecimal
     */

    public BigDecimal getDoswiadczenie() {
        return doswiadczenie;
    }

    /**
     * Metoda odpowiedzialna za pobranie wartości pieniędzy
     *
     * @return Zwraca wartość pieniędzy przekazywana jako BigDecimal
     */
    public BigDecimal getPieniadze() {
        return pieniadze;
    }

    /**
     * Metoda odpowiedzialna za ustawienie nowej wartości pieniędzy
     *
     * @param pieniadze Nowa wartość pieniędzy przekazywana jako BigDecimal
     */
    public void setPieniadze(BigDecimal pieniadze) {
        this.pieniadze = pieniadze;
    }

    /**
     * Metoda odpowiedzialna za ustawienie nowej wartości doswiadczenia
     *
     * @param doswiadczenie Nowa wartość doświadczenia przekazywana jako BigDecimal
     */
    public void setDoswiadczenie(BigDecimal doswiadczenie) {
        this.doswiadczenie = doswiadczenie;
    }

    /**
     * Metoda odpowiedzialna za pobranie mnożnika rebirth
     *
     * @return Zwraca wartość mnoznika za Rebirth przekazywana jako BigDecimal
     */
    public BigDecimal getMnoznikZaRebirth() {
        return mnoznikZaRebirth;
    }

    /**
     * Metoda odpowiedzialna za ustawienie nowej wartości mnożnika za rebirth
     *
     * @param mnoznikZaRebirth Nowa wartość mnożnika za Rebirth przekazywana jako BigDecimal
     */
    public void setMnoznikZaRebirth(BigDecimal mnoznikZaRebirth) {
        this.mnoznikZaRebirth = mnoznikZaRebirth;
    }

    /**
     * Metoda odpowiedzialna za pobranie pieniędzy za kliknięcie
     *
     * @return Zwraca wartość pieniędzy za wciśnięcie przekazywana jako BigDecimal
     */
    public BigDecimal getPieniadzeZaWcisniecie() {
        return pieniadzeZaWcisniecie;
    }

    /**
     * Metoda odpowiedzialna za ustawienie nowej wartości pieniędzy za wciśnięcie
     *
     * @param pieniadzeZaWcisniecie Nowa wartość pieniędzy za wciśnięcie przekazywana jako BigDecimal
     */
    public void setPieniadzeZaWcisniecie(BigDecimal pieniadzeZaWcisniecie) {
        this.pieniadzeZaWcisniecie = pieniadzeZaWcisniecie;
    }

    /**
     * Metoda odpowiedzialna za ustawienie nowej wartości doswiadczenia za wciśnięcie
     *
     * @return Nowa wartość doświadczenia za wciśnięcie przekazywana jako BigDecimal
     */

    public BigDecimal getDoswiadczenieZaWcisniecie() {
        return doswiadczenieZaWcisniecie;
    }

    /**
     * Metoda odpowiedzialna za pobranie pieniędzy łącznie
     *
     * @return Zwraca wartość pieniędzy łącznie przekazywana jako BigDecimal
     */
    public BigDecimal getPieniadzeLacznie() {
        return pieniadzeLacznie;
    }

    /**
     * Metoda odpowiedzialna za ustawienie pieniędzy łącznie
     *
     * @param pieniadzeLacznie Nowa wartość pieniędzy łącznie przekazywana jako BigDecimal
     */
    public void setPieniadzeLacznie(BigDecimal pieniadzeLacznie) {
        this.pieniadzeLacznie = pieniadzeLacznie;
    }

    /**
     * Metoda odpowiedzialna za pobranie wartości pieniędzy na sekunde
     *
     * @return Pobiera wartość pieniędzy na sekunde przekazywana jako BigDecimal
     */
    public BigDecimal getPieniadzeNaSekunde() {
        return pieniadzeNaSekunde;
    }

    /**
     * Metoda odpowiedzialna za ustawienie nowej wartości pieniędzy na sekunde
     *
     * @param pieniadzeNaSekunde Ustawia nową wartość pieniędzy na sekunde przekazywana jako BigDecimal
     */
    public void setPieniadzeNaSekunde(BigDecimal pieniadzeNaSekunde) {
        this.pieniadzeNaSekunde = pieniadzeNaSekunde;
    }

    /**
     * Metoda odpowiedzialna za pobieranie licznika ulepszeń pasywnych
     *
     * @return Pobiera wartośc licznika ulepszeń pasywnych
     */
    public int getLicznikUlepszenPasywnych() {
        return licznikUlepszenPasywnych;
    }

    /**
     * Metoda odpowiedzialna za ustawienie nowej wartości licznika ulepszeń pasywnych
     *
     * @param licznikUlepszenPasywnych Ustawia nową wartość licznika ulepszeń pasywnych przekazywana jako int
     */

    public void setLicznikUlepszenPasywnych(int licznikUlepszenPasywnych) {
        this.licznikUlepszenPasywnych = licznikUlepszenPasywnych;
    }
}
