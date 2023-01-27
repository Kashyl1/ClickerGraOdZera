    package Clicker;

    import javax.swing.*;
    import java.awt.*;

    /**
     * Klasa odpowiedzialna za tworzenie paneli oraz nadaniu dodaniu ich do ekranu
     * Dodatkowo dodaje ActionListenera do przycisków
     */

    public class EkranGlowny extends Menu {
        JPanel kliker;
        JPanel panelUlepszenKlikania;
        JPanel panelUlepszenPasywnego;
        JPanel panelUlepszeniaDrzewkaKlikania;
        JPanel coWyswietlic;
        JButton przyciskUlepszeniaKlikania;
        JButton PrzyciskUlepszeniaPasywnego;

        public EkranGlowny() {
            JFrame ekran = new JFrame();
            JPanel zakladki = new JPanel(new GridBagLayout());
            JPanel informacje = new JPanel(new GridBagLayout());
            coWyswietlic = new JPanel(new CardLayout());


            kliker = new JPanel(new GridBagLayout());
            panelUlepszenKlikania = new JPanel(new GridBagLayout());
            panelUlepszenPasywnego = new JPanel(new GridBagLayout());
            panelUlepszeniaDrzewkaKlikania = new JPanel(new GridBagLayout());

            zakladki.setBackground(new Color(101, 105, 103));
            informacje.setBackground(new Color(101, 105, 103));
            kliker.setBackground(new Color(101, 105, 103));
            panelUlepszenKlikania.setBackground(new Color(101, 105, 103));
            panelUlepszenPasywnego.setBackground(new Color(101, 105, 103));
            panelUlepszeniaDrzewkaKlikania.setBackground(new Color(101, 105, 103));

            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.BELOW_BASELINE;
            c.insets = new Insets(10, 10, 10, 10);

            c.gridx = 0;
            c.gridy = 0;
            zakladki.add(dodatekJeden);
            kliker.add(zdobywaj, c);


            c.gridx = 0;
            c.gridy = 1;
            zakladki.add(klikanie, c);

            c.gridx = 0;
            c.gridy = 2;
            zakladki.add(ulepszKlikanie, c);

            c.gridx = 0;
            c.gridy = 3;
            zakladki.add(ulepszPrzychodPasywny, c);

            c.gridx = 0;
            c.gridy = 4;
            zakladki.add(drzewoUmiejetnosciKlikania, c);

            c.gridx = 0;
            c.gridy = 5;
            zakladki.add(rebirth, c);

            c.gridx = 0;
            c.gridy = 6;
            zakladki.add(resetGry, c);


            c.gridx = 1;
            c.gridy = 0;
            informacje.add(ikonaDoswiadczenia, c);

            c.gridx = 3;
            c.gridy = 0;
            c.gridwidth = 2;
            informacje.add(doswiadczenie, c);

            c.gridx = 5;
            c.gridy = 0;
            informacje.add(ikonaPieniadza, c);

            c.gridx = 7;
            c.gridy = 0;
            c.gridwidth = 5;
            informacje.add(pieniadze, c);

            c.gridx = 112;
            c.gridy = 0;
            c.gridwidth = 10;

            informacje.add(pieniadzeZarabianeNaKlikniecie, c);

            c.gridx = 16;
            c.gridy = 0;
            c.gridwidth = 4;
            informacje.add(pieniadzeZarabianeNaSekundeInformacja, c);


            coWyswietlic.add(panelUlepszenKlikania, "panelUlepszenKlikania");
            coWyswietlic.add(panelUlepszenPasywnego, "panelUlepszenPasywnego");

            ekran.setLayout(new BorderLayout());
            ekran.add(coWyswietlic, BorderLayout.EAST);
            ekran.add(kliker, BorderLayout.CENTER);
            ekran.add(zakladki, BorderLayout.BEFORE_LINE_BEGINS);
            ekran.add(informacje, BorderLayout.PAGE_END);

            ekran.setVisible(true);
            ekran.setSize(1700, 700);
            ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ekran.setTitle("Clicker");
            ekran.setResizable(true);
            ekran.setLocationRelativeTo(null);


            Akcje akcje = new Akcje(doswiadczenie, pieniadze, skarbiec, pieniadzeZarabianeNaSekundeInformacja, pieniadzeZarabianeNaKlikniecie, ulepszKlikanie, ulepszPrzychodPasywny, zdobywaj, klikanie, resetGry, rebirth, ekran, panelUlepszenKlikania, panelUlepszenPasywnego, coWyswietlic, przyciskUlepszeniaKlikania, PrzyciskUlepszeniaPasywnego);
            zdobywaj.addActionListener(akcje);
            ulepszKlikanie.addActionListener(akcje);
            klikanie.addActionListener(akcje);
            resetGry.addActionListener(akcje);
            rebirth.addActionListener(akcje);
            ulepszPrzychodPasywny.addActionListener(akcje);
        }
    }
