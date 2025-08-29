# Übungen

## Übung 1
Wir haben folgende Beschreibung einer Verkaufssoftware:
Über die Verkaufssoftware kann das Autohaus seinen Verkäufern Rabattregeln vorgeben: Bei einem Kaufpreis von weniger
als 15’000 CHF soll kein Rabatt gewährt werden. Bei einem Preis bis zu 20’000 CHF sind 5% Rabatt angemessen. Liegt der
Kaufpreis unter 25’000 CHF sind 7% Rabatt möglich, darüber sind 8,5 % Rabatt zu gewähren.

### Aufgabe

**Beschreibung:**  
Über die Verkaufssoftware kann das Autohaus seinen Verkäufern Rabattregeln vorgeben:
- Kaufpreis < 15’000 CHF → 0 % Rabatt
- 15’000 ≤ Kaufpreis ≤ 20’000 CHF → 5 % Rabatt
- 20’000 < Kaufpreis < 25’000 CHF → 7 % Rabatt
- Kaufpreis ≥ 25’000 CHF → 8.5 % Rabatt  
Leiten Sie aus dieser Beschreibung Testfälle ab. Wir wollen beide Varianten von Testfällen untersuchen.


Eine Tabelle mit abstrakten Testfällen. Hier verwenden Sie logische Operatoren wie > , < , etc.

### 1. Abstrakte Testfälle

| ID  | Beschreibung (abstrakt) | Eingabebereich \(p\) | Erwarteter Rabatt |
|-----|--------------------------|----------------------|------------------|
| A1  | Klasse „unter 15k“       | \(p < 15’000\)       | 0 %              |
| A2  | Klasse „15k bis 20k inkl.“ | \(15’000 \le p \le 20’000\) | 5 % |
| A3  | Klasse „über 20k und unter 25k“ | \(20’000 < p < 25’000\) | 7 % |
| A4  | Klasse „ab 25k“          | \(p \ge 25’000\)     | 8.5 %            |
| B1  | Grenzwert knapp unter 15k | 14’999.99            | 0 %              |
| B2  | Grenzwert exakt 15k       | 15’000               | 5 %              |
| B3  | Grenzwert exakt 20k       | 20’000               | 5 %              |
| B4  | Grenzwert knapp über 20k  | 20’000.01            | 7 %              |
| B5  | Grenzwert knapp unter 25k | 24’999.99            | 7 %              |
| B6  | Grenzwert exakt 25k       | 25’000               | 8.5 %            |

Eine Tabelle mit konkreten Testfällen. Hier verwenden Sie ganz konkrete Eingabe-Werte, um die Testfälle zu erstellen.

### 2. Konkrete Testfälle

| ID  | Eingabe: Preis (CHF) | Erwarteter Rabatt | Erwarteter Endpreis |
|-----|----------------------|------------------|---------------------|
| C1  | 14’999               | 0 %              | 14’999.00           |
| C2  | 15’000               | 5 %              | 14’250.00           |
| C3  | 18’500               | 5 %              | 17’575.00           |
| C4  | 20’000               | 5 %              | 19’000.00           |
| C5  | 20’001               | 7 %              | 18’600.93           |
| C6  | 24’999               | 7 %              | 23’249.07           |
| C7  | 25’000               | 8.5 %            | 22’875.00           |
| C8  | 40’000               | 8.5 %            | 36’600.00           |

---


## Übung 2

[SIXT Schweiz](https://www.sixt.ch/)

Suchen Sie sich eine Webseite zum Thema Autovermietung.
Definieren Sie funktionale Black-Box Tests, die Sie brauchen, um diese Plattform zu betreiben.
Listen Sie die 5 wichtigsten Testfälle auf
Erstellen Sie eine Tabelle mit diesen Testfälle als Markdown und stellen Sie diese in Ihr Repository. Hier eine Idee als Tabelle:

# Aufgabe 2 – Funktionale Black-Box-Tests für sixt.ch

| ID  | Beschreibung | Erwartetes Resultat | Effektives Resultat                                                                                      | Status | Mögliche Ursache                                                                            |
|-----|--------------|---------------------|----------------------------------------------------------------------------------------------------------|--------|---------------------------------------------------------------------------------------------|
| R1  | Suche & One-Way: Abholort A, Rückgabeort B, gültige Zeiten | Trefferliste mit verfügbaren Fahrzeuggruppen & Preisen, One-Way wird akzeptiert; Tarifwahl sichtbar | Parameter(A: Zürich Airport, B: Genf Airport; Datum:(31.08.2025, 12:30 - 04.09.2025, 08:30)              | ✅ | API-Suche down; Fehler bei Ort-/Datumsvalidierung                                           |  |                   |
| R2  | Zahlungsmittel – Flexi (EC/Maestro) | Flexi-Tarif: EC/VPay/Maestro für ausgewählte Gruppen möglich; Kreditkarten immer akzeptiert; Barzahlung abgelehnt; Prepaid nur online (Kreditkarte/PayPal) |                                                                                                          |        | Tarif-/Gruppenmapping falsch; Zahlart-Filter defekt                                         |
| R3  | Stornierung: Flexi vs. Prepaid | Flexi: jederzeit kostenfrei vor Mietbeginn; Prepaid: 99 CHF Gebühr vor Mietbeginn, keine Rückerstattung nach Abholzeit |                                                                                                          |        | Business-Rule falsch implementiert; Zeitfenster fehlerhaft                                  |
| R4  | Mindestalter: Fahrer 19 bei Basel/Genf/Lausanne | Buchung wird akzeptiert gemäss Stationsregel (19 Jahre, ggf. Young-Driver-Gebühr); verweigert unzulässige Gruppen |                                                                                                          |        | Altersprüfung nur global, nicht stationsabhängig                                            |
| R5  | Zusatzfahrer später hinzufügen | Zusatzfahrer kann mit Original-Führerschein an einer anderen SIXT-Station nachgetragen werden |                                                                                                          |        | Prozess in Filiale unbekannt; UI ohne entsprechenden Hinweis                                |





1
Programm startet korrekt
Nach dem Aufruf des Programms auf der Konsole öffnet sich ein Fenster.
Programm stürzt ab mit Fehler X00234
Fehler
Zugriff auf DB-Server evtl. nicht möglich



---

## Übung 3
Sie haben folgende Software einer simplen Bank-Software. Laden Sie das Source-Zip herunter und erstellen Sie ein lokales
Projekt in Ihrer IDE. Achtung! Sie müssen auch die JAR-Files für GSON und OKHTTP installieren. Alternativ können Sie das
Maven Projekt verwenden,
um es ohne die JAR-Files in Betrieb zu nehmen. Die Software plus JAR-Files finden Sie
hier: https://gitlab.com/ch-tbz-it/Stud/m450/m450/-/tree/main/Unterlagen/teststrategie
Machen Sie sich mit dem Code vertraut.
Wir wollen ganz grob herausfinden, was für Testfälle es in dieser Software gibt.

Identifizieren Sie mögliche Black-Box Testfälle, welche Sie als Benutzer testen können.

Welche Methoden im Code könnten für White-Box Testfälle verwendet werden?
Was würden Sie am Code generell verbessern, welche Best Practices fallen Ihnen ein

Listen Sie Ihre Testfälle tabellarisch auf in einem Markdown-Dokument und stellen Sie Ihre Lösung in Ihr Repository.



| ID  | Beschreibung                       | Erwartetes Resultat                                                                                                               | Effektives Resultat | Status | Mögliche Ursache |  
| --- | ---------------------------------- | --------------------------------------------------------------------------------------------------------------------------------- | ------------------- | ------ | ---------------- |
| 1   | Applikation startet                | Applikationen startet ohne Fehler.                                                                                                |                     |        |                  |
| 2   | Optionen sind verfügbar            | Alle Auswahl Optionen werden in der CLI angezeigt.                                                                                |                     |        |                  |
| 3   | Alle anfangs Optionen funktioneren | Korrekte Funktion der Optionen:<br>- Alle Konten anzeigen.<br>- Konto erstellen.<br>- Wechselkurs abfragen.<br>- Program beenden. |                     |        |                  |
| 4   | Konten Auswahl                     | Ein Konto lässt sich mit der dazugehörigen Nummer auswählen.                                                                      |                     |        |                  |
| 5   | Konto Optionen                     | Die Funktionstüchtigkeit der Optionen für ein Konto sind gewährleistet.                                                           |                     |        |                  |

 