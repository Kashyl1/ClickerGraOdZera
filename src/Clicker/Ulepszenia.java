    package Clicker;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

    public class Ulepszenia extends Skarbiec {
        String nazwa;
        BigDecimal cena;
        double korzysciDoPieniedzy;
        double cenaRosnie;
        BigDecimal pieniadzeZaWcisniecie;
        private final int index;

        public int getIndex() {
            return index;
        }

        public void setCena(BigDecimal cena) {
            this.cena = cena;
        }

        public BigDecimal getCena() {
            return cena;
        }

        public String getNazwa() {
            return nazwa;
        }
        public Ulepszenia(String nazwa, BigDecimal cena, double korzysciDoPieniedzy, int index) {
            this.nazwa = nazwa;
            this.cena = cena;
            this.korzysciDoPieniedzy = korzysciDoPieniedzy;
            this.cenaRosnie = 1.2;
            this.pieniadzeZaWcisniecie = getPieniadzeZaWcisniecie();
            this.index = index;
            wczytajUlepszenia();
        }

        public void zakupKlikania(Skarbiec skarbiec) {
                skarbiec.setPieniadze(skarbiec.getPieniadze().subtract(cena).setScale(2, RoundingMode.HALF_UP));
                zwiekszKoszt();
                zwiekszKlikanie(skarbiec);
                zapiszUlepszenia();
                wczytajUlepszenia();
        }
        public void zakupPasywnego(Skarbiec skarbiec) {
            skarbiec.setPieniadze(skarbiec.getPieniadze().subtract(cena).setScale(2, RoundingMode.HALF_UP));
            zwiekszKoszt();
            zwiekszPrzychodPasywny(skarbiec);
            zwiekszLicznikUlepszenPasywnych(skarbiec);
            zapiszUlepszenia();
            wczytajUlepszenia();
        }
        void zwiekszKlikanie(Skarbiec skarbiec) {
            skarbiec.setPieniadzeZaWcisniecie(skarbiec.getPieniadzeZaWcisniecie().add(BigDecimal.valueOf(korzysciDoPieniedzy)).setScale(2, RoundingMode.HALF_UP));
        }
        void zwiekszPrzychodPasywny(Skarbiec skarbiec) {
            skarbiec.setPieniadzeNaSekunde(skarbiec.getPieniadzeNaSekunde().add(BigDecimal.valueOf(korzysciDoPieniedzy)));
        }
        void zwiekszKoszt() {
            setCena(getCena().multiply(BigDecimal.valueOf(cenaRosnie)).setScale(2, RoundingMode.HALF_UP));
        }
        void zwiekszLicznikUlepszenPasywnych(Skarbiec skarbiec) {
            skarbiec.setLicznikUlepszenPasywnych(getLicznikUlepszenPasywnych() + 1);
        }
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
