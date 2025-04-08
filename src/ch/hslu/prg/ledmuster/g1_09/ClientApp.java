package ch.hslu.prg.ledmuster.g1_09;

import ch.hslu.prg.ledboard.proxy.BoardService;
import ch.hslu.prg.ledboard.proxy.Led;
import ch.hslu.prg.ledboard.proxy.LedColor;

import java.util.Random;
import java.util.Scanner;

public class ClientApp {

	public static void main(String[] args) {
		BoardService boardService = new BoardService(); // Neues Objekt für BoardService
		// LedColor ledColor = new LedColor(); // Neues Objekt für ledColors

		// @@@@@ ledsOnOff(boardService); // Mehtode ledsOnOff aufrufen und service mitgeben (Aufgabe 1.1)
		// @@@@@ ledsColoredOnOff(boardService); // Methode ledsColoredOnOff aufrufen und service mitgeben (Aufgabe 1.2)
		// @@@@@ switchEvenOdd(boardService); // Metode switchEvenOdd aufrufen und service mitgeben (Aufgabe 2)
		switchRandom(boardService);
	}

	private static void ledsOnOff(BoardService boardService) {
		boardService.pauseExecution(2000); // 2 Sekunden warten (Aufgabe 1.1.3)

		Scanner sc = new Scanner(System.in);

		// Rows definieren
		int ledRows = 0;

		// Einlesen von LED rows (Aufgabe 1.1.1)
		System.out.println("Anzahl LED Reihen(1-32): ");
		ledRows = sc.nextInt();

		if (ledRows <= BoardService.MAX_ROWS && ledRows > 0) { // Input Validation (Aufgabe 1.1.1)
			boardService.add(ledRows); // LED Rows werden an Board gegeben (Aufgabe 1.1.2)
			// Alle LEDS ins Array einlesen
			Led[][] allLeds = boardService.getAllLeds();

			for (int i = 0; i < 3; i++) { // 3 Mal ausführen (Aufgabe 1.1.8)

				// LEDs von rechts nach links einschalten (Aufgabe 1.1.4)
				for (int row = allLeds.length - 1; row >= 0; row--) {
					for (int column = allLeds[row].length - 1; column >= 0; column--) {
						// Einzelnes LED nehmen und einschalten
						Led currentLED = allLeds[row][column];
						currentLED.turnOn();

						// Kurz Pausieren damit es ersichtlich wird
						boardService.pauseExecution(10);
					}
				}

				boardService.pauseExecution(250); // (Aufgabe 1.1.5)

				// Einzelnes LED nehmen und ausschalten (Aufgabe 1.1.6)
				for (int row = 0; row <= allLeds.length - 1; row++) {
					for (int column = 0; column <= allLeds[row].length - 1; column++) {
						Led currentLED = allLeds[row][column];
						currentLED.turnOff();

						// Kurz Pausieren damit es ersichtlich wird
						boardService.pauseExecution(10);
					}
				}

				boardService.pauseExecution(250); // (Aufgabe 1.1.7)
			}

			boardService.pauseExecution(2000); // 2 Sekunden warten (Aufgabe 1.1.9)

			boardService.removeAllLeds(); // Leds Zurücksetzen (Aufgabe 1.1.10)

		} else {
			System.out.println("Die Anzahl LED Reihen ist nicht gültig");
			return;
		}

	}

	private static void ledsColoredOnOff(BoardService boardService) {

		boardService.pauseExecution(2000); // 2 Sekunden warten (Aufgabe 1.1.3)

		Scanner sc = new Scanner(System.in);

		// Rows definieren
		int ledRows = 0;

		// Farbe definieren
		int ledColor = 0;

		// Einlesen von LED rows (Aufgabe 1.1.1)
		System.out.println("Anzahl LED Reihen(1-32): ");
		ledRows = sc.nextInt();

		if (ledRows <= BoardService.MAX_ROWS && ledRows > 0) {
			// Einlesen von LED Farbe (Aufgabe 1.2)
			System.out.println("LED Farbe(0 = Rot, 1 = Blau, 2 = Gruen, 3 = Gelb, 4 = Random): ");
			ledColor = sc.nextInt();

			if (ledColor == 0) {
				boardService.add(ledRows);
			} else if (ledColor == 1) {
				boardService.add(ledRows, LedColor.BLUE);
			} else if (ledColor == 2) {
				boardService.add(ledRows, LedColor.GREEN);
			} else if (ledColor == 3) {
				boardService.add(ledRows, LedColor.YELLOW);
			} else if (ledColor == 4) {
				boardService.add(ledRows, LedColor.RANDOM);
			} else {
				System.out.println("Die LED Farbe ist nicht gültig");
				return;
			}

			// Alle LEDS ins Array einlesen
			Led[][] allLeds = boardService.getAllLeds();

			for (int i = 0; i < 3; i++) { // 3 Mal ausführen (Aufgabe 1.1.8)

				// LEDs von rechts nach links einschalten (Aufgabe 1.1.4)
				for (int row = allLeds.length - 1; row >= 0; row--) {
					for (int column = allLeds[row].length - 1; column >= 0; column--) {
						// Einzelnes LED nehmen und einschalten
						Led currentLED = allLeds[row][column];
						currentLED.turnOn();

						// Kurz Pausieren damit es ersichtlich wird
						boardService.pauseExecution(10);
					}
				}

				boardService.pauseExecution(250); // (Aufgabe 1.1.5)

				// Einzelnes LED nehmen und ausschalten (Aufgabe 1.1.6)
				for (int row = 0; row <= allLeds.length - 1; row++) {
					for (int column = 0; column <= allLeds[row].length - 1; column++) {
						Led currentLED = allLeds[row][column];
						currentLED.turnOff();

						// Kurz Pausieren damit es ersichtlich wird
						boardService.pauseExecution(10);
					}
				}

				boardService.pauseExecution(250); // (Aufgabe 1.1.7)
			}

			boardService.pauseExecution(2000); // 2 Sekunden warten (Aufgabe 1.1.9)

			boardService.removeAllLeds(); // Leds Zurücksetzen (Aufgabe 1.1.10)

		} else {
			System.out.println("Die Anzahl LED Reihen ist nicht gültig");
			return;
		}
	}

	private static void switchEvenOdd(BoardService boardService) {
		Scanner sc = new Scanner(System.in);

		// Rows definieren
		int ledRows = 0;

		// Einlesen von LED rows (Aufgabe 2.1)
		System.out.println("Anzahl LED Reihen(1-32): ");
		ledRows = sc.nextInt();

		if (ledRows <= BoardService.MAX_ROWS && ledRows > 0) { // Input Validation
			boardService.add(ledRows); // LED Rows werden an Board gegeben (Aufgabe 2.1)

			boardService.pauseExecution(2000); // 2 Sekunden warten (Aufgabe 2.2)

			// Alle LEDS ins Array einlesen
			Led[][] allLeds = boardService.getAllLeds();

			for (int i = 0; i < 3; i++) { // Drei Mal wiederholen (Aufgabe 2.7)
				// Alle geraden LEDs anschalten (Aufgabe 2.3)
				for (int row = 0; row <= allLeds.length - 1; row++) {
					for (int column = 0; column <= allLeds[row].length - 1; column++) {
						Led currentLED = allLeds[row][column];
						// Wenn LED % 2 0 ist
						if (currentLED.getLedId() % 2 == 0) {
							// Anschalten
							currentLED.turnOn();
							boardService.pauseExecution(10);
						}
					}
				}

				boardService.pauseExecution(1000);

				// LEDs Invertieren (Aufgabe 2.5)
				for (int row = 0; row <= allLeds.length - 1; row++) {
					for (int column = 0; column <= allLeds[row].length - 1; column++) {
						Led currentLED = allLeds[row][column];
						// überprüfen ob LED an ist
						if (currentLED.isOn()) {
							// LED Ausschalten ()
							currentLED.turnOff();
							boardService.pauseExecution(10);
						} else {
							// LED einschalten
							currentLED.turnOn();
							boardService.pauseExecution(10);
						}
					}
				}

				boardService.pauseExecution(1000); // (Aufgabe 2.6)
			}
			
			// Alle LEDs Ausschalten (Aufgabe 2.8)
			for (int row = 0; row <= allLeds.length - 1; row++) {
				for (int column = 0; column <= allLeds[row].length - 1; column++) {
					Led currentLED = allLeds[row][column];
					// überprüfen ob LED an ist
					if (currentLED.isOn()) {
						// LED Ausschalten ()
						currentLED.turnOff();
						boardService.pauseExecution(10);
					} 
				}
			}
			
			boardService.pauseExecution(2000); // 2 Sek. Warten (Aufgabe 2.9)
			
			boardService.removeAllLeds(); // Alle LEDs Entfernen (Aufgabe 2.10)
			
		} else {
			System.out.println("Die Anzahl LED Reihen ist nicht gültig");
			return;
		}
	}

	private static void switchRandom(BoardService boardService) {
		Scanner sc = new Scanner(System.in);

		// Rows definieren
		int ledRows = 0;

		// Einlesen von LED rows (Aufgabe 3.1)
		System.out.println("Anzahl LED Reihen(1-32): ");
		ledRows = sc.nextInt();
		
		if (ledRows <= BoardService.MAX_ROWS && ledRows > 0) { // Input Validation 
			boardService.add(ledRows, LedColor.RANDOM); // LED Rows werden an Board gegeben mit Farbe Random (Aufgabe 3.2)
			// Alle LEDS ins Array einlesen
			Led[][] allLeds = boardService.getAllLeds();
			
			boardService.pauseExecution(2000); // (Aufgabe 3.3)

			Random random = new Random(); // Random Zahl generieren (Aufgabe 3.4)
			
			// Alle Random Zahlen
			int allRandomLeds = 32 * ledRows / 2;
							
			// Alle Random LEDs einschalten (Aufgabe 3.4)
			for (int counter = 0; counter < allRandomLeds; counter++) {
				// 31 instead of 32 because random takes the range 0-32 and not 1-32
				int randomLedColumn = random.nextInt(32);
				int randomLedRow = random.nextInt(ledRows);
				
				// check if LED is already on
				if (allLeds[randomLedRow][randomLedColumn].isOn()) {
					counter--;
				} else {
					allLeds[randomLedRow][randomLedColumn].turnOn();
					boardService.pauseExecution(10);
				}
				
			}
			
			boardService.pauseExecution(2000);
			
			for (int counter = 0; counter < 5; counter ++) {
				for (int row = 0; row <= allLeds.length - 1; row++) {
					for (int column = 0; column <= allLeds[row].length - 1; column++) {
						Led currentLED = allLeds[row][column];
						// überprüfen ob LED an ist
						if (currentLED.isOn()) {
							// LED Ausschalten ()
							currentLED.turnOff();
							boardService.pauseExecution(10);
						} else {
							// LED einschalten
							currentLED.turnOn();
							boardService.pauseExecution(10);
						}
					}
				}
				
				// task 3.7 pause for 0.5 seconds
				boardService.pauseExecution(500);
			}
			
			// task 3.9 pause for 2 seconds
			boardService.pauseExecution(2000);
			
			// task 3.10 remove all LEDs
			boardService.removeAllLeds();

		} else {
			System.out.println("Die Anzahl LED Reihen ist nicht gültig");
			return;
		}		
		
	}
}
