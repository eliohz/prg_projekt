package ch.hslu.prg.ledmuster.g1_09;
import ch.hslu.prg.ledboard.proxy.BoardService;
import ch.hslu.prg.ledboard.proxy.Led;
import java.util.Scanner;

public class ClientApp {

	public static void main(String[] args) {
		BoardService boardService = new BoardService(); //Neues Objekt für BoardService
		// LedColor ledColor = new LedColor(); // Neues Objekt für ledColors

		ledsOnOff(boardService);	//Mehtode ledsOnOff aufrufen und service mitgeben
	}
	
	private static void ledsOnOff(BoardService boardService) {	
		boardService.pauseExecution(2000); // 2 Sekunden warten (Aufgabe 1.1.3)
		
		Scanner sc = new Scanner(System.in);
		
		// Rows definieren
		int ledRows = 0;
		
		// Einlesen von LED rows (Aufgabe 1.1.1)
		System.out.println("Anzahl LED Reihen(1-32): ");
		ledRows = sc.nextInt();
		
		if(ledRows <= BoardService.MAX_ROWS && ledRows > 0) { // Input Validation (Aufgabe 1.1.1)
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
					for (int column = 0;  column <= allLeds[row].length - 1; column++) {
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
}