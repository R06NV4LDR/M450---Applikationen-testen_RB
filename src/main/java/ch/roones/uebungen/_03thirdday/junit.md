# JUnit 5

Für Java-Tests mit der **JUnit Jupiter** API(JUnit 5).

## 1) Grundlegende Test-Struktur

```java
import org.junit.jupiter.api.*;

class CalculatorTest {

    Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    void add_shouldSumTwoNumbers() {
        double result = calc.add(2.0, 3.5);
        Assertions.assertEquals(5.5, result);
    }
}
```

### Wofür?

- `@Test` markiert eine Testmethode.

- `@BeforeEach` richtet pro Testfall die Test-Fixture ein.

---

## 2) Lebenszyklus & Fixtures

- `@BeforeAll` / `@AfterAll` – einmal pro Testklasse (z. B. Datenbank starten/stoppen). **Müssen** `static` **sein**,
  außer man
  verwendet `@TestInstance(PER_CLASS)`.

- `@BeforeEach` / `@AfterEach` – vor/nach jedem Test (z. B. frische Objekte).

```java

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LifecycleExample {

    @BeforeAll
    void initAll() { /* einmalig */ }

    @BeforeEach
    void init() { /* vor jedem Test */ }

    @AfterEach
    void tearDown() { /* nach jedem Test */ }

    @AfterAll
    void tearDownAll() { /* einmalig */ }
}
```

**Anwendungsfall:** Gemeinsame Ressourcen initialisieren und wieder freigeben.

---

## 3) Assertions (Kernstück)

```java
import static org.junit.jupiter.api.Assertions.*;

@Test
void assertions_examples() {
    assertEquals(42, service.answer());
    assertTrue(list.isEmpty(), "Liste sollte leer sein");

    Exception ex = assertThrows(IllegalArgumentException.class,
            () -> service.save(null));
    assertEquals("id required", ex.getMessage());

    assertAll("customer",
            () -> assertEquals("Ana", customer.firstName()),
            () -> assertEquals("Müller", customer.lastName())
    );

    assertTimeout(Duration.ofMillis(200),
            () -> heavyOp.run());
}
```

### Anwendungsfall:

- Ergebnisse prüfen (`assertEquals`, `assertTrue`, …)
- Fehlerfälle testen (`assertThrows`)
- Mehrere Behauptungen bündeln (`assertAll`)
- Laufzeitgrenzen (`assertTimeout`)

---

## 4) Annahmen (Assumptions)

```java
import static org.junit.jupiter.api.Assumptions.*;

@Test
void runsOnlyOnCi() {
    assumeTrue("true".equals(System.getenv("CI")), "Nur auf CI ausführen");
    // … Testlogik …
}
```

**Anwendungsfall:**
---

## 5) Anzeige, Tags, Deaktivierung

```java

@DisplayName("Schöne Beschreibung ♥")
@Tag("fast")
class MetaExample {

    @Test
    @DisplayName("Addiert korrekt")
    void add() { /* … */ }

    @Test
    @Disabled("Fix pending")
    void notYet() { /* wird übersprungen */ }
}
```

**Anwendungsfall:**


---

## 6) Parameterisierte Tests

```java
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

class ParamExample {

    @ParameterizedTest
    @ValueSource(strings = {"madam", "racecar", "kayak"})
    void isPalindrome(String text) {
        assertTrue(Utils.isPalindrome(text));
    }

    @ParameterizedTest
    @CsvSource({
            "2,3,5",
            "10,5,15"
    })
    void add(int a, int b, int expected) {
        assertEquals(expected, Calculator.add(a, b));
    }
}
```

**Anwendungsfall:**

---

## 7) Verschachtelte & wiederholte Tests

```java

@Nested
class WhenCartIsEmpty {
    @Test
    void totalIsZero() { /* … */ }
}

@RepeatedTest(5)
void flakyCheck() { /* … */ }
```

**Anwendungsfall:**

---

## 8) Temporäre Verzeichnisse

```java
class FileTest {
    @TempDir
    Path tempDir;

    @Test
    void writesFile() throws IOException {
        Path file = tempDir.resolve("out.txt");
        Files.writeString(file, "hello");
        assertTrue(Files.exists(file));
    }
}
```

**Anwendungsfall:**

## 9) Dynamische Tests

```java

@TestFactory
Collection<DynamicTest> dynamic() {
    List<Integer> inputs = List.of(1, 2, 3);
    return inputs.stream()
            .map(i -> DynamicTest.dynamicTest("isPositive " + i,
                    () -> assertTrue(i > 0)))
            .toList();
}
```

**Anwendungsfall:**

---

## 10) Erweiterungen (Extensions)

```java
@ExtendWith(TimingExtension.class)
class WithExtensionTest { /* … */ }

```

**Anwendungsfall:** Cross-Cutting Concerns wie Timing, Logging, Ressourcen-Handling, Mockito-Integration etc.

Häufig genutzt: MockitoExtension (`@ExtendWith(MockitoExtension.class)`).

---

## 11) Testreihenfolge & -instanz

```java
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderedTest {

  @Test @Order(1) void create() { /* … */ }

  @Test @Order(2) void read() { /* … */ }
}

```

**Anwendungsfall:** In Ausnahmefällen, wenn Reihenfolge fachlich sinnvoll ist (z. B. API-Flow-Demo).

    Tipp: **Tests normalerweise unabhängig halten.**

---

## 12) Gradle-Setup (JUnit 5 aktivieren)

In `build.gradle` (Groovy):

```groovy
plugins {
    id 'java'
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation platform('org.junit:junit-bom:5.10.0')
    testImplementation 'org.junit.jupiter:junit-jupiter'
}

test {
    useJUnitPlatform()  // WICHTIG für JUnit 5
}
```

**Anwendungsfall:** Sorgt dafür, dass die JUnit-5-Engine verwendet wird und parametrisierte Tests etc. erkannt werden.

---

## 13) Häufige Muster

- **AAA (Arrange-Act-Assert):**

```java
// Arrange
var calc = new Calculator();
// Act
var result = calc.add(2, 3);

// Assert
assertEquals(5,result);
```

- **Given-When-Then** (verbal, gleiche Idee wie AAA).
- **Testdaten-Builder** für saubere Objekt-Erstellung in Tests.

---

## 14) Tipps aus der Praxis

- Eine Assertion pro Verhalten; mehrere Assertions via `assertAll` logisch bündeln.
- Teste sichtbare Effekte (Output, State, Kollaborationen), nicht Implementierungsdetails.
- Nutze `@Tag` (z. B. `slow`, `integration`), um lange Tests separat laufen zu lassen.
- Vermeide geteilten Zustand zwischen Tests; nutze Fixtures sauber.

## Referenz

- [JUnit 5 User Guide (offiziell)](https://junit.org/junit5/docs/current/user-guide/)