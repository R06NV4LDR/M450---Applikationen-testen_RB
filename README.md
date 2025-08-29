# M450 - Applikationen testen

[toc]

## Übungen

Arbeiten Sie zu zweit an diesen Aufgaben.
Stellen Sie sicher, dass Ihre Lösungen in Ihrem Repository abgelegt sind.
Zeigen Sie Ihre Lösungen anschliessend der Lehrperson.

### Aufgabe 1

Welche Formen von Tests kennen Sie aus der Informatik?
Arbeiten Sie zu zweit und erläutern Sie mind. drei Beispiele, die Sie aus der Praxis kennen.
Wie werden die Tests durchgeführt?

#### Antwort

1. **Unit Tests**: Diese Tests überprüfen einzelne Komponenten oder Funktionen einer Software, um sicherzustellen, dass sie wie erwartet funktionieren. Sie werden in der Regel von Entwicklern während der Entwicklungsphase geschrieben und automatisiert ausgeführt.
2. **Integrationstests**: Diese Tests überprüfen das Zusammenspiel verschiedener Komponenten oder Module einer Software. Sie stellen sicher, dass die Integration der einzelnen Teile reibungslos funktioniert. Integrationstests werden oft nach den Unit Tests durchgeführt.
3. **Systemtests**: Diese Tests überprüfen die gesamte Software als Ganzes, um sicherzustellen, dass sie den Anforderungen und Spezifikationen entspricht. Systemtests werden in der Regel von einem separaten Testteam durchgeführt und umfassen funktionale und nicht-funktionale Tests.
4. **Abnahmetests**: Diese Tests werden durchgeführt, um zu überprüfen, ob die Software den Anforderungen des Kunden entspricht und bereit für die Produktion ist. Abnahmetests werden oft vom Kunden oder Endbenutzern durchgeführt.
5. **Regressionstests**: Diese Tests werden durchgeführt, um sicherzustellen, dass neue Änderungen oder Updates in der Software keine bestehenden Funktionen beeinträchtigen. Regressionstests werden oft automatisiert und regelmäßig ausgeführt.
6. **Last- und Performancetests**: Diese Tests überprüfen, wie die Software unter verschiedenen Lastbedingungen funktioniert, um sicherzustellen, dass sie den Leistungsanforderungen entspricht. Sie werden oft in einer simulierten Umgebung durchgeführt.
7. **Sicherheitstests**: Diese Tests überprüfen die Software auf Sicherheitslücken und Schwachstellen, um sicherzustellen, dass sie vor potenziellen Bedrohungen geschützt ist. Sicherheitstests werden oft von spezialisierten Sicherheitsteams durchgeführt.
8. **Usability-Tests**: Diese Tests bewerten die Benutzerfreundlichkeit und das Benutzererlebnis der Software. Sie werden oft mit echten Benutzern durchgeführt, um Feedback zu sammeln und Verbesserungen vorzunehmen.
9. **Smoke Tests**: Diese Tests sind eine schnelle Überprüfung der grundlegenden Funktionen einer Software, um sicherzustellen, dass sie stabil genug ist, um weiter getestet zu werden. Smoke Tests werden oft nach einem Build durchgeführt.

---

### Aufgabe 2

- Nennen Sie ein Beispiel eines SW-Fehlers und eines SW-Mangels.
- Nennen Sie ein Beispiel für einen hohen Schaden bei einem SW-Fehler.

#### Antwort
- **Beispiel eines SW-Fehlers**: Ein Softwarefehler könnte ein Bug in einer Banking-App sein, der dazu führt, dass Überweisungen nicht korrekt verarbeitet werden, was zu doppelten Abbuchungen führt.
- **Beispiel eines SW-Mangels**: Ein Softwaremangel könnte das Fehlen einer wichtigen Funktion in einer Projektmanagement-Software sein, wie z.B. die Möglichkeit, Gantt-Diagramme zu erstellen, was die Benutzerfreundlichkeit und Effizienz beeinträchtigt.

- **Beispiel für einen hohen Schaden bei einem SW-Fehler**: Ein schwerwiegender Softwarefehler in einem Flugzeugsteuerungssystem könnte zu einem Absturz führen, was zu erheblichen Verlusten an Menschenleben und materiellen Schäden führt. Ein weiteres Beispiel wäre ein Fehler in der Software eines Krankenhaussystems, der dazu führt, dass Patientenakten falsch verwaltet werden, was zu falschen Behandlungen und potenziell lebensbedrohlichen Situationen führen kann.

### Aufgabe 3

Eine Software gliedert sich in der Regel in eine Reihe von Teilsystemen, die wiederum aus einer Vielzahl elementarer
Komponenten besteht. Wir haben im V-Modell gesehen, dass es verschiedene Teststufen gibt. Wir wollen in diesem
Zusammenhang nun ein Beispiel der untersten Stufe anschauen.
Beispiel Test in der Klasse Preisberechnung
In der Auto-Verkauf Software werden Preise mit Rabatten versehen.
Wir haben folgende Elemente und Regeln:
Es besteht ein Grundpreis (baseprice), abzüglich Händlerrabatt (discount).
Dazu kommen Sondermodellaufschlag (specialprice) und der Preis für weitere Zusatzaustattungen (extraprice).
Wenn drei oder mehr Zusatzausstattungen (extras) ausgewählt werden, dann erfolgt ein Rabatt von 10% auf diesen
Ausstattungen. Wenn es fünf oder mehr Zusatzausstattungen sind, dann ist der Rabatt bei 15%.
Der Händlerrabatt bezieht sich auf den Grundpreis. Der Zubehörrabatt gilt nur für den Preis der Zubehörteile.
Ein Code würde somit so aussehen:

```java
    double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount) {
        double addon_discount;
        double result;
        
        if (extras >= 5) 
            addon_discount = 10;
        else if (extras >= 3)
            addon_discount = 15;
        else 
            addon_discount = 0;
        
        if (discount > addon_discount)
            addon_discount = discount;
        
        result = baseprice/100.0 * (100-discount) + specialprice
                + extraprice/100.0 * (100-addon_discount);
        
        return result;
    }
```

Setzen Sie diesen Code in Ihrer Entwicklerumgebung um. Erstellen Sie nun einen entsprechenden Testtreiber, um diese
Preisberechnung zu testen. Ein Testtreiber ist ein Programm, das die jeweiligen Schnittstellenaufrufe (Methoden-Aufruf)
ausführt und anschliessend das Resultat zurückerhält. Skizzenhaft würde das so aussehen:

```java
boolean test_calculate_price(){

    double price;
    boolean test_ok = true;

    < your code>

}
```

Stellen Sie Ihre Tests ins Repository und zeigen Sie Ihre Lösung der Lehrperson.

### Aufgabe 3 - Bonus

Das Programmstück ist fehlerhaft ;) Finden Sie den Fehler im Code. Was müsste man korrigieren?

Der Code oben liefert bei **3 oder 5 Extras** falsche Ergebnisse, weil:

- Die `if`-Reihenfolge vertauscht ist --> `extras >= 5`setzt 10 statt 15.
- Die Semantik "Rabatte dürfen nicht vermischt werden" ist falsch implementiert (`discount > addon_discount` ...)