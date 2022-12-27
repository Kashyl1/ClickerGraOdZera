# ClickerGraOdZera

Jest to gra Clicker którą stwierdziłem że zrobię by poćwiczyć programowanie. 
Grafike wziąłem z internetu i szata graficzna nie jest jakaś piękna, ale bardziej skupiałem się na tym by program był stabilny i działający.

Program działa następująco: 

-Aby generować pieniądze klikamy w wielką skrzynie którą widać na początku programu. 

-Następnie gdy zdobędziemy wystarczającą ilość pieniędzy możemy się pokusić aby kupic ulepszenia klikania / pasywne.

-Ulepszenia klikania działają tak że generują więcej pieniędzy za klikanie w skrzynie, a pasywne działają tak że generują pieniądze na sekunde.

-Po zdobyciu większej sumy pieniędzy można zrobić rebirth aby sobie pomóc, rebirth działa tak że zwiększa bonus który użytkownik zdobywa za klikanie
oraz generowanie pieniędzy na sekunde, lecz w zamian resetuje Ci cały progres i zostawia tylko tą wartość. 

-Jak liczy się bonus rebirth?
Otóż liczy on to z ukrytej zmiennej PieniadzeLacznie, która działa tak jak normalne pieniądze tyle że nie podlega ona żadnym bonusom, tzn jeżeli mamy 
progres za rebirth np 10000% to nie można nadużywać tego bonusu by co chwile zwiększać bonus za rebirth o kolejne 10000% tylko powoli się to zdobywa.

-Kolejna opcja to ResetGry, który całkowicie Ci resetuje cały progres i zaczynasz od nowa.

Błędy:
Jako że nie dokończyłem tego programu znalazł się jeden błąd który zauważyłem:
-Gdy klikamy Rebirth/Reset Gry cena ulepszeń zmienia się w naszym notatniku odpowiedzialnym za zapis gry, lecz nie aktualizuje się w grze, aby się
zaaktualizowała należy wyłączyć ją i włączyć na nowo.

Przyszłe plany: 
-Jak można zauważyć zostawiłem w grze JButton o nazwie Drzewo Umiejętności, które po kliknięciu nic nie robi.
Jest to opcja którą będę chciał stworzyć o ile wrócę do poprawiania tej gry ponownie. 
-Zmienić cenę ulepszeń i ich wpływ na gre ponieważ gra jest jak narazie za łatwa

Jak wygląda gra:

1) Miejsce do klikania (skrzynia)
![image](https://user-images.githubusercontent.com/92478936/209665033-725d478c-0a56-4f74-89c0-590a79293e2b.png)

2) Ulepszenia klikania:
![image](https://user-images.githubusercontent.com/92478936/209665073-a56ae235-1811-401c-aea8-2f975095bd6a.png)

3) Ulepszenia generowania pieniędzy na sekunde:
![image](https://user-images.githubusercontent.com/92478936/209665124-cd9af30e-5fc5-4990-96fd-d4ad10c9e3cf.png)

4) Rebirth:
![image](https://user-images.githubusercontent.com/92478936/209667259-eec583e6-ff38-43ce-be41-cf643b81f592.png)

5) Reset Gry:
![image](https://user-images.githubusercontent.com/92478936/209666929-bd99310e-db54-4fc0-9d84-d9a557ebee2f.png)


