    package Clicker;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

    /**
     * Klasa odpowiedzialna za ulepszenia
     */
    public class Ulepszenia extends Skarbiec {

        /**
         * Nazwa ulepszenia
         */
        String nazwa;
        /**
         * Cena ulepszenia
         */
        BigDecimal cena;
        /**
         * Korzyści ulepszenia
         */
        double korzysciDoPieniedzy;
        /**
         * Cena która ma rosnąć z każdym ulepszeniem
         */
        double cenaRosnie;
        /**
         * Pieniądze otrzymywane za wciśnięcie
         */
        BigDecimal pieniadzeZaWcisniecie;
        /**
         * Indeks numerujący ulepszenia
         */
        private final int index;

        /**
         * Metoda odpowiedzialna za pobranie wartości indeksu
         *
         * @return Zwraca wartość indeksu obiektu jako int
         */
        public int getIndex() {
            return index;
        }

        /**
         * Metoda odpowiedzialna za ustawienie nowej ceny ulepszenia
         *
         * @param cena nowa cena produktu przekazywana jako BigDecimal
         */

        public void setCena(BigDecimal cena) {
            this.cena = cena;
        }

        /**
         * Metoda odpowiedzialna za pobranie ceny
         *
         * @return Zwraca wartość ceny obiektu jako BigDecimal
         */
        public BigDecimal getCena() {
            return cena;
        }

        /**
         * Metoda odpowiedzialna za pobranie nazwy
         *
         * @return Zwraca wartość nazwy obiektu jako String
         */
        public String getNazwa() {
            return nazwa;
        }

        /**
         *
         * @param nazwa Nazwa ulepszenia
         * @param cena Początkowa cena ulepszenia, która będzie rosnąć po każdym zakupie
         * @param korzysciDoPieniedzy Kwota o jaką zwiększy się przychód na sekunde po zakupie tego ulepszenia
         * @param index Indeks ulepszenia który identyfikuje ulepszenie
         * Metoda ta również wczytuje uleszenia z notatnika
         */
        public Ulepszenia(String nazwa, BigDecimal cena, double korzysciDoPieniedzy, int index) {
            this.nazwa = nazwa;
            this.cena = cena;
            this.korzysciDoPieniedzy = korzysciDoPieniedzy;
            this.cenaRosnie = 1.2;
            this.pieniadzeZaWcisniecie = getPieniadzeZaWcisniecie();
            this.index = index;
            wczytajUlepszenia();
        }


        /**
         * Metoda ta jest odpowiedzialna za zakup ulepszenia klikania
         * Zwiększa wartość kliknięcia oraz odpowiednio cenę
         *
         * @param skarbiec obiekt reprezentujący skarbiec, z którego pobierana jest cena oraz zwiększana wartość kliknięcia
         */
        public void zakupKlikania(Skarbiec skarbiec) {
                skarbiec.setPieniadze(skarbiec.getPieniadze().subtract(cena).setScale(2, RoundingMode.HALF_UP));
                zwiekszKoszt();
                zwiekszKlikanie(skarbiec);
                zapiszUlepszenia();
                wczytajUlepszenia();
        }

        /**
         * Metoda ta jest odpowiedzialna za zakup ulepszenia pasywnego
         * Zwiększa wartość pieniędzy generowanej na sekunde oraz odpowiednio cenę
         * @param skarbiec Obiekt Skarbiec,z którego zostanie pobrana aktualna ilość pieniędzy oraz do którego zostanie dodany przychód pasywny
         */
        public void zakupPasywnego(Skarbiec skarbiec) {
            skarbiec.setPieniadze(skarbiec.getPieniadze().subtract(cena).setScale(2, RoundingMode.HALF_UP));
            zwiekszKoszt();
            zwiekszPrzychodPasywny(skarbiec);
            zwiekszLicznikUlepszenPasywnych(skarbiec);
            zapiszUlepszenia();
            wczytajUlepszenia();
        }

        /**
         * Metoda odpowiedzialna za ustawienie nowej wartości za kliknięcie
         * @param skarbiec Obiekt Skarbiec do którego zostanie dodana nowa wartość za kliknięcie
         */
        void zwiekszKlikanie(Skarbiec skarbiec) {
            skarbiec.setPieniadzeZaWcisniecie(skarbiec.getPieniadzeZaWcisniecie().add(BigDecimal.valueOf(korzysciDoPieniedzy)).setScale(2, RoundingMode.HALF_UP));
        }

        /**
         * Metoda odpowiedzialna za ustawienie nowego przychodu pasywnego
         * @param skarbiec Obiekt Skarbiec do którego zostanie dodana nowa wartość generująca pieniądze na sekunde
         */
        void zwiekszPrzychodPasywny(Skarbiec skarbiec) {
            skarbiec.setPieniadzeNaSekunde(skarbiec.getPieniadzeNaSekunde().add(BigDecimal.valueOf(korzysciDoPieniedzy)));
        }

        /**
         * Metoda odpowiedzialna za zwiększenie cen ulepszeń
         */
        void zwiekszKoszt() {
            setCena(getCena().multiply(BigDecimal.valueOf(cenaRosnie)).setScale(2, RoundingMode.HALF_UP));
        }

        /**
         * Metoda odpowiedzialna za zwiększenie licznika ulepszenia pasywnego
         * @param skarbiec Obiekt Skarbiec, do którego zostanie dodana nowa wartość licznika ulepszeń pasywnych
         */
        void zwiekszLicznikUlepszenPasywnych(Skarbiec skarbiec) {
            skarbiec.setLicznikUlepszenPasywnych(getLicznikUlepszenPasywnych() + 1);
        }

        /**
         * Metoda odpowiedzialna za zapisanie ulepszenia do pliku tekstowego
         */
        public void zapiszUlepszenia() {
            StringBuilder ulepszeniaKlikania = new StringBuilder();

            try (Scanner scanner = new Scanner(new File("C:\\Users\\assai\\Desktop\\KlikerZdjecia\\Ulepszenia.txt"), StandardCharsets.UTF_8.name())) {
                while (scanner.hasNextLine()) {
                    String linia = scanner.nextLine();
                    String[] dane = linia.split(" ");
                    if (dane[0].equals(nazwa)) {
                        ulepszeniaKlikania.append(nazwa).append(" ").append(cena).append("\n");
                    } else {
                        ulepszeniaKlikania.append(linia).append("\n");
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Brak pliku z zapisem cen ulepszeń");
            }

            try (PrintWriter printWriter = new PrintWriter("C:\\Users\\assai\\Desktop\\KlikerZdjecia\\Ulepszenia.txt")) {
                printWriter.print(ulepszeniaKlikania);
            } catch (FileNotFoundException e) {
                System.out.println("Brak pliku z zapisem cen ulepszeń");
            }
        }

        /**
         * Metoda odpowiedzialna za wczytywanie ulepszenia z pliku tekstowego
         */
        public void wczytajUlepszenia() {
            try (Scanner scanner = new Scanner(new File("C:\\Users\\assai\\Desktop\\KlikerZdjecia\\Ulepszenia.txt"), StandardCharsets.UTF_8.name())) {
                while (scanner.hasNextLine()) {
                    String[] data = scanner.nextLine().split(" ");
                    if (data[0].equals(nazwa)) {
                        nazwa = data[0];
                        cena = BigDecimal.valueOf(Double.parseDouble(data[1]));
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Brak pliku z zapisem cen ulepszeń");
            }
        }

        /**
         * Metoda odpowiedzialna za ustawienie wszystkich ulepszeń jako domyślnych
         */
        public void domyslneUlepszenia() {
            try (Scanner scanner = new Scanner(new File("C:\\Users\\assai\\Desktop\\KlikerZdjecia\\RestartGry.txt"), StandardCharsets.UTF_8.name())) {
                while (scanner.hasNextLine()) {
                    String[] data = scanner.nextLine().split(" ");
                    if (data[0].equals(nazwa)) {
                        cena = BigDecimal.valueOf(Double.parseDouble(data[1]));
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Brak pliku z zapisem cen ulepszeń");
            }
        }
    }
