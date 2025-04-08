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

		// @@@@@ ledsOnOff(boardService); // Mehtode ledsOnOff aufrufen und service
		// mitgeben (Aufgabe 1.1)
		// @@@@@ ledsColoredOnOff(boardService); // Methode ledsColoredOnOff aufrufen
		// und service mitgeben (Aufgabe 1.2)
		// @@@@@ switchEvenOdd(boardService); // Metode switchEvenOdd aufrufen und
		// service mitgeben (Aufgabe 2)
		// @@@@@ switchRandom(boardService); // Metode switchRandom aufrufen und
		// service mitgeben (Aufgabe 3)
		// @@@@@ showDecimal(boardService); // Metode showDecimal aufrufen und
		// service mitgeben (Aufgabe 4)
		// @@@@@ drawBorder(boardService); // Metode drawBorder aufrufen und
		// service mitgeben (Aufgabe 4)
		drawSquare(boardService);
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
			boardService.add(ledRows, LedColor.RANDOM); // LED Rows werden an Board gegeben mit Farbe Random (Aufgabe
														// 3.2)
			// Alle LEDS ins Array einlesen
			Led[][] allLeds = boardService.getAllLeds();

			boardService.pauseExecution(2000); // (Aufgabe 3.3)

			Random random = new Random(); // Random Zahl generieren (Aufgabe 3.4)

			int allRandomLeds = 32 * ledRows / 2; // Alle Random Zahlen

			// Alle Random LEDs einschalten (Aufgabe 3.4)
			for (int counter = 0; counter < allRandomLeds; counter++) {
				int randomLedColumn = random.nextInt(32);
				int randomLedRow = random.nextInt(ledRows);

				// Überprüfen ob LED an ist
				if (allLeds[randomLedRow][randomLedColumn].isOn()) {
					counter--;
				} else {
					allLeds[randomLedRow][randomLedColumn].turnOn();
					boardService.pauseExecution(10);
				}

			}

			boardService.pauseExecution(2000); // (Aufgabe 3.5)

			// LEDs Invertieren (Aufgabe 3.6)
			for (int counter = 0; counter < 5; counter++) { // 5 Mal ausführen (Aufgabe 3.8)
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

				boardService.pauseExecution(500); // (Aufgabe 3.7)
			}

			boardService.pauseExecution(2000); // (Aufgabe 3.9)

			boardService.removeAllLeds(); // (Aufgabe 3.10)

		} else {
			System.out.println("Die Anzahl LED Reihen ist nicht gültig");
			return;
		}

	}

	private static void showDecimal(BoardService boardService) {
		boardService.add(1); // eine LED reihe hinzufügen (Aufgabe 4.1)
		
		// Alle LEDS ins Array einlesen
		Led[][] allLeds = boardService.getAllLeds();

		String binaryValue = ""; // Variable deklarieren (Aufgabe 4.2)
		
		// Random Zahl generieren		
		Random random = new Random(); 
	
		// LEDs Random einschalten in Binär (Aufgabe 4.2)
		for (int counter = 0; counter < 32; counter++) {
			if (random.nextBoolean()) {
				allLeds[0][counter].turnOn();
				binaryValue += "1";
			} else {
				binaryValue += "0";
			}

		}
		
		int decimalValue = Integer.parseUnsignedInt(binaryValue, 2); // Binärer String in Dezimal umwandeln (Aufgabe 4.3)
		// Funktioniert, wir wissen nicht Warum @@@@@@@ Abklären
		
		System.out.println("Binary Value: " + decimalValue);
	}
	
	private static void drawBorder(BoardService boardService) {
		boardService.add(BoardService.MAX_ROWS); // Maximale Anzahl LED Reihen hinzugefügt. (Aufgabe 5.1)
		
		boardService.pauseExecution(2000); // (Aufgabe 5.1)
	
		// Alle LEDS ins Array einlesen
		Led[][] allLeds = boardService.getAllLeds();
		
		// Rand Zeichnen (Aufgabe 5.2)
		for (int row = 0; row < 32; row++) {
			for (int column = 0; column < 32; column++) {
				// Wenn am Anfang/Ende der Zeile oder Erste/Letzte Reihe
				if (column == 0 || column == 31 || row == 0 || row == 31) { 
					allLeds[column][row].turnOn();
				}
			}
		}
		
		boardService.pauseExecution(2000); // (Aufgabe 5.3)
		
		// LEDs am Rand wieder ausschalten (Aufgabe 5.4)
		for (int row = 0; row < 32; row++) {
			for (int column = 0; column < 32; column++) {
				// Wenn am Anfang/Ende der Zeile oder Erste/Letzte Reihe
				if (column == 0 || column == 31 || row == 0 || row == 31) { 
					allLeds[column][row].turnOff();
				}
			}
		}
		
		boardService.pauseExecution(2000); // (Aufgabe 5.5)
		
		boardService.removeAllLeds(); // (Aufgabe 5.6)
	}

	private static void drawSquare(BoardService boardService) {
		boardService.add(BoardService.MAX_ROWS); // Maximale Anzahl LED Reihen hinzugefügt. (Aufgabe 6.1)
		
		Scanner sc = new Scanner(System.in);
		
		Led[][] allLeds = boardService.getAllLeds();
		
		System.out.println("Geben Sie die X Koordinate vom Startpunkt ein(1-32): ");
		int xTopLeft = sc.nextInt() - 1; // -1 da Index in der Tabelle 0-31
		
		System.out.println("Geben Sie die Y Koordinate vom Startpunkt ein(1-32): ");
		int yTopLeft = sc.nextInt() - 1 ; // -1 da Index in der Tabelle 0-31
		
		System.out.println("Geben Sie die Länge des Quadrates(1-32): ");
		int squareLenght = sc.nextInt() - 1;
		
		if(xTopLeft + squareLenght <= 31 && yTopLeft + squareLenght <= 31 && xTopLeft >= 0 && yTopLeft >= 0 && squareLenght >= 0 ) {
			for (int row = xTopLeft; row <= xTopLeft + squareLenght; row++) {
				for (int column = yTopLeft; column <= yTopLeft + squareLenght; column++) {
					// Wenn am Anfang/Ende der Zeile oder Erste/Letzte Reihe
					if (column == yTopLeft || column == yTopLeft + squareLenght || row == xTopLeft || row == xTopLeft + squareLenght) { 
						allLeds[column][row].turnOn();
					}
				}
			}
			
		} else {
			System.out.println("Falscher Input");
			return;
		}			
		
	}
}
