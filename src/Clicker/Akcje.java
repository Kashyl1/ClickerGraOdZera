    package Clicker;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.math.BigDecimal;
    import java.math.RoundingMode;
    import java.util.Timer;
    import java.util.TimerTask;


    public class Akcje implements ActionListener {
        Skarbiec skarbiec;
        private final JTextField doswiadczenie;
        private final JTextField pieniadze;
        private final JTextField pieniadzeZarabianeNaSekundeInformacja;
        private final JTextField pieniadzeZarabianeNaKlikniecie;
        private final JButton ulepszKlikanie;
        private final JButton ulepszPrzychodPasywny;
        private final JButton zdobywaj;
        private final JButton klikanie;
        private final JButton resetGry;
        private final JButton rebirth;
        private final JFrame ekran;
        private final JPanel panelUlepszenKlikania;
        private final JPanel panelUlepszenPasywnego;
        private final JPanel coWyswietlic;
        private static Timer timer = new Timer();
        int liczPrzyciski;

        JButton przyciskUlepszeniaKlikania;
        JButton przyciskUlepszeniaPrzychoduPasywnego;


        Ulepszenia[] ulepszeniaKlikania = {
                new Ulepszenia("B-18A", BigDecimal.valueOf(10L), 1, 0),
                new Ulepszenia("PBM-1", BigDecimal.valueOf(50L), 2.5, 1),
                new Ulepszenia("B34", BigDecimal.valueOf(200L), 10, 2),
                new Ulepszenia("B-25J-1", BigDecimal.valueOf(1000L), 50, 3),
                new Ulepszenia("B-26B", BigDecimal.valueOf(5000L), 250, 4),
                new Ulepszenia("B17", BigDecimal.valueOf(15000L), 750, 5),
                new Ulepszenia("PB4Y-2", BigDecimal.valueOf(45000L), 2250, 6),
                new Ulepszenia("B-17G-60-VE", BigDecimal.valueOf(145000L), 7250, 7),
                new Ulepszenia("B-24D-25-CO", BigDecimal.valueOf(450000L), 22500, 8),
                new Ulepszenia("B-29A-BN", BigDecimal.valueOf(1000000L), 50000, 9),
                new Ulepszenia("B-57A", BigDecimal.valueOf(7500000L), 375000, 10),
                new Ulepszenia("B-57B", BigDecimal.valueOf(45000000L), 2250000, 11),
                new Ulepszenia("A-10A-Late", BigDecimal.valueOf(200000000L), 10000000, 12),
                new Ulepszenia("A-7D", BigDecimal.valueOf(1000000000L), 50000000, 13),
                new Ulepszenia("A-7E", BigDecimal.valueOf(35000000000L), 175000000, 14)};

        Ulepszenia[] ulepszeniaPrzychoduPasywnego = {
                new Ulepszenia("P-26A-34-M2", BigDecimal.valueOf(25L), 0.25, 0),
                new Ulepszenia("P-26A-33", BigDecimal.valueOf(150L), 1.5, 1),
                new Ulepszenia("P-400", BigDecimal.valueOf(1000L), 10, 2),
                new Ulepszenia("P-39", BigDecimal.valueOf(7500L), 70.5, 3),
                new Ulepszenia("P-51", BigDecimal.valueOf(45000L), 40.5, 4),
                new Ulepszenia("P-63A-5", BigDecimal.valueOf(450000L), 450, 5),
                new Ulepszenia("P-47", BigDecimal.valueOf(1500000L), 1500, 6),
                new Ulepszenia("F4U-4B", BigDecimal.valueOf(1250000L), 12500, 7),
                new Ulepszenia("P-51H-5-NA", BigDecimal.valueOf(150000000L), 150000, 8),
                new Ulepszenia("F-84", BigDecimal.valueOf(1000000000L), 1000000, 9),
                new Ulepszenia("F-86", BigDecimal.valueOf(8000000000L), 8000000, 10),
                new Ulepszenia("F-100D", BigDecimal.valueOf(50000000000L), 50000000, 11),
                new Ulepszenia("F-4C-PhantomII", BigDecimal.valueOf(400000000000L), 400000000, 12),
                new Ulepszenia("F-16A-ADF", BigDecimal.valueOf(2500000000000L), 250000000, 13),
                new Ulepszenia("F-16A", BigDecimal.valueOf(15000000000000L), 1500000000, 14)};



        public Akcje(JTextField doswiadczenie, JTextField pieniadze, Skarbiec skarbiec, JTextField pieniadzeZarabianeNaSekundeInformacja, JTextField pieniadzeZarabianeNaKlikniecie, JButton ulepszKlikanie, JButton ulepszPrzychodPasywny, JButton zdobywaj, JButton klikanie, JButton resetGry, JButton rebirth, JFrame ekran, JPanel panelUlepszenKlikania, JPanel panelUlepszenPasywnego, JPanel coWyswietlic, JButton przyciskUlepszeniaKlikania, JButton przyciskUlepszeniaPrzychoduPasywnego) {
            this.doswiadczenie = doswiadczenie;
            this.pieniadze = pieniadze;
            this.skarbiec = skarbiec;
            this.pieniadzeZarabianeNaSekundeInformacja = pieniadzeZarabianeNaSekundeInformacja;
            this.pieniadzeZarabianeNaKlikniecie = pieniadzeZarabianeNaKlikniecie;
            this.ulepszKlikanie = ulepszKlikanie;
            this.ulepszPrzychodPasywny = ulepszPrzychodPasywny;
            this.zdobywaj = zdobywaj;
            this.klikanie = klikanie;
            this.resetGry = resetGry;
            this.rebirth = rebirth;
            this.ekran = ekran;
            this.panelUlepszenKlikania = panelUlepszenKlikania;
            this.panelUlepszenPasywnego = panelUlepszenPasywnego;
            this.coWyswietlic = coWyswietlic;
            this.przyciskUlepszeniaKlikania = przyciskUlepszeniaKlikania;
            this.przyciskUlepszeniaPrzychoduPasywnego = przyciskUlepszeniaPrzychoduPasywnego;
            tworzeniePrzyciskowKlikania();
            tworzenieGuzikowPasywnegoPrzychodu();
            pieniadzeNaSekunde();
        }


        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(zdobywaj)) {
                pieniadzeZaKlikniecie();
            }

            if (e.getSource().equals(ulepszKlikanie)) {
                zdobywaj.setVisible(false);
                coWyswietlic.setVisible(true);
                panelUlepszenPasywnego.setVisible(false);
                panelUlepszenKlikania.setVisible(true);
                skarbiec.zapisz();
                ekran.revalidate();
                ekran.repaint();
            }
            if (e.getSource().equals(ulepszPrzychodPasywny)) {
                zdobywaj.setVisible(false);
                coWyswietlic.setVisible(true);
                panelUlepszenKlikania.setVisible(false);
                panelUlepszenPasywnego.setVisible(true);
                skarbiec.zapisz();
                ekran.revalidate();
                ekran.repaint();
            }
            if (e.getSource().equals(klikanie)) {
                coWyswietlic.setVisible(false);
                zdobywaj.setVisible(true);
            }
            if (e.getSource().equals(resetGry)) {
                int confirm = JOptionPane.showConfirmDialog(ekran, "Czy na pewno chcesz zresetować gre?", "Potwierdzenie zresetowania gry", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    skarbiec.setMnoznikZaRebirth(BigDecimal.valueOf(1));
                    resetowanieGry();
                }
            }
            if (e.getSource().equals(rebirth)) {
                BigDecimal odrodzenie;
                odrodzenie = skarbiec.getPieniadzeLacznie().multiply(BigDecimal.valueOf(0.0000001)).setScale(2, RoundingMode.HALF_UP);
                int confirm = JOptionPane.showConfirmDialog(ekran, "Czy na pewno chcesz zrobić rebirth? Dostaniesz za to: " + odrodzenie.multiply(BigDecimal.valueOf(100)) + "% Bonusu", "Potwierdzenie rebirth gry", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    skarbiec.setMnoznikZaRebirth(skarbiec.getMnoznikZaRebirth().add(odrodzenie));
                    resetowanieGry();
                    pieniadzeZarabianeNaKlikniecie.setText("Pieniadze/klik: " + skarbiec.getPieniadzeZaWcisniecie().multiply(skarbiec.getMnoznikZaRebirth()).setScale(2, RoundingMode.HALF_UP) + "$");
                    pieniadzeZarabianeNaSekundeInformacja.setText("Pieniadze/s: " + skarbiec.getPieniadzeNaSekunde().multiply(skarbiec.getMnoznikZaRebirth()).setScale(2, RoundingMode.HALF_UP) + "$");

                }
            }

        }

        void pieniadzeZaKlikniecie() {
            liczPrzyciski++;
            if (liczPrzyciski == 15) {
                liczPrzyciski = 0;
                skarbiec.setDoswiadczenie(skarbiec.getDoswiadczenie().add(skarbiec.getDoswiadczenieZaWcisniecie().multiply(skarbiec.getMnoznikZaRebirth())).setScale(2, RoundingMode.HALF_UP));
            }
            //  System.out.println("zdobywaj");
            skarbiec.setPieniadze(skarbiec.getPieniadze().add(skarbiec.getPieniadzeZaWcisniecie().multiply(skarbiec.getMnoznikZaRebirth())).setScale(2, RoundingMode.HALF_UP));
            skarbiec.setPieniadzeLacznie(skarbiec.getPieniadzeLacznie().add(skarbiec.getPieniadzeZaWcisniecie().setScale(2, RoundingMode.HALF_UP)));
            doswiadczenie.setText(String.valueOf(skarbiec.doswiadczenie));
            pieniadze.setText(String.valueOf(skarbiec.pieniadze));
            skarbiec.zapisz();
        }
       void tworzeniePrzyciskowKlikania() {
          panelUlepszenKlikania.setVisible(false);
          GridBagConstraints c = new GridBagConstraints();
          c.fill = GridBagConstraints.NORTH;
          c.insets = new Insets(10, 10, 10, 10);
          c.gridx = 0;
          c.gridy = 0;
          for (int i = 0; i < ulepszeniaKlikania.length; i++) {
              Ulepszenia ulepszenie = ulepszeniaKlikania[i];
              JButton przyciskUlepszenia = new JButton(ulepszenie.getNazwa() + " Cena: " + ulepszenie.getCena());
              przyciskUlepszenia.setForeground(Color.BLACK);
              przyciskUlepszenia.setBorderPainted(false);
              przyciskUlepszenia.setBackground(new Color(101, 105, 103));

              ImageIcon zdjecieUlepszenia = new ImageIcon("C:\\Users\\assai\\Desktop\\KlikerZdjecia\\obrazek_dla" + ulepszeniaKlikania[i].nazwa + ".jpg");
              Image obrazekUlepszenia = zdjecieUlepszenia.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
              zdjecieUlepszenia = new ImageIcon(obrazekUlepszenia);
              przyciskUlepszenia.setIcon(zdjecieUlepszenia);
              panelUlepszenKlikania.add(przyciskUlepszenia, c);

              c.gridy++;
              if (c.gridy == 3) {
                  c.gridx++;
                  c.gridy = 0;
              }

              int finalI = i;
              przyciskUlepszenia.addActionListener(e -> {
                  if (skarbiec.getPieniadze().compareTo(ulepszeniaKlikania[ulepszenie.getIndex()].cena) >= 0) {
                      ulepszeniaKlikania[finalI].zakupKlikania(skarbiec);
                      pieniadze.setText(skarbiec.getPieniadze().toPlainString());
                      pieniadzeZarabianeNaKlikniecie.setText("Pieniadze/klik: " + skarbiec.getPieniadzeZaWcisniecie().multiply(skarbiec.getMnoznikZaRebirth()).setScale(2, RoundingMode.HALF_UP) + "$");
                      skarbiec.zapisz();
                      przyciskUlepszenia.setText(ulepszeniaKlikania[ulepszenie.getIndex()].getNazwa() + " Cena: " + ulepszeniaKlikania[ulepszenie.getIndex()].getCena());
                  } else {
                      JOptionPane.showMessageDialog(ekran, "Nie masz wystarczająco dużo pieniędzy!", "Komunikat", JOptionPane.INFORMATION_MESSAGE);
                  }
              });
          }
      }
      void tworzenieGuzikowPasywnegoPrzychodu() {
          panelUlepszenPasywnego.setVisible(false);
          GridBagConstraints c = new GridBagConstraints();
          c.fill = GridBagConstraints.NORTH;
          c.insets = new Insets(10, 10, 10, 10);
          c.gridx = 0;
          c.gridy = 0;
          for (int i = 0; i < ulepszeniaPrzychoduPasywnego.length; i++) {
              Ulepszenia ulepszenie = ulepszeniaPrzychoduPasywnego[i];
              JButton przyciskUlepszenia = new JButton(ulepszenie.getNazwa() + " Cena: " + ulepszenie.getCena());
              przyciskUlepszenia.setForeground(Color.BLACK);
              przyciskUlepszenia.setBorderPainted(false);
              przyciskUlepszenia.setBackground(new Color(101, 105, 103));

              ImageIcon zdjecieUlepszenia = new ImageIcon("C:\\Users\\assai\\Desktop\\KlikerZdjecia\\obrazek_dla" + ulepszeniaPrzychoduPasywnego[i].nazwa + ".jpg");
              Image obrazekUlepszenia = zdjecieUlepszenia.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
              zdjecieUlepszenia = new ImageIcon(obrazekUlepszenia);
              przyciskUlepszenia.setIcon(zdjecieUlepszenia);
              panelUlepszenPasywnego.add(przyciskUlepszenia, c);

              c.gridy++;
              if (c.gridy == 3) {
                  c.gridx++;
                  c.gridy = 0;
              }


              int finalI = i;
              przyciskUlepszenia.addActionListener(e -> {
                  if (skarbiec.getPieniadze().compareTo(ulepszeniaPrzychoduPasywnego[ulepszenie.getIndex()].cena) >= 0) {
                      ulepszeniaPrzychoduPasywnego[finalI].zakupPasywnego(skarbiec);
                      pieniadze.setText(skarbiec.getPieniadze().toPlainString());
                      pieniadzeZarabianeNaSekundeInformacja.setText("Pieniadze/s: " + skarbiec.getPieniadzeNaSekunde().multiply(skarbiec.getMnoznikZaRebirth()).setScale(2, RoundingMode.HALF_UP) + "$");
                      pieniadzeNaSekunde();
                      skarbiec.zapisz();
                      przyciskUlepszenia.setText(ulepszeniaPrzychoduPasywnego[ulepszenie.getIndex()].getNazwa() + " Cena: " + ulepszeniaPrzychoduPasywnego[ulepszenie.getIndex()].getCena());
                  } else {
                      JOptionPane.showMessageDialog(ekran, "Nie masz wystarczająco dużo pieniędzy!", "Komunikat", JOptionPane.INFORMATION_MESSAGE);
                  }
              });
          }
      }

      void pieniadzeNaSekunde() {
            if (timer != null) {
                timer.cancel();
            }
            timer = new Timer();
          TimerTask task = new TimerTask() {
              @Override
              public void run() {
                  if (skarbiec.getLicznikUlepszenPasywnych() > 0) {
                      skarbiec.setPieniadze(skarbiec.getPieniadze().add(skarbiec.getPieniadzeNaSekunde().multiply(skarbiec.getMnoznikZaRebirth())).setScale(2, RoundingMode.HALF_UP));
                      skarbiec.setPieniadzeLacznie(skarbiec.getPieniadzeLacznie().add(skarbiec.getPieniadzeNaSekunde()).setScale(2, RoundingMode.HALF_UP));

                      pieniadze.setText(String.valueOf(skarbiec.pieniadze));
                  }
              }
          };
            timer.scheduleAtFixedRate(task, 0, 1000);
        }

        void resetowanieGry() {
            for (Ulepszenia ulepszenia : ulepszeniaKlikania) {
                ulepszenia.domyslneUlepszenia();
                ulepszenia.zapiszUlepszenia();
            }
            for (Ulepszenia ulepszenia : ulepszeniaPrzychoduPasywnego) {
                ulepszenia.domyslneUlepszenia();
                ulepszenia.zapiszUlepszenia();
            }

            skarbiec.setDoswiadczenie(BigDecimal.valueOf(0));
            skarbiec.setPieniadze(BigDecimal.valueOf(0));
            skarbiec.setPieniadzeZaWcisniecie(BigDecimal.valueOf(1));
            skarbiec.setPieniadzeLacznie(BigDecimal.valueOf(0));
            skarbiec.setPieniadzeNaSekunde(BigDecimal.valueOf(0));
            skarbiec.setLicznikUlepszenPasywnych(0);


            doswiadczenie.setText(String.valueOf(skarbiec.getDoswiadczenie()));
            pieniadze.setText(String.valueOf(skarbiec.getPieniadze()));

            pieniadzeZarabianeNaSekundeInformacja.setText("Pieniadze/s: " + skarbiec.getPieniadzeNaSekunde() + "$");
            pieniadzeZarabianeNaKlikniecie.setText("Pieniadze/klik: " + skarbiec.getPieniadzeZaWcisniecie() + "$");

            skarbiec.zapisz();

        }
    }
