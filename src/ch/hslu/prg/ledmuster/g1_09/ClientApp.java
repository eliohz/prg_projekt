package ch.hslu.prg.ledmuster.g1_09;
import ch.hslu.prg.ledboard.proxy.BoardService;
import java.util.Scanner;

public class ClientApp {

	public static void main(String[] args) {
		ledsOnOff();	
	}
	
	private static void ledsOnOff() {	
		int ledRows = 0;
		BoardService service = new BoardService(); //Neues Objekt für BoardService
		Scanner sc = new Scanner(System.in);
		
		// Einlesen von  LED Rows
		System.out.println("Anzahl LED Reihen(1-32): ");
		ledRows = sc.nextInt();
		
		// Input Validation
		if(ledRows <= BoardService.MAX_ROWS && ledRows > 0) {
			service.add(ledRows);
			System.out.println("es fängt an ");
			service.pauseExecution(2000);
			System.out.println("es hört auf");

			
		} else {
			System.out.println("Die Anzahl LED Reihen ist nicht gültig");
			return; 
		}
		
	}
}