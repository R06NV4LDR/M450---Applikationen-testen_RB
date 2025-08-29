# Übungen

---

## Übung 1 – Rabattregeln

Wir haben folgende Beschreibung einer Verkaufssoftware:  
Über die Verkaufssoftware kann das Autohaus seinen Verkäufern Rabattregeln vorgeben:

- Kaufpreis < 15’000 CHF → 0 % Rabatt
- 15’000 ≤ Kaufpreis ≤ 20’000 CHF → 5 % Rabatt
- 20’000 < Kaufpreis < 25’000 CHF → 7 % Rabatt
- Kaufpreis ≥ 25’000 CHF → 8.5 % Rabatt

Leiten Sie aus dieser Beschreibung Testfälle ab. Wir wollen beide Varianten von Testfällen untersuchen.

---

### 1. Abstrakte Testfälle

| ID | Beschreibung (abstrakt)         | Eingabebereich \(p\)        | Erwarteter Rabatt |
|----|---------------------------------|-----------------------------|-------------------|
| A1 | Klasse „unter 15k“              | \(p < 15’000\)              | 0 %               |
| A2 | Klasse „15k bis 20k inkl.“      | \(15’000 \le p \le 20’000\) | 5 %               |
| A3 | Klasse „über 20k und unter 25k“ | \(20’000 < p < 25’000\)     | 7 %               |
| A4 | Klasse „ab 25k“                 | \(p \ge 25’000\)            | 8.5 %             |
| B1 | Grenzwert knapp unter 15k       | 14’999.99                   | 0 %               |
| B2 | Grenzwert exakt 15k             | 15’000                      | 5 %               |
| B3 | Grenzwert exakt 20k             | 20’000                      | 5 %               |
| B4 | Grenzwert knapp über 20k        | 20’000.01                   | 7 %               |
| B5 | Grenzwert knapp unter 25k       | 24’999.99                   | 7 %               |
| B6 | Grenzwert exakt 25k             | 25’000                      | 8.5 %             |

---

### 2. Konkrete Testfälle

| ID | Eingabe: Preis (CHF) | Erwarteter Rabatt | Erwarteter Endpreis |
|----|----------------------|-------------------|---------------------|
| C1 | 14’999               | 0 %               | 14’999.00           |
| C2 | 15’000               | 5 %               | 14’250.00           |
| C3 | 18’500               | 5 %               | 17’575.00           |
| C4 | 20’000               | 5 %               | 19’000.00           |
| C5 | 20’001               | 7 %               | 18’600.93           |
| C6 | 24’999               | 7 %               | 23’249.07           |
| C7 | 25’000               | 8.5 %             | 22’875.00           |
| C8 | 40’000               | 8.5 %             | 36’600.00           |

---

## Übung 2 – Funktionale Black-Box-Tests für [sixt.ch](https://www.sixt.ch/)

| ID | Beschreibung                                               | Erwartetes Resultat                                                                                                                                        | Effektives Resultat | Status | Mögliche Ursache                                             |
|----|------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------|--------|--------------------------------------------------------------|
| R1 | Suche & One-Way: Abholort A, Rückgabeort B, gültige Zeiten | Trefferliste mit verfügbaren Fahrzeuggruppen & Preisen, One-Way wird akzeptiert; Tarifwahl sichtbar                                                        |                     |        | API-Suche down; Fehler bei Ort-/Datumsvalidierung            |
| R2 | Zahlungsmittel – Flexi (EC/Maestro)                        | Flexi-Tarif: EC/VPay/Maestro für ausgewählte Gruppen möglich; Kreditkarten immer akzeptiert; Barzahlung abgelehnt; Prepaid nur online (Kreditkarte/PayPal) |                     |        | Tarif-/Gruppenmapping falsch; Zahlart-Filter defekt          |
| R3 | Stornierung: Flexi vs. Prepaid                             | Flexi: jederzeit kostenfrei vor Mietbeginn; Prepaid: 99 CHF Gebühr vor Mietbeginn, keine Rückerstattung nach Abholzeit                                     |                     |        | Business-Rule falsch implementiert; Zeitfenster fehlerhaft   |
| R4 | Mindestalter: Fahrer 19 bei Basel/Genf/Lausanne            | Buchung wird akzeptiert gemäss Stationsregel (19 Jahre, ggf. Young-Driver-Gebühr); verweigert unzulässige Gruppen                                          |                     |        | Altersprüfung nur global, nicht stationsabhängig             |
| R5 | Zusatzfahrer später hinzufügen                             | Zusatzfahrer kann mit Original-Führerschein an einer anderen SIXT-Station nachgetragen werden                                                              |                     |        | Prozess in Filiale unbekannt; UI ohne entsprechenden Hinweis |

---

## Übung 3 – Simple Bank-Software

Projektquelle: [GitLab M450 – Unterlagen Teststrategie](https://gitlab.com/ch-tbz-it/Stud/m450/m450/-/tree/main/Unterlagen/teststrategie)

---

### 3.1 Funktionale Black-Box-Tests

| ID | Beschreibung                       | Erwartetes Resultat                                                                                                               | Effektives Resultat | Status | Mögliche Ursache |  
|----|------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|---------------------|--------|------------------|
| 1  | Applikation startet                | Applikation startet ohne Fehler                                                                                                   |                     |        |                  |
| 2  | Optionen sind verfügbar            | Alle Auswahloptionen werden in der CLI angezeigt                                                                                  |                     |        |                  |
| 3  | Anfangsoptionen funktionieren      | Korrekte Funktion der Optionen:<br>- Alle Konten anzeigen<br>- Konto erstellen<br>- Wechselkurs abfragen<br>- Programm beenden     |                     |        |                  |
| 4  | Kontenauswahl                      | Ein Konto lässt sich mit der dazugehörigen Nummer auswählen                                                                       |                     |        |                  |
| 5  | Kontooptionen                      | Die Funktionstüchtigkeit der Konto-Optionen ist gewährleistet                                                                     |                     |        |                  |

---

### 3.2 White-Box-Testfälle



**Mögliche Klassen & Methoden:**

- **Klasse `Bank`**
    - `createAccount()`
    - `getNumberOfAccounts()`
    - `printBalance()`
    - `printAccountDetails()`
    - `getAccount()`

- **Klasse `Counter`**
    - `chooseAccount()`
    - `editAccount()`
    - `transfer()`
    - `convertCurrency()`
    - `getExchangeRate()`

- **Klasse `ExchangeRateOkhttp`**
    - `getExchangeRate()`

- **Klasse `Account`**
    - `deposit()`
    - `withdraw()`
    - `getBalance()`

---

### 3.3 Verbesserungsvorschläge

- **Implementierung der `ExchangeRateOkhttp`-Klasse:** aktuell unvollständig eingebunden → vollständige Integration für stabilere Wechselkursabfragen.
- **JavaDoc-Generierung:** Automatisieren, damit Dokumentation immer aktuell bleibt.
- **Build-Prozess:** Hinzufügen eines Shade-Plugins, um ein ausführbares JAR zu erzeugen.
- **Best Practices:**
    - Verwendung von `BigDecimal` für Geldwerte.
    - Trennung von Schichten (Domain, Service, Adapter).
    - Saubere Exception-Klassen (`InsufficientFundsException`, `InvalidAmountException`).
    - Logging mit sinnvollen Levels.
    - Lesbare Namensgebung & klare Javadoc-Kommentare.

---
