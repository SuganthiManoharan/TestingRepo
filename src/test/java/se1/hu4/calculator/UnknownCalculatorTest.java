package se1.hu4.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
// Für JUnit5 Assertions, Annotationen etc. 

public class UnknownCalculatorTest {

    // Das Testobjekt dieser Testklasse:
	UnknownCalculator uc;
	

	// static: Wird einmalig ausgeführt, vor allen Tests auch jene mit @BeforeEach markierten.
    @BeforeAll
    static void setup(){
        System.out.println(">>@BeforeAll");
    }
     
    // Wird vor jedem einzelnen Test ausgeführt
    // Zweck: Ein "frisches" Testobjekt für Test vorbereiten: Instantieren, initialisieren, Ressourcen vorbereiten etc.
    @BeforeEach
    void setupThis(){
        uc= new UnknownCalculator();
    }
    
    


    // Ein Beispieltest mit assert.
    @Test
    void additionWithOff() {
        // assertNotEquals( 4 , uc.calc("2","2", '+'), "2 + 2 sollte 4 ergeben.");
        assertThrows(IllegalStateException.class, () -> {
            uc.calc("2","2", '+');
        });
    }

    @Test
    void additionWithOn() {
        uc.switchOn();
        assertEquals( 4 , uc.calc("2","2", '+'), "2 + 2 sollte 4 ergeben.");
    }

    @Test
    void subtractionWithOff() {
        // assertNotEquals( 4 , uc.calc("2","2", '+'), "2 + 2 sollte 4 ergeben.");
        assertThrows(IllegalStateException.class, () -> {
            uc.calc("2","2", '-');
        });
    }

    @Test
    void subtractionWithOn() {
        uc.switchOn();
        assertEquals( 2 , uc.calc("4","2", '-'), "4 - 2 sollte 0 ergeben.");
    }

    @Test
    void multiplicationWithOff() {
        // assertNotEquals( 4 , uc.calc("2","2", '+'), "2 + 2 sollte 4 ergeben.");
        assertThrows(IllegalStateException.class, () -> {
            uc.calc("2","2", '*');
        });
    }

    @Test
    void multiplicationWithOn() {
        uc.switchOn();
        assertEquals( 4 , uc.calc("2","2", '*'), "2 * 2 sollte 4 ergeben.");
    }

    @Test
    void divisionWithOff() {
        // assertNotEquals( 4 , uc.calc("2","2", '+'), "2 + 2 sollte 4 ergeben.");
        assertThrows(IllegalStateException.class, () -> {
            uc.calc("2","2", '/');
        });
    }

    @Test
    void divisionWithOn() {
        uc.switchOn();
        assertEquals( 1 , uc.calc("2","2", '/'), "2 / 2 sollte 1 ergeben.");
    }

    @Test
    void divisionByZero() {
        uc.switchOn();
        assertThrows( ArithmeticException.class , () -> {
            uc.calc("2","0", '/');
        });
    }

    @Test
    void boundaries() {
        uc.switchOn();
 
        assertThrows( IllegalArgumentException.class , () -> {
            uc.calc("1001","1", '+');
        }, "x boundary sollte bei 1000 sein");

        assertThrows( IllegalArgumentException.class , () -> {
            uc.calc("-1001","1", '+');
        }, "x boundary sollte bei -1000 sein");

        assertThrows( IllegalArgumentException.class , () -> {
            uc.calc("1","1001", '+');
        }, "y boundary sollte bei 1000 sein");

        assertThrows( IllegalArgumentException.class , () -> {
            uc.calc("1","-1001", '+');
        }, "y boundary sollte bei -1000 sein");

        assertDoesNotThrow(() -> {
            uc.calc("1","-1000", '+');
            }, "y boundary sollte bei -1000 sein"
        );
        assertDoesNotThrow(() -> {
                    uc.calc("1","1000", '+');
                }, "y boundary sollte bei 1000 sein"
        );

        assertDoesNotThrow(() -> {
                    uc.calc("1000","1", '+');
                }, "x boundary sollte bei 1000 sein"
        );
        assertDoesNotThrow(() -> {
                    uc.calc("-1000","1", '+');
                }, "x boundary sollte bei -1000 sein"
        );
    }


    @Test
    void switchOnAndOff() {
        uc.switchOn();
        assertTrue(uc.isOn());
        uc.switchOff();
        assertFalse(uc.isOn());
    }




    // Wird nach jedem einzelnen Test ausgeführt
    // Zweck: Das Testobjekt herunterfsahren: Ressourcen freigeben etc.

    @AfterEach
    void shutdownThis(){
    }
     
    @AfterAll
    static void shutdown(){
        System.out.println(">>@AfterAll");
    }
}
	
