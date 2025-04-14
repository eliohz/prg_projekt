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
		// service mitgeben (Aufgabe 5)
		// @@@@ drawSquare(boardService); // Metode drawBorder aufrufen und
		// service mitgeben (Aufgabe 6.1)
		// @@@@@ drawSquareWithDiagonals(boardService);
		// service mitgeben (Aufgabe 6.2)
		// @@@@@ drawRectangle(boardService);
		// service mitgeben (Aufgabe 7)
		// @@@@@ drawTriangle(boardService);
		// service mitgeben (Aufgabe 8)
		// @@@@@ createRunningLight(boardService);
		// service mitgeben (Aufgabe 9)
		countColors(boardService);
		// service mitgeben (Aufgabe 10)
		
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

		int decimalValue = Integer.parseUnsignedInt(binaryValue, 2); // Binärer String in Dezimal umwandeln (Aufgabe
																		// 4.3)
		// Funktioniert, wir wissen nicht Warum @@@@@@@ Abklären

		System.out.println(binaryValue);
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
		int xTopLeft = sc.nextInt() - 1; // -1 da Index in der Tabelle 0-31 (Aufgabe 6.1.2)

		System.out.println("Geben Sie die Y Koordinate vom Startpunkt ein(1-32): ");
		int yTopLeft = sc.nextInt() - 1; // -1 da Index in der Tabelle 0-31 (Aufgabe 6.1.2)

		System.out.println("Geben Sie die Länge des Quadrates(1-32): ");
		int squareLenght = sc.nextInt() - 1; // -1 da Index in der Tabelle 0-31 (Aufgabe 6.1.3)

		// Square Zeichnen (Aufgabe 6.1.4)
		if (xTopLeft + squareLenght <= 31 && yTopLeft + squareLenght <= 31 && xTopLeft >= 0 && yTopLeft >= 0
				&& squareLenght >= 0) { // Checken on Input Valid
			for (int row = xTopLeft; row <= xTopLeft + squareLenght; row++) {
				for (int column = yTopLeft; column <= yTopLeft + squareLenght; column++) {
					if (column == yTopLeft || column == yTopLeft + squareLenght || row == xTopLeft
							|| row == xTopLeft + squareLenght) { // Zeichnen
						allLeds[column][row].turnOn();
					}
				}
			}

		} else {
			System.out.println("Falscher Input");
			return;
		}
	}

	private static void drawSquareWithDiagonals(BoardService boardService) {
		boardService.add(BoardService.MAX_ROWS); // Maximale Anzahl LED Reihen hinzugefügt. (Aufgabe 6.1)

		Scanner sc = new Scanner(System.in);

		Led[][] allLeds = boardService.getAllLeds();

		System.out.println("Geben Sie die X Koordinate vom Startpunkt ein(1-32): ");
		int xTopLeft = sc.nextInt() - 1; // -1 da Index in der Tabelle 0-31 (Aufgabe 6.1.2)

		System.out.println("Geben Sie die Y Koordinate vom Startpunkt ein(1-32): ");
		int yTopLeft = sc.nextInt() - 1; // -1 da Index in der Tabelle 0-31 (Aufgabe 6.1.2)

		System.out.println("Geben Sie die Länge des Quadrates(1-32): ");
		int squareLenght = sc.nextInt() - 1; // -1 da Index in der Tabelle 0-31 (Aufgabe 6.1.3)

		// Square Zeichnen (Aufgabe 6.1.4) @@@@@@@@@@@@@@@@@@@ Aufgabe 6.2 optional
		// methode
		if (xTopLeft + squareLenght <= 31 && yTopLeft + squareLenght <= 31 && xTopLeft >= 0 && yTopLeft >= 0
				&& squareLenght >= 0) { // Checken on Input Valid
			for (int row = xTopLeft; row <= xTopLeft + squareLenght; row++) {
				for (int column = yTopLeft; column <= yTopLeft + squareLenght; column++) {
					if (column == yTopLeft || column == yTopLeft + squareLenght || row == xTopLeft
							|| row == xTopLeft + squareLenght) { // Zeichnen
						allLeds[column][row].turnOn();
					}
				}
			}
			// Diagonale zeichnen von beiden Seiten aus (Aufgabe 6.2)
			for (int i = 1; i < squareLenght; i++) {
				// oben links zu unten rechts
				allLeds[yTopLeft + i][xTopLeft + i].turnOn();
				// oben rechts zu unten links
				allLeds[yTopLeft + i][xTopLeft + squareLenght - i].turnOn();
			}

		} else {
			System.out.println("Falscher Input");
			return;
		}

	}

	private static void drawRectangle(BoardService boardService) {
		boardService.add(BoardService.MAX_ROWS); // Maximale Anzahl LED Reihen hinzugefügt. (Aufgabe 7.1)

		Scanner sc = new Scanner(System.in);

		// Deklaration Variabeln und Array
		Led[][] allLeds = boardService.getAllLeds();
		boolean inputCorrect = false;
		int xTopLeft, yTopLeft, xBottomRight, yBottomRight;

		// Abfrage der Variabeln mit Input Validation (Aufgabe 7.4)
		do {
			System.out.println("Geben Sie die X Koordinate vom Punkt oben Links ein(1-32): ");
			xTopLeft = sc.nextInt() - 1; // -1 da Index in der Tabelle 0-31 (Aufgabe 7.2)

			System.out.println("Geben Sie die Y Koordinate vom Punkt oben Links ein(1-32): ");
			yTopLeft = sc.nextInt() - 1; // -1 da Index in der Tabelle 0-31 (Aufgabe 7.2)

			System.out.println("Geben Sie die X Koordinate vom Punkt unten Rechts ein(1-32): ");
			xBottomRight = sc.nextInt() - 1; // -1 da Index in der Tabelle 0-31 (Aufgabe 7.3)

			System.out.println("Geben Sie die Y Koordinate vom Punkt unten Rechts ein(1-32): ");
			yBottomRight = sc.nextInt() - 1; // -1 da Index in der Tabelle 0-31 (Aufgabe 7.3)

			if (xBottomRight - xTopLeft >= 2 && yBottomRight - yTopLeft >= 2) {
				inputCorrect = true;
				
			} else {
				System.out.println("Ungueltige Eingabe!");
			}
		} while (inputCorrect == false);

		// Rechteck zeichnen (Aufgabe 7.5)
		for (int row = xTopLeft; row <= xBottomRight; row++) {
			for (int col = yTopLeft; col <= yBottomRight; col++) {
				allLeds[row][col].turnOn();
			}
		}
		
		// Pause 3sek (Aufgabe 7.6)
		boardService.pauseExecution(3000);
		
		// Nur Rand des Rechtecks, innen ausschalten (Aufgabe 7.7)
		for (int row = xTopLeft + 1; row < xBottomRight; row++) {
			for (int col = yTopLeft + 1; col < yBottomRight; col++) {
				allLeds[row][col].turnOff();
			}
		}
		
		// Pause 3sek (Aufgabe 7.8)
		boardService.pauseExecution(3000);

		// LED von Rot auf Blau wechseln (Aufgabe 7.9)
		for (int row = xTopLeft; row <= xBottomRight; row++) {
			for (int col = yTopLeft; col <= yBottomRight; col++) {
				if (row == xTopLeft || row == xBottomRight || col == yTopLeft || col == yBottomRight) {
					boardService.replace(allLeds[row][col], LedColor.BLUE);
				}
			}
		}
		boardService.pauseExecution(2000);
		boardService.removeAllLeds();
	}
	
	private static void drawTriangle(BoardService boardService) {
        Scanner sc = new Scanner(System.in);
        
        // Hoehe des Dreiecks einlesen (Aufgabe 8.1)
        System.out.println("Geben Sie die Hoehe des Dreiecks ein (mindestens 2): ");
        int height = sc.nextInt();
        
        // Input Validation (Aufgabe 8.1)
        if (height < 2 || height > 17) {
            System.out.println("Ungueltige Hoehe");
            return;
        }
        
        boardService.add(height);  // Füge LED-Reihen entsprechend der Höhe hinzu (Aufgabe 8.2)
        Led[][] allLeds = boardService.getAllLeds();
        
        // Zeichne das Dreieck zeilenweise (Aufgabe 8.3)
        for (int i = 0; i < height; i++) {
            int numLeds = 2 * i + 1;
            int offset = (allLeds[i].length - numLeds) / 2; // Zentrieren des Dreiecks
            for (int col = offset; col < offset + numLeds; col++) {
                allLeds[i][col].turnOn();
            }
            boardService.pauseExecution(200);
        }
        boardService.pauseExecution(2000);
        boardService.removeAllLeds();
    }
	
	private static void createRunningLight(BoardService boardService) {
        // Eine einzelne Reihe an LEDs erstelle (Aufgabe 9.1)
		boardService.add(1); 
		
        Led[][] allLeds = boardService.getAllLeds();
        
        // Setze die vier farbigen Bereiche (Aufgabe 9.2):
        // - Spalte 24-31: grüner Bereich
        // - Spalte 16-23: roter Bereich
        // - Spalte 8-15: blauer Bereich
        // - Spalte 0-7: gelber Bereich
        for (int col = 0; col < allLeds[0].length; col++) {
            if (col >= 24) {
                boardService.replace(allLeds[0][col], LedColor.GREEN);
            } else if (col >= 16) {
            	boardService.replace(allLeds[0][col], LedColor.RED);
            } else if (col >= 8) {
            	boardService.replace(allLeds[0][col], LedColor.BLUE);
            } else {
            	boardService.replace(allLeds[0][col], LedColor.YELLOW);
            }
        }
        
        // Alle Leds neu einlesen und einschalten (Aufgabe 9.3)
        allLeds = boardService.getAllLeds();
        
        for (int i = 0; i < 32; i++) {
        	allLeds[0][i].turnOn();
        }
        
        // Verschiebe die LEDs um 32 Positionen pro Zyklus; insgesamt 3 vollständige Zyklen (96 Schritte)
        for (int cycle = 0; cycle < 96; cycle++) {
            allLeds = boardService.getAllLeds();

            Led vorherigesLed = allLeds[0][boardService.LEDS_PER_ROW-1];
            LedColor vorherigeFarbe = vorherigesLed.getColor();
            
            for (int i = boardService.LEDS_PER_ROW-1; i > 0; i--) {
                allLeds = boardService.getAllLeds();

                boardService.replace(allLeds[0][i], allLeds[0][i-1].getColor());
            }
            
            boardService.replace(allLeds[0][0], vorherigeFarbe);
            boardService.pauseExecution(10);
        }
        boardService.removeAllLeds();
    }
	
	private static void countColors(BoardService boardService) {
        boardService.add(BoardService.MAX_ROWS, LedColor.RANDOM);
        Led[][] allLeds = boardService.getAllLeds();
        // Schalte alle LEDs ein
        for (int row = 0; row < allLeds.length; row++) {
            for (int col = 0; col < allLeds[row].length; col++) {
                allLeds[row][col].turnOn();
            }
        }
        boardService.pauseExecution(2000);
        
        int countRed = 0, countGreen = 0, countBlue = 0, countYellow = 0;
        
        for (int row = 0; row < allLeds.length; row++) {
            for (int col = 0; col < allLeds[row].length; col++) {
                LedColor color = allLeds[row][col].getColor();
                if (color == LedColor.RED) {
                    countRed++;
                } else if (color == LedColor.GREEN) {
                    countGreen++;
                } else if (color == LedColor.BLUE) {
                    countBlue++;
                } else if (color == LedColor.YELLOW) {
                    countYellow++;
                }
            }
        }
        System.out.println("RED: " + countRed + " LEDs");
        System.out.println("GREEN: " + countGreen + " LEDs");
        System.out.println("BLUE: " + countBlue + " LEDs");
        System.out.println("YELLOW: " + countYellow + " LEDs");
        
        boardService.removeAllLeds();
    }
    
    // -----------------------------------------------
    // Aufgabe 10.2: countColorsExt
    // Bestimmt für jede Farbe die Spalte, in der die meisten LEDs dieser Farbe vorhanden sind, und gibt Spaltennummer und Anzahl aus.
    private static void countColorsExt(BoardService boardService) {
        boardService.add(BoardService.MAX_ROWS, LedColor.RANDOM);
        Led[][] allLeds = boardService.getAllLeds();
        // Schalte alle LEDs ein
        for (int row = 0; row < allLeds.length; row++) {
            for (int col = 0; col < allLeds[row].length; col++) {
                allLeds[row][col].turnOn();
            }
        }
        boardService.pauseExecution(2000);
        
        int maxRedCount = 0, redColumn = 0;
        int maxGreenCount = 0, greenColumn = 0;
        int maxBlueCount = 0, blueColumn = 0;
        int maxYellowCount = 0, yellowColumn = 0;
        
        int columns = allLeds[0].length;
        int rows = allLeds.length;
        
        for (int col = 0; col < columns; col++) {
            int redCount = 0, greenCount = 0, blueCount = 0, yellowCount = 0;
            for (int row = 0; row < rows; row++) {
                LedColor color = allLeds[row][col].getColor();
                if (color == LedColor.RED) {
                    redCount++;
                } else if (color == LedColor.GREEN) {
                    greenCount++;
                } else if (color == LedColor.BLUE) {
                    blueCount++;
                } else if (color == LedColor.YELLOW) {
                    yellowCount++;
                }
            }
            if (redCount >= maxRedCount) {
                maxRedCount = redCount;
                redColumn = col;
            }
            if (greenCount >= maxGreenCount) {
                maxGreenCount = greenCount;
                greenColumn = col;
            }
            if (blueCount >= maxBlueCount) {
                maxBlueCount = blueCount;
                blueColumn = col;
            }
            if (yellowCount >= maxYellowCount) {
                maxYellowCount = yellowCount;
                yellowColumn = col;
            }
        }
        
        System.out.println("RED: " + maxRedCount + " LEDs in der Spalte Nr. " + redColumn);
        System.out.println("GREEN: " + maxGreenCount + " LEDs in der Spalte Nr. " + greenColumn);
        System.out.println("BLUE: " + maxBlueCount + " LEDs in der Spalte Nr. " + blueColumn);
        System.out.println("YELLOW: " + maxYellowCount + " LEDs in der Spalte Nr. " + yellowColumn);
        
        boardService.removeAllLeds();
    }
    
    // -----------------------------------------------
    // Aufgabe 10.3: countRedLedsOnDiagonals
    // Zählt und gibt die Anzahl der roten LEDs auf der Hauptdiagonale und der Hilfsdiagonale aus.
    private static void countRedLedsOnDiagonals(BoardService boardService) {
        boardService.add(BoardService.MAX_ROWS, LedColor.RANDOM);
        Led[][] allLeds = boardService.getAllLeds();
        // Optional: Schalte alle LEDs ein, falls gewünscht
        // for (int row = 0; row < allLeds.length; row++) {
        //     for (int col = 0; col < allLeds[row].length; col++) {
        //         allLeds[row][col].turnOn();
        //     }
        // }
        
        int mainDiagonalRed = 0;
        int secondaryDiagonalRed = 0;
        int size = allLeds.length; // Annahme: quadratisches LED-Board (z. B. 32x32)
        for (int i = 0; i < size; i++) {
            if (allLeds[i][i].getColor() == LedColor.RED) {
                mainDiagonalRed++;
            }
        }
        for (int i = 0; i < size; i++) {
            if (allLeds[i][allLeds[i].length - 1 - i].getColor() == LedColor.RED) {
                secondaryDiagonalRed++;
            }
        }
        
        System.out.println("RED LEDs Haupt-Diagonale: " + mainDiagonalRed);
        System.out.println("RED LEDs Hilfs-Diagonale: " + secondaryDiagonalRed);
        
        boardService.removeAllLeds();
    }
}

}
