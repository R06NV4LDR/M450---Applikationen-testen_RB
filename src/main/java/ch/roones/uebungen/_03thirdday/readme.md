# M450 - Third Day - Readme
## Table of Contents
- [Testlevels](#testlevels)
  - [Glossar](#glossar)
  - [Lernziel](#lernziel)
  - [Einführung](#einführung)
  - [Begrifflichkeiten: White Box vs. Black Box Testing](#begrifflichkeiten-white-box-vs-black-box-testing)
  - [Unit Testing](#unit-testing)
  - [Component Testing](#component-testing)
  - [Integration Testing](#integration-testing)
  - [System Testing](#system-testing)
  - [Acceptance Testing](#acceptance-testing)
  - [Recap](#recap)
- [Source](#source)
- [Checkpoint](#checkpoint)

## Testlevels

### Glossar

| Abkürzung | Erklärung                  |
|-----------|----------------------------|
| Bug       | Software Fehler / Error    |
| UAT       | User Acceptance Testing    |
| QA        | Quality Assurance          |
| SLA       | Service Level Agreement    |

---

### Lernziel

- Ich kenne die verschiedenen Stufen von Testing
- Ich kenne die Reihenfolge dieser Stufen im Entwicklungsprozess
- Ich kenne Begrifflichkeiten wie White-Box und Black-Box
- Ich weiss, welche Stufen von welchen Rollen abgedeckt sind
- Ich kenne den Unterschied zwischen funktionalen und nichtfunktionalen Anforderungen

---

### Einführung

Software Testing kann auf verschiedenen Stufen (Levels) im Software-Entwicklungsprozess stattfinden.  
Das Ausführen von Tests hilft der frühen Aufdeckung von Bugs und Mängeln in der Implementation.  
Ein grosser Vorteil des Testings ist auch, dass es zur besseren Qualität der Software beiträgt.

Die verschiedenen Stufen (in Englisch *Test Levels*) werden von verschiedenen Testarten abgedeckt:

- Unit Testing / Component Testing
- Integration Testing
- System Testing
- Acceptance Testing

Besonders **Unit / Component** und **Integration Testing** schauen wir uns im Detail an.  
Im klassischen Fall werden Integration Tests von einem Testing-Team ausgeführt, heute gibt es aber auch Möglichkeiten, diese in einem Backend (von Entwicklern) auszuführen.

Generell wird jede Stufe von Testing immer zeitintensiver (Unit Tests sollten am schnellsten ausführbar sein) und kommt später im Entwicklungsprozess zum Tragen.

---

### Begrifflichkeiten: White Box vs. Black Box Testing

- **White-Box-Test**:  
  Tests mit Kenntnissen über die innere Funktionsweise des zu testenden Systems.  
  → Blick in den Quellcode, am Code geprüft.

- **Black-Box-Test**:  
  Tests anhand der Spezifikation/Anforderung ohne Kenntnis der internen Implementierung.  
  → Nur sichtbares Verhalten wird getestet.

Jedes Testlevel kann aus White-Box- oder Black-Box-Sicht getestet werden.  
Manche Levels werden auch aus beiden Sichten geprüft.

---

### Unit Testing

- Erstes Level von Testing
- Von Entwicklern geschrieben und ausgeführt (später automatisiert im Build oder Deployment)
- White-Box-Test
- Einzelne Komponenten (z. B. Klassen oder Methoden) werden isoliert getestet
- Fehler werden früh entdeckt → Sicherheit für Refactorings
- Testet hauptsächlich funktionale Anforderungen
- **Limitation**: Nur weil Komponenten einzeln funktionieren, heißt das nicht, dass sie im Zusammenspiel korrekt arbeiten

---

### Component Testing

- Wird manchmal zum Unit Testing gezählt
- Von Entwicklern geschrieben und ausgeführt
- White-Box-Test
- Testet das Zusammenspiel mehrerer Komponenten
- Schnittstellen zu z. B. Datenbanken werden gemockt

**Beispiele für Schnittstellen:**
- Externe APIs
- Message Queues

---

### Integration Testing

- Von Testern oder QA-Teams ausgeführt
- Black-Box-Test
- Schnittstellen (z. B. DB, APIs, Queues) werden **nicht** gemockt, sondern aktiv benutzt
- Beispiel: API-Call → Datenbankzugriff (Tester kennt innere Logik nicht)

⚠️ Hinweis: Es gibt auch Integration Tests, die Entwickler schreiben und ausführen (White-Box-Test).

---

### System Testing

- Von denselben Teams wie Integration Testing ausgeführt
- Black-Box-Test
- Testet die gesamte Software → erfüllt alle Anforderungen?
- Testumgebung möglichst nahe an Live-Umgebung
- Funktionale **und** nichtfunktionale Anforderungen

**Nichtfunktionale Tests:**
- **Performance Testing** (Bottlenecks finden)
    - Load Testing → Verhalten bei bestimmter Last
    - Stress Testing → Belastungsgrenzen herausfinden
- **Usability Testing** → Benutzerfreundlichkeit
- **Security Testing** → z. B. Authentifizierung prüfen

---

### Acceptance Testing

- Vom Business oder Kunden ausgeführt
- Black-Box-Test
- Stellt sicher, dass das System die Akzeptanzkriterien erfüllt

⚠️ Hinweis: Acceptance Testing kann in verschiedene Typen unterteilt werden, hier aber nicht weiter vertieft.

---

### Recap

- Wichtig: Wissen, wo Entwickler vs. Tester ansetzen
- Alle Testlevels bauen aufeinander auf
- Start bei **Unit Tests** (kleinste, schnellste Tests)
- Mit jedem Level → abstrakter, umfassender, zeitintensiver

---

## Source

- [Wikipedia – Software Testing Levels](https://en.wikipedia.org/wiki/Software_testing#Testing_levels)
- [Art of Testing – Levels of Testing](https://artoftesting.com/levels-of-software-testing)
- [Copado – End-to-End vs. Regression Testing](https://www.copado.com/devops-hub/blog/end-to-end-testing-vs-regression-testing-whats-the-difference-crt)
- [Browserstack – System Testing](https://www.browserstack.com/guide/what-is-system-testing)
- [Browserstack – Acceptance Testing](https://www.browserstack.com/guide/acceptance-testing)
- [SitesBay – ST Levels](https://www.sitesbay.com/software-testing/st-levels-of-software-testing)
- [Wikipedia – White-Box-Test](https://de.wikipedia.org/wiki/White-Box-Test)
- [Wikipedia – Black-Box-Test](https://de.wikipedia.org/wiki/Black-Box-Test)
- [ReqTest – Levels of Testing](https://reqtest.com/en/knowledgebase/different-levels-of-testing/)
- [Professional QA – Levels of Testing](https://www.professionalqa.com/levels-of-testing)
- [Wikipedia – Acceptance Testing](https://en.wikipedia.org/wiki/Acceptance_testing)

---

## Checkpoint

- Ich kenne die jeweiligen Testarten (Unit, Component, Integration, System, Acceptance) und ihre Aufgaben
- Ich weiss, dass man Abhängigkeiten in Tests mit Mocks abstrahiert
- Ich verstehe den Unterschied zwischen White-Box und Black-Box Testing
- Ich verstehe den Unterschied zwischen funktionalen und n
