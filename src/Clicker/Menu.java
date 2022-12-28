package Clicker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Menu extends JFrame {
    Skarbiec skarbiec = new Skarbiec();
    int wysokosc = 50;
    int szerokosc = 50;
    JButton zdobywaj;
    JButton ulepszKlikanie;
    JButton ulepszPrzychodPasywny;
    JButton rebirth;
    JButton drzewoUmiejetnosciKlikania;
    JButton klikanie;
    JButton resetGry;
    JTextField pieniadze;
    JTextField doswiadczenie;
    JTextField pieniadzeZarabianeNaSekundeInformacja;
    JTextField pieniadzeZarabianeNaKlikniecie;
    JLabel ikonaPieniadza;
    JLabel ikonaDoswiadczenia;
    JLabel dodatekJeden;
    public Menu() {
        Font czcionka = new Font("Serif", Font.BOLD, 20);
        ImageIcon obrazek = new ImageIcon("C:\\Users\\assai\\Desktop\\KlikerZdjecia\\klikanie.jpg");
        Image zdjecie = obrazek.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);

        zdobywaj = new JButton();
        zdobywaj.setIcon(new ImageIcon(zdjecie));
        zdobywaj.setBorder(new LineBorder(new Color(101, 105, 103)));
        zdobywaj.setContentAreaFilled(true);

        ulepszKlikanie = new JButton("Ulepszenia Klikania");
        ulepszKlikanie.setSize(szerokosc, wysokosc);
        ulepszKlikanie.setFont(czcionka);
        ulepszKlikanie.setForeground(Color.BLACK);
        ulepszKlikanie.setBorderPainted(false);
        ulepszKlikanie.setBackground(new Color(101, 105, 103));

        ulepszPrzychodPasywny = new JButton("Ulepszenia Pasywny");
        ulepszPrzychodPasywny.setSize(szerokosc, wysokosc);
        ulepszPrzychodPasywny.setFont(czcionka);
        ulepszPrzychodPasywny.setForeground(Color.BLACK);
        ulepszPrzychodPasywny.setBorderPainted(false);
        ulepszPrzychodPasywny.setBackground(new Color(101, 105, 103));

        rebirth = new JButton("Rebirth");
        rebirth.setSize(szerokosc, wysokosc);
        rebirth.setFont(czcionka);
        rebirth.setForeground(Color.BLACK);
        rebirth.setBorderPainted(false);
        rebirth.setBackground(new Color(101, 105, 103));

        drzewoUmiejetnosciKlikania = new JButton("Drzewo Umiejetnosci");
        drzewoUmiejetnosciKlikania.setSize(szerokosc, wysokosc);
        drzewoUmiejetnosciKlikania.setFont(czcionka);
        drzewoUmiejetnosciKlikania.setForeground(Color.BLACK);
        drzewoUmiejetnosciKlikania.setBorderPainted(false);
        drzewoUmiejetnosciKlikania.setBackground(new Color(101, 105, 103));

        klikanie = new JButton("Klikanie");
        klikanie.setSize(szerokosc, wysokosc);
        klikanie.setFont(czcionka);
        klikanie.setForeground(Color.BLACK);
        klikanie.setBorderPainted(false);
        klikanie.setBackground(new Color(101, 105, 103));

        resetGry = new JButton("Reset gry");
        resetGry.setSize(szerokosc, wysokosc);
        resetGry.setFont(czcionka);
        resetGry.setForeground(Color.BLACK);
        resetGry.setBorderPainted(false);
        resetGry.setBackground(new Color(101, 105, 103));

        ImageIcon obrazekDoswiadczenia = new ImageIcon("C:\\Users\\assai\\Desktop\\KlikerZdjecia\\Doswiadczenie.png");
        Image zdjecieDoswiadczenia = obrazekDoswiadczenia.getImage().getScaledInstance(szerokosc, wysokosc, Image.SCALE_SMOOTH);
        ikonaDoswiadczenia = new JLabel(new ImageIcon(zdjecieDoswiadczenia));

        doswiadczenie = new JTextField(String.valueOf(skarbiec.getDoswiadczenie()));
        doswiadczenie.setPreferredSize(new Dimension(szerokosc + 250, wysokosc));
        doswiadczenie.setOpaque(false);
        doswiadczenie.setFont(czcionka);
        doswiadczenie.setEditable(false);
        doswiadczenie.setBorder(new EmptyBorder(0, 0, 0, 10));
        doswiadczenie.setForeground(Color.CYAN);

        ImageIcon obrazekPieniadza = new ImageIcon("C:\\Users\\assai\\Desktop\\KlikerZdjecia\\zloto.jpg");
        Image zdjeciePieniadza = obrazekPieniadza.getImage().getScaledInstance(szerokosc, wysokosc, Image.SCALE_SMOOTH);
        ikonaPieniadza = new JLabel(new ImageIcon(zdjeciePieniadza));

        pieniadze = new JTextField(String.valueOf(skarbiec.getPieniadze()));
        pieniadze.setPreferredSize(new Dimension(szerokosc + 250, wysokosc)); // szerokosc //  wysokosc
        pieniadze.setOpaque(false);
        pieniadze.setBorder(new EmptyBorder(0, 0, 0, 10));
        pieniadze.setFont(czcionka);
        pieniadze.setForeground(Color.YELLOW);
        pieniadze.setEditable(false);

        pieniadzeZarabianeNaKlikniecie = new JTextField("Pieniadze/klik: " + skarbiec.getPieniadzeZaWcisniecie().multiply(skarbiec.getMnoznikZaRebirth()) + "$");
        pieniadzeZarabianeNaKlikniecie.setPreferredSize(new Dimension(szerokosc + 250, wysokosc));
        pieniadzeZarabianeNaKlikniecie.setOpaque(false);
        pieniadzeZarabianeNaKlikniecie.setFont(czcionka);
        pieniadzeZarabianeNaKlikniecie.setEditable(false);
        pieniadzeZarabianeNaKlikniecie.setBorder(new EmptyBorder(0, 0, 0, 10));
        pieniadzeZarabianeNaKlikniecie.setForeground(Color.BLACK);

        pieniadzeZarabianeNaSekundeInformacja = new JTextField("Pieniadze/s " + skarbiec.getPieniadzeNaSekunde().multiply(skarbiec.getMnoznikZaRebirth()) + "$");
        pieniadzeZarabianeNaSekundeInformacja.setPreferredSize(new Dimension(szerokosc + 250, wysokosc));
        pieniadzeZarabianeNaSekundeInformacja.setOpaque(false);
        pieniadzeZarabianeNaSekundeInformacja.setFont(czcionka);
        pieniadzeZarabianeNaSekundeInformacja.setEditable(false);
        pieniadzeZarabianeNaSekundeInformacja.setBorder(new EmptyBorder(0, 0, 0, 10));
        pieniadzeZarabianeNaSekundeInformacja.setForeground(Color.BLACK);

        ImageIcon wygladJeden = new ImageIcon("C:\\Users\\assai\\Desktop\\KlikerZdjecia\\dodatekJeden.jpg");
        Image zdjecieJeden = wygladJeden.getImage().getScaledInstance(szerokosc, szerokosc, Image.SCALE_SMOOTH);

        dodatekJeden = new JLabel(new ImageIcon(zdjecieJeden));
        doswiadczenie.setText(String.valueOf(skarbiec.getDoswiadczenie()));
        pieniadze.setText(String.valueOf(skarbiec.getPieniadze()));

    }
}
